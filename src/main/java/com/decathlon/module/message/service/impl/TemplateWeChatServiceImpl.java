package com.decathlon.module.message.service.impl;

import com.decathlon.module.message.constant.ConstWords;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import com.decathlon.core.error.ErrorCode;
import com.decathlon.core.exception.CustomException;
import com.decathlon.core.util.IdGenerator;
import com.decathlon.module.message.dao.TemplateWeChatDao;
import com.decathlon.module.message.model.TemplateWeChatDTO;
import com.decathlon.module.message.model.TemplateWeChatEntity;
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
public class TemplateWeChatServiceImpl {

    @Autowired
    private TemplateWeChatDao templateWeChatDao;

    public Page<TemplateWeChatEntity> listTemplateEmailMessageInfo(TemplateWeChatDTO templateWeChatDto){
        Specification querySpe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();
                if(StringUtils.isNotBlank(templateWeChatDto.getUuid())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("uuid"),  templateWeChatDto.getUuid() ));
                }
                if(StringUtils.isNotBlank(templateWeChatDto.getEventTypeUuid())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("eventTypeUuid"),  templateWeChatDto.getEventTypeUuid() ));
                }

                if(StringUtils.isNotBlank(templateWeChatDto.getTemplateLanguageCode())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("templateLanguageCode"), templateWeChatDto.getTemplateLanguageCode()));
                }

                if(StringUtils.isNotBlank(templateWeChatDto.getTemplateCountryCode())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("templateCountryCode"), templateWeChatDto.getTemplateCountryCode()));
                }

                if(StringUtils.isNotBlank(templateWeChatDto.getCommunicationChannel())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("communicationChannel"), templateWeChatDto.getCommunicationChannel()));
                }

                if (StringUtils.isNotBlank(templateWeChatDto.getStartEffectiveTime())) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startEffectiveTime").as(String.class), templateWeChatDto.getStartEffectiveTime()));
                }

                if (StringUtils.isNotBlank(templateWeChatDto.getLastEffectiveTime())) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("lastEffectiveTime").as(String.class), templateWeChatDto.getLastEffectiveTime()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC,"gmtCreated");

        templateWeChatDto.setPageSize(templateWeChatDto.getPageSize()==0?10:templateWeChatDto.getPageSize());
        templateWeChatDto.setPageNumber(templateWeChatDto.getPageNumber()==0?0:templateWeChatDto.getPageNumber());
        PageRequest pageRequest = PageRequest.of(templateWeChatDto.getPageNumber(), templateWeChatDto.getPageSize(),sort);
        return templateWeChatDao.findAll(querySpe,pageRequest);
    }

    public TemplateWeChatEntity getTemplateWeChatByUuid(String uuid) {
        return  templateWeChatDao.findByUuid(uuid);
    }

    public TemplateWeChatEntity getTemplateWeChatByEventType(String  eventTypeUuid) {
        return templateWeChatDao.findByEventTypeUuid(eventTypeUuid);
    }

    public TemplateWeChatEntity insertTemplateWeChatMessageInfo(TemplateWeChatDTO templateWeChatDto){
        try {
            if(StringUtils.isEmpty(templateWeChatDto.getOfficialAccount())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter officialAccount cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getTemplateSubject())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateSubject cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getTemplateContent())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateContent cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getTemplateLanguageCode())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateLanguageCode cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getTemplateCountryCode())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateCountryCode cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getTemplateAttributes())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter templateAttributes cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getCardConnection())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter cardConnection cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getSmallRoutine())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter smallRoutine cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getPagePath())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter pagePath cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getStartEffectiveTime())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter startEffectiveTime cannot be null");
            }
            if(StringUtils.isEmpty(templateWeChatDto.getLastEffectiveTime())) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter lastEffectiveTime cannot be null");
            }
            TemplateWeChatEntity templateWeChatEntity = new TemplateWeChatEntity();
            BeanUtils.copyProperties(templateWeChatDto,templateWeChatEntity);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if(StringUtils.isNotEmpty(templateWeChatDto.getStartEffectiveTime())) {
                templateWeChatEntity.setStartEffectiveTime(sdf.parse(templateWeChatDto.getStartEffectiveTime()));
            }

            if(StringUtils.isNotEmpty(templateWeChatDto.getLastEffectiveTime())) {
                templateWeChatEntity.setLastEffectiveTime(sdf.parse(templateWeChatDto.getLastEffectiveTime()));
            }

            templateWeChatEntity.setUuid(ConstWords.TEMPLATE_WE_CHAT +IdGenerator.createId());
            templateWeChatEntity.setEventTypeUuid(ConstWords.WE_CHAT_EVENT_TYPE + IdGenerator.createId());
            templateWeChatEntity.setGmtCreated(new Date());
            templateWeChatEntity.setIsDeleted(1);
            return  templateWeChatDao.save(templateWeChatEntity);
        } catch (ParseException e) {
            throw new CustomException(ErrorCode.InvalidArgumentException.getErrCode(), "time parse exception");
        }
    }

    public  int  updateTemplateWeChatByUuid(TemplateWeChatDTO templateWeChatDto) {
        if(StringUtils.isEmpty(templateWeChatDto.getUuid())) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter Uuid cannot be null");
        }

        if(templateWeChatDto.getIsDeleted() == 0) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),"request parameter IsDeleted cannot be null");
        }
        return templateWeChatDao.updateTemplateWeChatByUuid(templateWeChatDto.getIsDeleted(),templateWeChatDto.getUuid(),new Date());
    }

}
