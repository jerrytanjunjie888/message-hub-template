package com.decathlon.module.message.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
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
@Builder
@Wither
@Table(name = "tbl_event_type")
public class EventTypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "uuid")
    private String uuid;

    @ApiModelProperty(value = "eventSource")
    @NotBlank(message = "eventSource cannot be empty")
    private String eventSource;

    @ApiModelProperty(value = "eventName")
    @NotBlank(message = "eventName cannot be empty")
    private String eventName;

    @ApiModelProperty(value = "eventParam")
    @NotBlank(message = "eventParam cannot be empty")
    private String eventParam;

    @ApiModelProperty(value = "systemId")
    @NotBlank(message = "systemId cannot be empty")
    private String systemId;

    @ApiModelProperty(value = "eventRemark")
    private String eventRemark;

    @ApiModelProperty(value = "enableStatus")
    private Integer enableStatus;

    public int getEnableStatusVal() {
        return enableStatus != null ? enableStatus.intValue() : 0;
    }

    @ApiModelProperty(value = "notifyUrl")
    private String notifyUrl;

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

    @ApiModelProperty(value = "startCreatedTime")
    private String startCreatedTime;

    @ApiModelProperty(value = "lastCreatedTime")
    private String lastCreatedTime;

    public int getIsDeletedVal() {
        return isDeleted != null ? isDeleted.intValue() : 0;
    }

    @ApiModelProperty(value = "pageSize")
    public int  pageSize;

    @ApiModelProperty(value = "pageNumber")
    public int  pageNumber;

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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getStartCreatedTime() {
        return startCreatedTime;
    }

    public void setStartCreatedTime(String startCreatedTime) {
        this.startCreatedTime = startCreatedTime;
    }

    public String getLastCreatedTime() {
        return lastCreatedTime;
    }

    public void setLastCreatedTime(String lastCreatedTime) {
        this.lastCreatedTime = lastCreatedTime;
    }

}
