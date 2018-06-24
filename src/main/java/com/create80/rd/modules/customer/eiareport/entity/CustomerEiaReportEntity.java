/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.eiareport.entity;

import com.create80.rd.modules.customer.customer.entity.CustomerEntity;
import com.create80.rd.modules.customer.pt.entity.CustomerPollutionTypeEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.google.common.collect.Lists;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 环评报告信息管理Entity
 *
 * @author yzx
 * @version 2018-06-22
 */
public class CustomerEiaReportEntity extends DataEntity<CustomerEiaReportEntity> {

  private static final long serialVersionUID = 1L;
  private String customerId;    // 客户
  private String approved;    // 是否有审批
  private Date approveDate;    // 审批时间
  private String accepted;    // 是否有三同时验收
  private Date acceptDate;    // 验收时间
  private String expanded;    // 是否存在扩建
  private String expendedDevice;    // 扩建设备
  private String pollutionTypeId;    // 排污类型
  private String pollutionPermitStatus;    // 排污许可状况
  private String reportFile;    // 环评报告文件

  private CustomerEntity customer;
  private CustomerPollutionTypeEntity customerPollutionType;

  private List<CustomerEiaReportPicEntity> customerEiaReportPicList = Lists
      .newArrayList();    // 子表列表
  private List<CustomerEiaReportWasteEntity> customerEiaReportWasteList = Lists
      .newArrayList();    // 子表列表

  public CustomerEiaReportEntity() {
    super();
  }

  public CustomerEiaReportEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "客户长度必须介于 1 和 64 之间")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  @Length(min = 0, max = 1, message = "是否有审批长度必须介于 0 和 1 之间")
  public String getApproved() {
    return approved;
  }

  public void setApproved(String approved) {
    this.approved = approved;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getApproveDate() {
    return approveDate;
  }

  public void setApproveDate(Date approveDate) {
    this.approveDate = approveDate;
  }

  @Length(min = 0, max = 1, message = "是否有三同时验收长度必须介于 0 和 1 之间")
  public String getAccepted() {
    return accepted;
  }

  public void setAccepted(String accepted) {
    this.accepted = accepted;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getAcceptDate() {
    return acceptDate;
  }

  public void setAcceptDate(Date acceptDate) {
    this.acceptDate = acceptDate;
  }

  @Length(min = 0, max = 1, message = "是否存在扩建长度必须介于 0 和 1 之间")
  public String getExpanded() {
    return expanded;
  }

  public void setExpanded(String expanded) {
    this.expanded = expanded;
  }

  @Length(min = 0, max = 256, message = "扩建设备长度必须介于 0 和 256 之间")
  public String getExpendedDevice() {
    return expendedDevice;
  }

  public void setExpendedDevice(String expendedDevice) {
    this.expendedDevice = expendedDevice;
  }

  @Length(min = 0, max = 64, message = "排污类型长度必须介于 0 和 64 之间")
  public String getPollutionTypeId() {
    return pollutionTypeId;
  }

  public void setPollutionTypeId(String pollutionTypeId) {
    this.pollutionTypeId = pollutionTypeId;
  }

  @Length(min = 0, max = 1, message = "排污许可状况长度必须介于 0 和 1 之间")
  public String getPollutionPermitStatus() {
    return pollutionPermitStatus;
  }

  public void setPollutionPermitStatus(String pollutionPermitStatus) {
    this.pollutionPermitStatus = pollutionPermitStatus;
  }

  @Length(min = 0, max = 256, message = "环评报告文件长度必须介于 0 和 256 之间")
  public String getReportFile() {
    return reportFile;
  }

  public void setReportFile(String reportFile) {
    this.reportFile = reportFile;
  }

  public List<CustomerEiaReportPicEntity> getCustomerEiaReportPicList() {
    return customerEiaReportPicList;
  }

  public void setCustomerEiaReportPicList(
      List<CustomerEiaReportPicEntity> customerEiaReportPicList) {
    this.customerEiaReportPicList = customerEiaReportPicList;
  }

  public List<CustomerEiaReportWasteEntity> getCustomerEiaReportWasteList() {
    return customerEiaReportWasteList;
  }

  public void setCustomerEiaReportWasteList(
      List<CustomerEiaReportWasteEntity> customerEiaReportWasteList) {
    this.customerEiaReportWasteList = customerEiaReportWasteList;
  }

  public CustomerEntity getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerEntity customer) {
    this.customer = customer;
  }

  public CustomerPollutionTypeEntity getCustomerPollutionType() {
    return customerPollutionType;
  }

  public void setCustomerPollutionType(
      CustomerPollutionTypeEntity customerPollutionType) {
    this.customerPollutionType = customerPollutionType;
  }
}