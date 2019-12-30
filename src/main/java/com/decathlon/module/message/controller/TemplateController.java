package com.decathlon.module.message.controller;

import com.decathlon.core.common.Response;
import com.decathlon.core.error.ErrorCode;
import com.decathlon.core.exception.CustomException;
import com.decathlon.module.message.service.ITemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
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
@Api(tags = "TemplateManagement")
public class TemplateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    @Qualifier("TemplateServiceImpl")
    ITemplateService templateService;

    @ApiOperation(value = "insert template", httpMethod = "POST", notes = "insert template")
    @PostMapping(value = "/insert/template")
    public Response insertTemplate(@RequestBody String jsonData) {
        try {
            Object object = templateService.insertTemplate(jsonData);
            return  Response.ok(object);
        } catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

    @ApiOperation(value = "update template", httpMethod = "PUT", notes = "update template")
    @PutMapping(value = "/update/template")
    public Response updateTemplate(@RequestBody String jsonData) {
        try {
            int count = templateService.updateTemplate(jsonData);
            if(count > 0) {
                return Response.ok("update success",count);
            } else {
                return Response.fail("update failed");
            }
        } catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

    @ApiOperation(value = "templates", httpMethod = "POST", notes = "templates")
    @PostMapping(value = "/templates")
    public Response listTemplate(@RequestBody String jsonData) {
        try {
            Page<?> page = templateService.listTemplate(jsonData);
            return  Response.ok(page);
        } catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

    @ApiOperation(value = "get template uuid", httpMethod = "GET", notes = "get template uuid")
    @GetMapping(value = "/template/uuid")
    public Response getTemplateByUuid(@RequestParam String uuid, @RequestParam String communicationChannel) {
        try {
            if(StringUtils.isEmpty(uuid)){
                return  Response.fail(ErrorCode.MissingArgumentException.getErrCode(),"uuid cannot be empty");
            }
            if(StringUtils.isEmpty(communicationChannel)){
                return  Response.fail(ErrorCode.MissingArgumentException.getErrCode(),"communicationChannel cannot be empty");
            }
            Object object = templateService.getTemplateByUuid(uuid,communicationChannel);
            return  Response.ok(object);
        } catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

    @ApiOperation(value = "get template by event_type", httpMethod = "GET", notes = "get template by event_type")
    @GetMapping(value = "/template/event_type")
    public Response getTemplateByEventTypeUuid(@RequestParam String eventTypeUuid,@RequestParam String communicationChannel) {
        try {
            if(StringUtils.isEmpty(eventTypeUuid)){
                return  Response.fail(ErrorCode.MissingArgumentException.getErrCode(),"request parameter eventTypeUuid cannot be null");
            }
            if(StringUtils.isEmpty(communicationChannel)) {
                return Response.fail(ErrorCode.MissingArgumentException.getErrCode(), "request parameter communicationChannel cannot be null");
            }
            Object object = templateService.getTemplateByEventTypeUuid(eventTypeUuid,communicationChannel);
            return  Response.ok(object);
        } catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

}
