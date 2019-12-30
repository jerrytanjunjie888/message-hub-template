package com.decathlon.module.message.service;

import org.springframework.data.domain.Page;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
public interface ITemplateService {

    public Object insertTemplate(String jsonData);

    public Page<?> listTemplate(String jsonData);

    public int updateTemplate(String jsonData);

    public Object getTemplateByUuid(String uuid, String communicationChannel);

    public Object getTemplateByEventTypeUuid(String eventTypeUuid, String communicationChannel);

}
