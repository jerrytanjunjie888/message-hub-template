package com.decathlon.module.message.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Wither
@Table(name = "tbl_template_email")
public class TemplateEmailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "uuid")
    private String uuid;

    @ApiModelProperty(value = "eventTypeUuid")
    private String eventTypeUuid;

    @ApiModelProperty(value = "edmChannel")
    private String edmChannel;

    @ApiModelProperty(value = "templateSubject")
    private String templateSubject;

    @ApiModelProperty(value = "templateContent")
    private String templateContent;

    @ApiModelProperty(value = "documentName")
    private String documentName;

    @ApiModelProperty(value = "documentUrl")
    private String documentUrl;

    @ApiModelProperty(value = "startEffectiveTime")
    private String startEffectiveTime;

    @ApiModelProperty(value = "lastEffectiveTime")
    private String lastEffectiveTime;

    @ApiModelProperty(value = "templateLanguageCode")
    private String templateLanguageCode;

    @ApiModelProperty(value = "templateCountryCode")
    private String templateCountryCode;

    @ApiModelProperty(value = "communicationChannel")
    private String communicationChannel;

    @ApiModelProperty(value = "templateAttributes")
    private String templateAttributes;

    @ApiModelProperty(value = "creator")
    private String creator;

    @ApiModelProperty(value = "gmtCreated")
    private String gmtCreated;

    @ApiModelProperty(value = "modifier")
    private String modifier;

    @ApiModelProperty(value = "gmtModified")
    private String gmtModified;

    @ApiModelProperty(value = "isDeleted")
    private Integer isDeleted;

    public int getIsDeletedVal() {
        return isDeleted != null ? isDeleted.intValue() : 0;
    }

    @ApiModelProperty(value = "pageNumber")
    private int pageNumber;

    @ApiModelProperty(value = "pageSize")
    private int pageSize;

    public String getCommunicationChannel() {
        return communicationChannel;
    }

    public void setCommunicationChannel(String communicationChannel) {
        this.communicationChannel = communicationChannel;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEventTypeUuid() {
        return eventTypeUuid;
    }

    public void setEventTypeUuid(String eventTypeUuid) {
        this.eventTypeUuid = eventTypeUuid;
    }

    public String getEdmChannel() {
        return edmChannel;
    }

    public void setEdmChannel(String edmChannel) {
        this.edmChannel = edmChannel;
    }

    public String getTemplateSubject() {
        return templateSubject;
    }

    public void setTemplateSubject(String templateSubject) {
        this.templateSubject = templateSubject;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public String getStartEffectiveTime() {
        return startEffectiveTime;
    }

    public void setStartEffectiveTime(String startEffectiveTime) {
        this.startEffectiveTime = startEffectiveTime;
    }

    public String getLastEffectiveTime() {
        return lastEffectiveTime;
    }

    public void setLastEffectiveTime(String lastEffectiveTime) {
        this.lastEffectiveTime = lastEffectiveTime;
    }

    public String getTemplateLanguageCode() {
        return templateLanguageCode;
    }

    public void setTemplateLanguageCode(String templateLanguageCode) {
        this.templateLanguageCode = templateLanguageCode;
    }

    public String getTemplateCountryCode() {
        return templateCountryCode;
    }

    public void setTemplateCountryCode(String templateCountryCode) {
        this.templateCountryCode = templateCountryCode;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getTemplateAttributes() {
        return templateAttributes;
    }

    public void setTemplateAttributes(String templateAttributes) {
        this.templateAttributes = templateAttributes;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }


}
