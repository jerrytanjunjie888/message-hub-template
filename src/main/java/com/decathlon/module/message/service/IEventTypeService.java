package com.decathlon.module.message.service;

import com.decathlon.module.message.model.EventTypeDTO;
import com.decathlon.module.message.model.EventTypeEntity;
import org.springframework.data.domain.Page;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
public interface IEventTypeService {

    EventTypeEntity getEventTypeByUuid(String uuid);

    Page<EventTypeEntity> listEventTypeMessage(EventTypeDTO eventTypeDto);

    EventTypeEntity insertEventTypeMessage(EventTypeDTO eventTypeDto);

    int updateEventTypeByUuid(EventTypeDTO eventTypeDto);
}
