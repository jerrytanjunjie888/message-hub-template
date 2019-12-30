package com.decathlon.module.message.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Wither
@Table(name = "tbl_template_wechat")
public class TemplateWeChatEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "uuid")
    @Column(name = "uuid")
    private String uuid;

    @ApiModelProperty(value = "eventTypeUuid")
    @Column(name = "event_type_uuid")
    private String eventTypeUuid;

    @ApiModelProperty(value = "officialAccount")
    @Column(name = "official_account")
    private String officialAccount;

    @ApiModelProperty(value = "templateSubject")
    @Column(name = "template_subject")
    private String templateSubject;

    @ApiModelProperty(value = "templateContent")
    @Column(name = "template_content")
    private String templateContent;

    @ApiModelProperty(value = "templateLanguageCode")
    @Column(name = "template_language_code")
    private String templateLanguageCode;

    @ApiModelProperty(value = "templateCountryCode")
    @Column(name = "template_country_code")
    private String templateCountryCode;

    @ApiModelProperty(value = "communicationChannel")
    @Column(name = "communication_channel")
    private String communicationChannel;

    @ApiModelProperty(value = "templateAttributes")
    @Column(name = "template_attributes")
    private String templateAttributes;

    @ApiModelProperty(value = "cardConnection")
    @Column(name = "card_connection")
    private String cardConnection;

    @ApiModelProperty(value = "smallRoutine")
    @Column(name = "small_routine")
    private String smallRoutine;

    @ApiModelProperty(value = "pagePath")
    @Column(name = "page_path")
    private String pagePath;

    @ApiModelProperty(value = "templateRemark")
    @Column(name = "template_remark")
    private String templateRemark;

    @ApiModelProperty(value = "startEffectiveTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "start_effectiveTime")
    private Date startEffectiveTime;

    @ApiModelProperty(value = "lastEffectiveTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_effectiveTime")
    private Date lastEffectiveTime;

    @ApiModelProperty(value = "creator")
    @Column(name = "creator")
    private String creator;

    @ApiModelProperty(value = "gmtCreated")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "gmt_created")
    private Date gmtCreated;

    @ApiModelProperty(value = "modifier")
    @Column(name = "modifier")
    private String modifier;

    @ApiModelProperty(value = "gmtModified")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "gmt_modified")
    private Date gmtModified;

    @ApiModelProperty(value = "isDeleted")
    @Column(name = "is_deleted")
    private Integer isDeleted;

    public int getIsDeletedVal() {
        return isDeleted != null ? isDeleted.intValue() : 0;
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

    public String getOfficialAccount() {
        return officialAccount;
    }

    public void setOfficialAccount(String officialAccount) {
        this.officialAccount = officialAccount;
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

    public String getCommunicationChannel() {
        return communicationChannel;
    }

    public void setCommunicationChannel(String communicationChannel) {
        this.communicationChannel = communicationChannel;
    }

    public String getTemplateAttributes() {
        return templateAttributes;
    }

    public void setTemplateAttributes(String templateAttributes) {
        this.templateAttributes = templateAttributes;
    }

    public String getCardConnection() {
        return cardConnection;
    }

    public void setCardConnection(String cardConnection) {
        this.cardConnection = cardConnection;
    }

    public String getSmallRoutine() {
        return smallRoutine;
    }

    public void setSmallRoutine(String smallRoutine) {
        this.smallRoutine = smallRoutine;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getTemplateRemark() {
        return templateRemark;
    }

    public void setTemplateRemark(String templateRemark) {
        this.templateRemark = templateRemark;
    }

    public Date getStartEffectiveTime() {
        return startEffectiveTime;
    }

    public void setStartEffectiveTime(Date startEffectiveTime) {
        this.startEffectiveTime = startEffectiveTime;
    }

    public Date getLastEffectiveTime() {
        return lastEffectiveTime;
    }

    public void setLastEffectiveTime(Date lastEffectiveTime) {
        this.lastEffectiveTime = lastEffectiveTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}
