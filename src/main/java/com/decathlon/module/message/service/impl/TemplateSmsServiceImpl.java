package com.decathlon.module.message.service.impl;

import com.decathlon.module.message.constant.ConstWords;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import com.decathlon.core.error.ErrorCode;
import com.decathlon.core.exception.CustomException;
import com.decathlon.core.util.IdGenerator;
import com.decathlon.module.message.dao.TemplateSmsDao;
import com.decathlon.module.message.model.TemplateSmsDTO;
import com.decathlon.module.message.model.TemplateSmsEntity;
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
public class TemplateSmsServiceImpl{

    @Autowired
    private TemplateSmsDao templateSmsDao;

    public Page<TemplateSmsEntity> listTemplateSmsMessageInfo(TemplateSmsDTO templateSmsDto){
        Specification querySpe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();
                if(StringUtils.isNotBlank(templateSmsDto.getUuid())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("uuid"),  templateSmsDto.getUuid() ));
                }
                if(StringUtils.isNotBlank(templateSmsDto.getEventTypeUuid())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("eventTypeUuid"), templateSmsDto.getEventTypeUuid()));
                }

                if(StringUtils.isNotBlank(templateSmsDto.getTemplateLanguageCode())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("templateLanguageCode"), templateSmsDto.getTemplateLanguageCode()));
                }

                if(StringUtils.isNotBlank(templateSmsDto.getTemplateCountryCode())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("templateCountryCode"), templateSmsDto.getTemplateCountryCode()));
                }

                if(StringUtils.isNotBlank(templateSmsDto.getCommunicationChannel())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("communicationChannel"), templateSmsDto.getCommunicationChannel()));
                }

                if (StringUtils.isNotBlank(templateSmsDto.getStartEffectiveTime())) {
                    //greater or equals
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startEffectiveTime").as(String.class), templateSmsDto.getStartEffectiveTime()));
                }

                if (StringUtils.isNotBlank(templateSmsDto.getLastEffectiveTime())) {
                    //less or equals
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("lastEffectiveTime").as(String.class), templateSmsDto.getLastEffectiveTime()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC,"gmtCreated");

        templateSmsDto.setPageSize(templateSmsDto.getPageSize()==0?10:templateSmsDto.getPageSize());
        templateSmsDto.setPageNumber(templateSmsDto.getPageNumber()==0?0:templateSmsDto.getPageNumber());
        PageRequest pageRequest = PageRequest.of(templateSmsDto.getPageNumber(), templateSmsDto.getPageSize(),sort);
        return templateSmsDao.findAll(querySpe,pageRequest);
    }

    public TemplateSmsEntity getTemplateSmsByUuid(String uuid){
        return templateSmsDao.findByUuid(uuid);
    }

    public TemplateSmsEntity getTemplateSmsByEventType(String  eventTypeUuid){
        return templateSmsDao.findByEventTypeUuid(eventTypeUuid);
    }

    public TemplateSmsEntity insertTemplateSmsMessageInfo(TemplateSmsDTO templateSmsDto){
        try {
            if(StringUtils.isEmpty(templateSmsDto.getTemplateChannel())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateChannel cannot be null");
            }

            if(StringUtils.isEmpty(templateSmsDto.getTemplateContent())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateContent cannot be null");
            }

            if(StringUtils.isEmpty(templateSmsDto.getTemplateLanguageCode())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter LanguageCode cannot be null");
            }

            if(StringUtils.isEmpty(templateSmsDto.getTemplateCountryCode())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter countryCode cannot be null");
            }

            if(StringUtils.isEmpty(templateSmsDto.getTemplateAttributes())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateAttributes cannot be null");
            }

            if(StringUtils.isEmpty(templateSmsDto.getTemplateAttributes())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateAttributes cannot be null");
            }

            if(StringUtils.isEmpty(templateSmsDto.getStartEffectiveTime())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter startEffectiveTime cannot be null");
            }

            if(StringUtils.isEmpty(templateSmsDto.getLastEffectiveTime())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter lastEffectiveTime cannot be null");
            }

            TemplateSmsEntity templateSmsEntity =  new TemplateSmsEntity();
            BeanUtils.copyProperties(templateSmsDto,templateSmsEntity);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if(StringUtils.isNotEmpty(templateSmsDto.getStartEffectiveTime())) {
                templateSmsEntity.setStartEffectiveTime(sdf.parse(templateSmsDto.getStartEffectiveTime()));
            }

            if(StringUtils.isNotEmpty(templateSmsDto.getLastEffectiveTime())) {
                templateSmsEntity.setLastEffectiveTime(sdf.parse(templateSmsDto.getLastEffectiveTime()));
            }

            templateSmsEntity.setUuid(ConstWords.TEMPLATE_SMS + IdGenerator.createId());
            templateSmsEntity.setEventTypeUuid(ConstWords.SMS_EVENT_TYPE + IdGenerator.createId());
            templateSmsEntity.setGmtCreated(new Date());
            templateSmsEntity.setIsDeleted(1);
            return  templateSmsDao.save(templateSmsEntity);
        } catch (ParseException e) {
            throw new CustomException(ErrorCode.InvalidArgumentException.getErrCode(), "time parse exception");
        }catch (CustomException e) {
            throw new CustomException(ErrorCode.SqlErrorException.getErrCode(), "insert template message failed");
        }
    }

    public  int  updateTemplateSmsByUuid(TemplateSmsDTO templateSmsDto) {
        if(StringUtils.isEmpty(templateSmsDto.getUuid())) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter Uuid cannot be null");
        }

        if(templateSmsDto.getIsDeleted() == 0) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter IsDeleted cannot be null");
        }
        return templateSmsDao.updateTemplateSmsByUuid(templateSmsDto.getIsDeleted(),templateSmsDto.getUuid(),new Date());
    }

}
