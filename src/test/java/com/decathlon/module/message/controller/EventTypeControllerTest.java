package com.decathlon.module.message.controller;

import com.decathlon.core.common.Response;
import com.decathlon.module.message.dao.EventTypeDao;
import com.decathlon.module.message.model.*;
import com.decathlon.module.message.service.IEventTypeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
@AutoConfigureMockMvc
public class EventTypeControllerTest {

    @Autowired
    IEventTypeService eventTypeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetEventTypeUuid()  {

        EventTypeEntity eventTypeEntityTest = new EventTypeEntity();

        eventTypeEntityTest.setUuid("uuid");

        EventTypeDao eventTypeDao = mock(EventTypeDao.class);

        when(eventTypeDao.findByUuid("uuid")).thenReturn(eventTypeEntityTest);

        EventTypeEntity eventTypeEntityUuid = eventTypeService.getEventTypeByUuid("uuid");

        Assert.assertEquals(eventTypeEntityUuid.getUuid(),"uuid");

        EventTypeEntity eventTypeEntity = new EventTypeEntity();

        eventTypeEntity.setUuid("listForTesting");

        Response response = Response.ok("list success",eventTypeEntity);

        EventTypeController eventTypeController = mock(EventTypeController.class);

        when(eventTypeController.getEventTypeByUuid("uuid")).thenReturn(response);

        Response  AfterResponse = eventTypeController.getEventTypeByUuid("uuid");

        Assert.assertEquals(AfterResponse.getCode(),"00");

        Assert.assertEquals(AfterResponse.getMsg(),"list success");

        EventTypeEntity afterEventTypeEntity = (EventTypeEntity)AfterResponse.getData();

        Assert.assertEquals(afterEventTypeEntity.getUuid(),"listForTesting");

    }

    @Test
    public void testListEventTypeMessageInfo() {

        EventTypeEntity eventTypeEntity = new EventTypeEntity();

        eventTypeEntity.setUuid("listForTesting");

        Response response = Response.ok("list success",eventTypeEntity);

        EventTypeController eventTypeController = mock(EventTypeController.class);

        EventTypeDTO eventTypeDto = new EventTypeDTO();

        when(eventTypeController.listEventTypeInfo(eventTypeDto)).thenReturn(response);

        Response  AfterResponse = eventTypeController.listEventTypeInfo(eventTypeDto);

        Assert.assertEquals(AfterResponse.getCode(),"00");

        Assert.assertEquals(AfterResponse.getMsg(),"list success");

        EventTypeEntity afterEventTypeEntity = (EventTypeEntity)AfterResponse.getData();

        Assert.assertEquals(afterEventTypeEntity.getUuid(),"listForTesting");
    }

    @Test
    public void testUpdateEventTypeStatus() {

        EventTypeEntity eventTypeEntity = new EventTypeEntity();

        eventTypeEntity.setUuid("eventTypeEntityForTest");

        Response response = Response.ok("update success",eventTypeEntity);

        EventTypeController eventTypeController = mock(EventTypeController.class);

        EventTypeDTO eventTypeDto = new EventTypeDTO();

        when(eventTypeController.updateEventTypeUuid(eventTypeDto)).thenReturn(response);

        Response  AfterResponse = eventTypeController.updateEventTypeUuid(eventTypeDto);

        Assert.assertEquals(AfterResponse.getCode(),"00");

        Assert.assertEquals(AfterResponse.getMsg(),"update success");

        EventTypeEntity afterEventTypeEntity = (EventTypeEntity) AfterResponse.getData();

        Assert.assertEquals(afterEventTypeEntity.getUuid(),"eventTypeEntityForTest");

    }

    @Test
    public void testEventTypeMessageSave(){

        EventTypeDTO eventTypeDto = new EventTypeDTO();

        eventTypeDto.setUuid("eventType");

        TemplateWeChatEntity templateWeChatEntity = new TemplateWeChatEntity();

        templateWeChatEntity.setUuid("templateEventTypeControllerTest");

        Response response = Response.ok("insert success",templateWeChatEntity);

        EventTypeController templateWeChatController = mock(EventTypeController.class);

        when(templateWeChatController.insertEventTypeMessage(eventTypeDto)).thenReturn(response);

        Response  AfterResponse = templateWeChatController.insertEventTypeMessage(eventTypeDto);

        Assert.assertEquals(AfterResponse.getCode(),"00");

        Assert.assertEquals(AfterResponse.getMsg(),"insert success");

        TemplateWeChatEntity afterTemplateWeChatEntity= (TemplateWeChatEntity)AfterResponse.getData();

        Assert.assertEquals(afterTemplateWeChatEntity.getUuid(),"templateEventTypeControllerTest");

    }

}
