package com.decathlon.module.message.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.decathlon.core.common.Response;
import com.decathlon.core.error.ErrorCode;
import com.decathlon.core.exception.CustomException;
import com.decathlon.module.message.constant.ConstWords;
import com.decathlon.module.message.model.*;
import com.decathlon.module.message.service.ITemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
@Slf4j
@Service("TemplateServiceImpl")
public class TemplateServiceImpl implements ITemplateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateServiceImpl.class);

    @Autowired
    TemplateSmsServiceImpl  templateSmsService;

    @Autowired
    TemplateEmailServiceImpl templateEmailService;

    @Autowired
    TemplateWeChatServiceImpl templateWeChatService;

    @Override
    public Object insertTemplate(String jsonData) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(jsonData);
            String  communicationChannel = (String)jsonObject.get(ConstWords.COMMUNICATION_CHANNEL);
            if(StringUtils.isBlank(communicationChannel)) {
                throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
            } else {
                communicationChannel = communicationChannel.toLowerCase();
            }

            switch (communicationChannel) {
                case ConstWords.SMS_COMMUNICATION_CHANNEL :
                    TemplateSmsDTO templateSmsDto = JSON.parseObject(jsonData, TemplateSmsDTO.class);
                    return templateSmsService.insertTemplateSmsMessageInfo(templateSmsDto);
                case ConstWords.EMAIL_COMMUNICATION_CHANNEL :
                    TemplateEmailDTO templateEmailDto = JSON.parseObject(jsonData, TemplateEmailDTO.class);
                    return templateEmailService.insertTemplateEmailMessageInfo(templateEmailDto);
                case ConstWords.WECHAT_COMMUNICATION_CHANNEL :
                    TemplateWeChatDTO templateWeChatDto = JSON.parseObject(jsonData, TemplateWeChatDTO.class);
                    return  templateWeChatService.insertTemplateWeChatMessageInfo(templateWeChatDto);
                default:
                    throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
            }
        } catch (CustomException e) {
            LOGGER.error(e.getReason(), e);
            return Response.fail(e.getCode(), e.getReason());
        }
    }

    @Override
    public Page<?> listTemplate(String jsonData) {
        JSONObject jsonObject = JSONObject.parseObject(jsonData);
        String communicationChannel = (String) jsonObject.get("communicationChannel");
        if(StringUtils.isEmpty(communicationChannel)) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
        } else {
            communicationChannel = communicationChannel.toLowerCase();
        }

        switch (communicationChannel) {
            case ConstWords.SMS_COMMUNICATION_CHANNEL:
                TemplateSmsDTO templateSmsDto = JSON.parseObject(jsonData, TemplateSmsDTO.class);
                return templateSmsService.listTemplateSmsMessageInfo(templateSmsDto);
            case ConstWords.EMAIL_COMMUNICATION_CHANNEL:
                TemplateEmailDTO templateEmailDto = JSON.parseObject(jsonData, TemplateEmailDTO.class);
                return templateEmailService.listTemplateEmailMessageInfo(templateEmailDto);
            case ConstWords.WECHAT_COMMUNICATION_CHANNEL:
                TemplateWeChatDTO templateWeChatDto = JSON.parseObject(jsonData, TemplateWeChatDTO.class);
                return templateWeChatService.listTemplateEmailMessageInfo(templateWeChatDto);
            default:
                throw new CustomException(ErrorCode.MissingArgumentException.getErrCode(), ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
        }
    }

    @Override
    public int updateTemplate(String jsonData) {
        JSONObject jsonObject = JSONObject.parseObject(jsonData);
        String communicationChannel = (String) jsonObject.get("communicationChannel");
        if(StringUtils.isEmpty(communicationChannel)) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
        } else {
            communicationChannel = communicationChannel.toLowerCase();
        }

        switch (communicationChannel) {
            case ConstWords.SMS_COMMUNICATION_CHANNEL :
                TemplateSmsDTO templateSmsDto = JSON.parseObject(jsonData, TemplateSmsDTO.class);
                return templateSmsService.updateTemplateSmsByUuid(templateSmsDto);
            case ConstWords.EMAIL_COMMUNICATION_CHANNEL:
                TemplateEmailDTO templateEmailDto = JSON.parseObject(jsonData, TemplateEmailDTO.class);
                return templateEmailService.updateTemplateEmailByUuid(templateEmailDto);
            case ConstWords.WECHAT_COMMUNICATION_CHANNEL:
                TemplateWeChatDTO templateWeChatDto = JSON.parseObject(jsonData, TemplateWeChatDTO.class);
                return templateWeChatService.updateTemplateWeChatByUuid(templateWeChatDto);
            default:
                throw new CustomException(ErrorCode.MissingArgumentException.getErrCode(), ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
        }
    }

    @Override
    public Object getTemplateByUuid(String uuid, String communicationChannel) {
        if(StringUtils.isEmpty(communicationChannel)) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
        } else {
            communicationChannel = communicationChannel.toLowerCase();
        }

        switch (communicationChannel) {
            case ConstWords.SMS_COMMUNICATION_CHANNEL :
                return templateSmsService.getTemplateSmsByUuid(uuid);
            case ConstWords.EMAIL_COMMUNICATION_CHANNEL:
                return templateEmailService.getTemplateEmailByUuid(uuid);
            case ConstWords.WECHAT_COMMUNICATION_CHANNEL:
                return templateWeChatService.getTemplateWeChatByUuid(uuid);
            default:
                throw new CustomException(ErrorCode.MissingArgumentException.getErrCode(), ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
        }
    }

    @Override
    public Object getTemplateByEventTypeUuid(String eventTypeUuid, String communicationChannel) {
        if(StringUtils.isEmpty(communicationChannel)) {
            throw  new CustomException(ErrorCode.MissingArgumentException.getErrCode(),ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
        } else {
            communicationChannel = communicationChannel.toLowerCase();
        }

        switch (communicationChannel) {
            case ConstWords.SMS_COMMUNICATION_CHANNEL :
                return templateSmsService.getTemplateSmsByEventType(eventTypeUuid);
            case ConstWords.EMAIL_COMMUNICATION_CHANNEL:
                return templateEmailService.getTemplateEmailByEventType(eventTypeUuid);
            case ConstWords.WECHAT_COMMUNICATION_CHANNEL:
                return templateWeChatService.getTemplateWeChatByEventType(eventTypeUuid);
            default:
                throw new CustomException(ErrorCode.MissingArgumentException.getErrCode(), ConstWords.COMMUNICATION_CHANNEL_NOT_EXIT);
        }
    }

}
