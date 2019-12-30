package com.decathlon.module.message.service.impl;

import com.decathlon.module.message.constant.ConstWords;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import com.decathlon.core.error.ErrorCode;
import com.decathlon.core.exception.CustomException;
import com.decathlon.core.util.IdGenerator;
import com.decathlon.module.message.dao.TemplateEmailDao;
import com.decathlon.module.message.model.TemplateEmailDTO;
import com.decathlon.module.message.model.TemplateEmailEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
@Slf4j
@Component
public class TemplateEmailServiceImpl {

    @Autowired
    private TemplateEmailDao templateEmailDao;

    public Page<TemplateEmailEntity> listTemplateEmailMessageInfo(TemplateEmailDTO templateEmailDto){
        Specification querySpe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();
                if(StringUtils.isNotBlank(templateEmailDto.getUuid())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("uuid"),  templateEmailDto.getUuid() ));
                }

                if(StringUtils.isNotBlank(templateEmailDto.getEventTypeUuid())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("eventTypeUuid"), templateEmailDto.getEventTypeUuid() ));
                }

                if(StringUtils.isNotBlank(templateEmailDto.getTemplateLanguageCode())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("templateLanguageCode"), templateEmailDto.getTemplateLanguageCode()));
                }

                if(StringUtils.isNotBlank(templateEmailDto.getTemplateCountryCode())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("templateCountryCode"), templateEmailDto.getTemplateCountryCode()));
                }

                if(StringUtils.isNotBlank(templateEmailDto.getCommunicationChannel())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("communicationChannel"), templateEmailDto.getCommunicationChannel()));
                }

                if (StringUtils.isNotBlank(templateEmailDto.getStartEffectiveTime())) {
                    //greater or equals
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startEffectiveTime").as(String.class), templateEmailDto.getStartEffectiveTime()));
                }

                if (StringUtils.isNotBlank(templateEmailDto.getLastEffectiveTime())) {
                    //less or equals
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("lastEffectiveTime").as(String.class), templateEmailDto.getLastEffectiveTime()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC,"gmtCreated");

        templateEmailDto.setPageNumber(templateEmailDto.getPageNumber()==0?0:templateEmailDto.getPageNumber());
        templateEmailDto.setPageSize(templateEmailDto.getPageSize()==0?10:templateEmailDto.getPageSize());
        PageRequest pageRequest = PageRequest.of(templateEmailDto.getPageNumber(), templateEmailDto.getPageSize(),sort);
        return templateEmailDao.findAll(querySpe,pageRequest);
    }

    public TemplateEmailEntity getTemplateEmailByUuid(String  uuid){
        return templateEmailDao.findByUuid(uuid);
    }

    public TemplateEmailEntity getTemplateEmailByEventType(String eventTypeId){
        return  templateEmailDao.findByEventTypeUuid(eventTypeId);
    }

    public TemplateEmailEntity insertTemplateEmailMessageInfo(TemplateEmailDTO templateEmailDto){
        try {
            if(StringUtils.isEmpty(templateEmailDto.getTemplateSubject())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateSubject cannot be null");
            }

            if(StringUtils.isEmpty(templateEmailDto.getTemplateLanguageCode())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateLanguageCode cannot be null");
            }

            if(StringUtils.isEmpty(templateEmailDto.getTemplateCountryCode())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateCountryCode cannot be null");
            }

            if(StringUtils.isEmpty(templateEmailDto.getTemplateContent())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateContent cannot be null");
            }

            if(StringUtils.isEmpty(templateEmailDto.getTemplateAttributes())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateAttributes cannot be null");
            }

            if(StringUtils.isEmpty(templateEmailDto.getStartEffectiveTime())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter StartEffectiveTime cannot be null");
            }

            if(StringUtils.isEmpty(templateEmailDto.getLastEffectiveTime())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter LastEffectiveTime cannot be null");
            }

            if(StringUtils.isEmpty(templateEmailDto.getEdmChannel())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter EdmChannel cannot be null");
            }

            if(StringUtils.isEmpty(templateEmailDto.getDocumentUrl())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter DocumentUrl cannot be null");
            }

            if(StringUtils.isEmpty(templateEmailDto.getDocumentName())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter DocumentName cannot be null");
            }

            TemplateEmailEntity templateEmailEntity = new TemplateEmailEntity();
            BeanUtils.copyProperties(templateEmailDto,templateEmailEntity);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if(StringUtils.isNotEmpty(templateEmailDto.getStartEffectiveTime())) {
                templateEmailEntity.setStartEffectiveTime(sdf.parse(templateEmailDto.getStartEffectiveTime()));
            }

            if(StringUtils.isNotEmpty(templateEmailDto.getLastEffectiveTime())) {
                templateEmailEntity.setLastEffectiveTime(sdf.parse(templateEmailDto.getLastEffectiveTime()));
            }

            templateEmailEntity.setUuid(ConstWords.TEMPLATE_EMAIL + IdGenerator.createId());
            templateEmailEntity.setEventTypeUuid(ConstWords.EMAIL_EVENT_TYPE + IdGenerator.createId());
            templateEmailEntity.setGmtCreated(new Date());
            templateEmailEntity.setIsDeleted(1);
            return  templateEmailDao.save(templateEmailEntity);
        } catch (ParseException e) {
            throw new CustomException(ErrorCode.InvalidArgumentException.getErrCode(), "time parse exception");
        }catch (CustomException e) {
            throw new CustomException(ErrorCode.SqlErrorException.getErrCode(), "insert template message failed");
        }
    }

    public  int  updateTemplateEmailByUuid(TemplateEmailDTO templateEmailDto) {
        if(StringUtils.isEmpty(templateEmailDto.getUuid())) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter Uuid cannot be null");
        }
        if(templateEmailDto.getIsDeleted() == 0) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter IsDeleted cannot be null");
        }
        return templateEmailDao.updateTemplateEmailByUuid(templateEmailDto.getIsDeleted(),templateEmailDto.getUuid(),new Date());
    }

}
