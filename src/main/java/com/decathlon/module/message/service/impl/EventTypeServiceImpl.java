package com.decathlon.module.message.service.impl;

import com.decathlon.module.message.constant.ConstWords;
import com.decathlon.module.message.service.IEventTypeService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import com.decathlon.core.util.IdGenerator;
import com.decathlon.module.message.dao.EventTypeDao;
import com.decathlon.module.message.model.EventTypeDTO;
import com.decathlon.module.message.model.EventTypeEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
@Service("EventTypeServiceImpl")
@Slf4j
public class EventTypeServiceImpl implements IEventTypeService {

    @Autowired
    private EventTypeDao eventTypeDao;

    @Override
    public Page<EventTypeEntity> listEventTypeMessage(EventTypeDTO eventTypeDto){
        Specification querySpe = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();
                if(StringUtils.isNotBlank(eventTypeDto.getEventName())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("eventName"), eventTypeDto.getEventName()));
                }

                if(StringUtils.isNotBlank(eventTypeDto.getEventSource())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("eventSource"), eventTypeDto.getEventSource()));
                }

                if(eventTypeDto.getEnableStatusVal() != 0) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("enableStatus"), eventTypeDto.getEnableStatus()));
                }

                if(StringUtils.isNotBlank(eventTypeDto.getEventParam())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("eventParam"), eventTypeDto.getEventParam()));
                }

                if(eventTypeDto.getIsDeletedVal() !=0) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("isDeleted"), eventTypeDto.getIsDeletedVal()));
                }

                if(StringUtils.isNotBlank(eventTypeDto.getModifier())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("modifier"), eventTypeDto.getModifier()));
                }

                if(StringUtils.isNotBlank(eventTypeDto.getNotifyUrl())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("notifyUrl"), eventTypeDto.getNotifyUrl()));
                }

                if(StringUtils.isNotBlank(eventTypeDto.getSystemId())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("systemId"), eventTypeDto.getSystemId()));
                }

                if(StringUtils.isNotBlank(eventTypeDto.getEventRemark())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("eventRemark"), eventTypeDto.getEventRemark()));
                }

                if(StringUtils.isNotBlank(eventTypeDto.getCreator())){
                    predicates.add(criteriaBuilder
                            .equal(root.get("creator"), eventTypeDto.getCreator()));
                }

                if(StringUtils.isNotBlank(eventTypeDto.getUuid())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("uuid"), eventTypeDto.getUuid()));
                }

                if (StringUtils.isNotBlank(eventTypeDto.getStartCreatedTime())) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("gmtCreated").as(String.class), eventTypeDto.getStartCreatedTime()));
                }

                if (StringUtils.isNotBlank(eventTypeDto.getLastCreatedTime())) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("gmtCreated").as(String.class), eventTypeDto.getLastCreatedTime()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC,"gmtCreated");
        PageRequest pageRequest = PageRequest.of(eventTypeDto.getPageNumber(), eventTypeDto.getPageSize(),sort);
        return eventTypeDao.findAll(querySpe,pageRequest);
    }

    @Override
    public EventTypeEntity getEventTypeByUuid(String  uuid){
        return eventTypeDao.findByUuid(uuid);
    }

    @Override
    public EventTypeEntity insertEventTypeMessage(EventTypeDTO eventTypeDto) {
        EventTypeEntity eventTypeEntity = new EventTypeEntity();

        BeanUtils.copyProperties(eventTypeDto,eventTypeEntity);
        eventTypeEntity.setUuid(ConstWords.EVENT_TYPE + IdGenerator.createId());
        eventTypeEntity.setGmtCreated(new Date());
        eventTypeEntity.setIsDeleted(1);
        return eventTypeDao.save(eventTypeEntity);
    }

    @Override
    public int updateEventTypeByUuid(EventTypeDTO eventTypeDto) {
        return eventTypeDao.updateEventTypeByUuid(eventTypeDto.getEnableStatus(),eventTypeDto.getUuid(),new Date());
    }

}
