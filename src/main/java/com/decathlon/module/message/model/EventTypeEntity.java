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
@Table(name = "tbl_event_type")
public class EventTypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "uuid")
    @Column(name = "uuid")
    private String uuid;

    @ApiModelProperty(value = "eventSource")
    @Column(name = "event_source")
    private String eventSource;

    @ApiModelProperty(value = "eventName")
    @Column(name = "event_name")
    private String eventName;

    @ApiModelProperty(value = "eventParam")
    @Column(name = "event_param")
    private String eventParam;

    @ApiModelProperty(value = "systemId")
    @Column(name = "system_id")
    private String systemId;

    @ApiModelProperty(value = "eventRemark")
    @Column(name = "event_remark")
    private String eventRemark;

    @ApiModelProperty(value = "enableStatus")
    @Column(name = "enable_status")
    private Integer enableStatus;

    public int getEnableStatusVal() {
        return enableStatus != null ? enableStatus.intValue() : 0;
    }

    @ApiModelProperty(value = "notifyUrl")
    @Column(name = "notify_url")
    private String notifyUrl;

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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventParam() {
        return eventParam;
    }

    public void setEventParam(String eventParam) {
        this.eventParam = eventParam;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getEventRemark() {
        return eventRemark;
    }

    public void setEventRemark(String eventRemark) {
        this.eventRemark = eventRemark;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
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

    @ApiModelProperty(value = "isDeleted")
    @Column(name = "is_deleted")
    private Integer isDeleted;

    public int getIsDeletedVal() {
        return isDeleted != null ? isDeleted.intValue() : 0;
    }

    @Override
    public String toString() {
        return "EventTypeEntity{" +
                "uuid='" + uuid + '\'' +
                ", eventSource='" + eventSource + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventParam='" + eventParam + '\'' +
                ", systemId='" + systemId + '\'' +
                ", eventRemark='" + eventRemark + '\'' +
                ", enableStatus=" + enableStatus +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", creator='" + creator + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", modifier='" + modifier + '\'' +
                ", gmtModified=" + gmtModified +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
