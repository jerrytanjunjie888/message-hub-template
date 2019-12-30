package com.decathlon.module.message.controller;

import com.decathlon.core.error.ErrorCode;
import com.decathlon.module.message.model.EventTypeDTO;
import com.decathlon.module.message.service.IEventTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.decathlon.core.common.Response;
import com.decathlon.core.exception.CustomException;
import com.decathlon.module.message.model.EventTypeEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
@Slf4j
@RestController
@RequestMapping(value="/v2")
@Api(tags = "EventTypeManagement")
public class EventTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventTypeController.class);

    @Autowired
    @Qualifier("EventTypeServiceImpl")
    private IEventTypeService eventTypeService;

    @ApiOperation(value="events", httpMethod ="GET",  notes ="events")
    @GetMapping(value = "/events")
    public Response listEventTypeInfo(EventTypeDTO eventTypeDto) {
        try{
            eventTypeDto.setPageNumber(eventTypeDto.getPageNumber()==0?0:eventTypeDto.getPageNumber());
            eventTypeDto.setPageSize(eventTypeDto.getPageSize()==0?10:eventTypeDto.getPageSize());

            Page<EventTypeEntity> eventTypes = eventTypeService.listEventTypeMessage(eventTypeDto);
            return Response.ok(eventTypes);
        }  catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

    @ApiOperation(value="get event type based on uuid", httpMethod ="GET",  notes ="get event type based on uuid")
    @GetMapping(value = "/event/{uuid}")
    public Response getEventTypeByUuid(@PathVariable String uuid) {
        if(StringUtils.isBlank(uuid)){
            return  Response.fail(ErrorCode.MissingArgumentException.getErrCode(),"uuid cannot be empty");
        }

        try {
            EventTypeEntity eventTypeEntity = eventTypeService.getEventTypeByUuid(uuid);
            return Response.ok(eventTypeEntity);
        } catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

    @ApiOperation(value="insert event type", httpMethod ="POST",  notes ="insert event type")
    @PostMapping(value = "/insert/event")
    public Response insertEventTypeMessage(@RequestBody @Validated EventTypeDTO eventTypeDto) {
        try{
            EventTypeEntity eventTypeEntityResult = eventTypeService.insertEventTypeMessage(eventTypeDto);

            if(null == eventTypeEntityResult) {
                return Response.fail("insert failure");
            } else {
                return Response.ok("insert success",eventTypeEntityResult);
            }
        }  catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

    @ApiOperation(value = "update event type based on uuid", httpMethod = "PUT", notes = "update event type based on uuid")
    @PutMapping(value = "/update/event/uuid")
    public Response updateEventTypeUuid(@RequestBody EventTypeDTO eventTypeDTO) {
        if(StringUtils.isNotBlank(eventTypeDTO.getUuid())) {
            return Response.fail(ErrorCode.MissingArgumentException.getErrCode(),"uuid cannot be empty");
        }

        if(eventTypeDTO.getEnableStatusVal() == 0) {
            return Response.fail(ErrorCode.MissingArgumentException.getErrCode(),"enableStatus cannot be empty");
        }

        EventTypeEntity eventTypeEntity = eventTypeService.getEventTypeByUuid(eventTypeDTO.getUuid());
        if (null == eventTypeEntity)  {
            return Response.fail(ErrorCode.MissingArgumentException.getErrCode(),"eventTypeEntity cannot be empty");
        }

        try {
            int count = eventTypeService.updateEventTypeByUuid(eventTypeDTO);
            if(count > 0) {
                return Response.ok("update success",count);
            } else {
                return Response.fail("update failure");
            }
        } catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

}
