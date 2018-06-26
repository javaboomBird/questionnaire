/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.engineering.entity;

import com.create80.rd.modules.customer.customer.entity.CustomerEntity;
import com.create80.rd.modules.group.entity.SysGroupEntity;
import com.create80.rd.modules.projectmanager.entity.ProjectEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 工单管理Entity
 *
 * @author yzx
 * @version 2018-06-22
 */
public class EngineeringWorkOrderEntity extends DataEntity<EngineeringWorkOrderEntity> {

  private static final long serialVersionUID = 1L;
  private String orderNumber;    // 工单号
  private String orderType;    // 工单类型
  private String description;    // 描述
  private String priority;    // 工单优先级
  private String status;    // 工单状态
  private String enterpriseId;    // 企业ID
  private String projectId;    // 项目ID
  private String sponsorId;    // 工单发起人ID
  private String assignorId;    // 分配人ID
  private String teamId;    // 受理小组ID
  private Date estimateStartTime;    // 预估开始时间
  private Date estimateEndTime;    // 预估结束时间
  private String estimateTime;    // 预估工时
  private Date acceptTime;    // 受理时间
  private Date actualStartTime;    // 时间开始时间
  private Date actualEndTime;    // 时间结束时间
  private String actualTime;    // 实际工时
  private Date assignorTime;    // 分派时间
  private Date sponsorTime;    // 发起时间
  private String contractId;    // 合同

  private CustomerEntity customer;
  private ProjectEntity project;
  private SysGroupEntity sysGroup;

  public EngineeringWorkOrderEntity() {
    super();
  }

  public EngineeringWorkOrderEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "工单号长度必须介于 1 和 64 之间")
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Length(min = 1, max = 10, message = "工单类型长度必须介于 1 和 10 之间")
  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  @Length(min = 0, max = 100, message = "描述长度必须介于 0 和 100 之间")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Length(min = 0, max = 10, message = "工单优先级长度必须介于 0 和 10 之间")
  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  @Length(min = 0, max = 10, message = "工单状态长度必须介于 0 和 10 之间")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Length(min = 0, max = 64, message = "企业ID长度必须介于 0 和 64 之间")
  public String getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(String enterpriseId) {
    this.enterpriseId = enterpriseId;
  }

  @Length(min = 0, max = 64, message = "项目ID长度必须介于 0 和 64 之间")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  @Length(min = 0, max = 64, message = "工单发起人ID长度必须介于 0 和 64 之间")
  public String getSponsorId() {
    return sponsorId;
  }

  public void setSponsorId(String sponsorId) {
    this.sponsorId = sponsorId;
  }

  @Length(min = 0, max = 64, message = "分配人ID长度必须介于 0 和 64 之间")
  public String getAssignorId() {
    return assignorId;
  }

  public void setAssignorId(String assignorId) {
    this.assignorId = assignorId;
  }

  @Length(min = 0, max = 64, message = "受理小组ID长度必须介于 0 和 64 之间")
  public String getTeamId() {
    return teamId;
  }

  public void setTeamId(String teamId) {
    this.teamId = teamId;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getEstimateStartTime() {
    return estimateStartTime;
  }

  public void setEstimateStartTime(Date estimateStartTime) {
    this.estimateStartTime = estimateStartTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getEstimateEndTime() {
    return estimateEndTime;
  }

  public void setEstimateEndTime(Date estimateEndTime) {
    this.estimateEndTime = estimateEndTime;
  }

  public String getEstimateTime() {
    return estimateTime;
  }

  public void setEstimateTime(String estimateTime) {
    this.estimateTime = estimateTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getAcceptTime() {
    return acceptTime;
  }

  public void setAcceptTime(Date acceptTime) {
    this.acceptTime = acceptTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getActualStartTime() {
    return actualStartTime;
  }

  public void setActualStartTime(Date actualStartTime) {
    this.actualStartTime = actualStartTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getActualEndTime() {
    return actualEndTime;
  }

  public void setActualEndTime(Date actualEndTime) {
    this.actualEndTime = actualEndTime;
  }

  public String getActualTime() {
    return actualTime;
  }

  public void setActualTime(String actualTime) {
    this.actualTime = actualTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getAssignorTime() {
    return assignorTime;
  }

  public void setAssignorTime(Date assignorTime) {
    this.assignorTime = assignorTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getSponsorTime() {
    return sponsorTime;
  }

  public void setSponsorTime(Date sponsorTime) {
    this.sponsorTime = sponsorTime;
  }

  @Length(min = 0, max = 64, message = "合同长度必须介于 0 和 64 之间")
  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }

  public ProjectEntity getProject() {
    return project;
  }

  public void setProject(ProjectEntity project) {
    this.project = project;
  }

  public CustomerEntity getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerEntity customer) {
    this.customer = customer;
  }

  public SysGroupEntity getSysGroup() {
    return sysGroup;
  }

  public void setSysGroup(SysGroupEntity sysGroup) {
    this.sysGroup = sysGroup;
  }
}