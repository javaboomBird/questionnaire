/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.entity;

import com.create80.rd.common.persistence.DataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.Length;

/**
 * 合同管理Entity
 *
 * @author lzp
 * @version 2018-05-23
 */
public class ContractEntity extends DataEntity<ContractEntity> {

  private static final long serialVersionUID = 1L;
  private String projectId;    // 项目编号
  private String supplemental;    // 是否补充协议
  private String virtual;    // 是否虚拟合同
  private String majorContractId;    // 主合同编号
  private String projectName;    // 合同项目名称
  private String status;    // 合同状态
  private String type;    // 合同类别
  private String level;    // 合同级别
  private Double contractTotalPrice;    // 合同总价
  private Double projectTotalPrice;    // 总价
  private Double maintainTotalPrice;    // 维护总价
  private Date signingDate;    // 签订时间
  private Date validDate;    // 生效时间
  private String firstParty;    // 甲方
  private String firstPartyContact;    // 甲方联系人
  private String firstPartyContactPhone;    // 甲方联系人电话
  private String secondParty;    // 乙方
  private String secondPartyContact;    // 乙方联系人
  private String secondPartyContactPhone;    // 乙方联系人电话
  private String thirdParty;    // 丙方
  private String thirdPartyContact;    // 丙方联系人
  private String thirdPartyContactPhone;    // 丙方联系人电话
  private String deliveryPlace;    // 交付地点
  private String serviceTerm;    // 服务期限
  private Date serviceStartDate;    // 服务开始时间
  private Date serviceEndDate;    // 服务结束时间
  private String agent;    // 经办人
  private List<ContractAttachmentEntity> contractAttachmentList = Lists.newArrayList();    // 子表列表
  private List<ContractGoodEntity> contractGoodList = Lists.newArrayList();    // 子表列表

  public ContractEntity() {
    super();
  }

  public ContractEntity(String id) {
    super(id);
  }

  @Length(min = 0, max = 64, message = "项目编号长度必须介于 0 和 64 之间")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getSupplemental() {
    return supplemental;
  }

  public void setSupplemental(String supplemental) {
    this.supplemental = supplemental;
  }

  public String getVirtual() {
    return virtual;
  }

  public void setVirtual(String virtual) {
    this.virtual = virtual;
  }

  @Length(min = 0, max = 64, message = "主合同编号长度必须介于 0 和 64 之间")
  public String getMajorContractId() {
    return majorContractId;
  }

  public void setMajorContractId(String majorContractId) {
    this.majorContractId = majorContractId;
  }

  @Length(min = 0, max = 128, message = "合同项目名称长度必须介于 0 和 128 之间")
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  @Length(min = 0, max = 64, message = "合同状态长度必须介于 0 和 64 之间")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Length(min = 0, max = 64, message = "合同类别长度必须介于 0 和 64 之间")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Length(min = 0, max = 64, message = "合同级别长度必须介于 0 和 64 之间")
  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public Double getContractTotalPrice() {
    return contractTotalPrice;
  }

  public void setContractTotalPrice(Double contractTotalPrice) {
    this.contractTotalPrice = contractTotalPrice;
  }

  public Double getProjectTotalPrice() {
    return projectTotalPrice;
  }

  public void setProjectTotalPrice(Double projectTotalPrice) {
    this.projectTotalPrice = projectTotalPrice;
  }

  public Double getMaintainTotalPrice() {
    return maintainTotalPrice;
  }

  public void setMaintainTotalPrice(Double maintainTotalPrice) {
    this.maintainTotalPrice = maintainTotalPrice;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getSigningDate() {
    return signingDate;
  }

  public void setSigningDate(Date signingDate) {
    this.signingDate = signingDate;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getValidDate() {
    return validDate;
  }

  public void setValidDate(Date validDate) {
    this.validDate = validDate;
  }

  @Length(min = 0, max = 64, message = "甲方长度必须介于 0 和 64 之间")
  public String getFirstParty() {
    return firstParty;
  }

  public void setFirstParty(String firstParty) {
    this.firstParty = firstParty;
  }

  @Length(min = 0, max = 32, message = "甲方联系人长度必须介于 0 和 32 之间")
  public String getFirstPartyContact() {
    return firstPartyContact;
  }

  public void setFirstPartyContact(String firstPartyContact) {
    this.firstPartyContact = firstPartyContact;
  }

  @Length(min = 0, max = 32, message = "甲方联系人电话长度必须介于 0 和 32 之间")
  public String getFirstPartyContactPhone() {
    return firstPartyContactPhone;
  }

  public void setFirstPartyContactPhone(String firstPartyContactPhone) {
    this.firstPartyContactPhone = firstPartyContactPhone;
  }

  @Length(min = 0, max = 64, message = "乙方长度必须介于 0 和 64 之间")
  public String getSecondParty() {
    return secondParty;
  }

  public void setSecondParty(String secondParty) {
    this.secondParty = secondParty;
  }

  @Length(min = 0, max = 32, message = "乙方联系人长度必须介于 0 和 32 之间")
  public String getSecondPartyContact() {
    return secondPartyContact;
  }

  public void setSecondPartyContact(String secondPartyContact) {
    this.secondPartyContact = secondPartyContact;
  }

  @Length(min = 0, max = 32, message = "乙方联系人电话长度必须介于 0 和 32 之间")
  public String getSecondPartyContactPhone() {
    return secondPartyContactPhone;
  }

  public void setSecondPartyContactPhone(String secondPartyContactPhone) {
    this.secondPartyContactPhone = secondPartyContactPhone;
  }

  @Length(min = 0, max = 64, message = "丙方长度必须介于 0 和 64 之间")
  public String getThirdParty() {
    return thirdParty;
  }

  public void setThirdParty(String thirdParty) {
    this.thirdParty = thirdParty;
  }

  @Length(min = 0, max = 32, message = "丙方联系人长度必须介于 0 和 32 之间")
  public String getThirdPartyContact() {
    return thirdPartyContact;
  }

  public void setThirdPartyContact(String thirdPartyContact) {
    this.thirdPartyContact = thirdPartyContact;
  }

  @Length(min = 0, max = 32, message = "丙方联系人电话长度必须介于 0 和 32 之间")
  public String getThirdPartyContactPhone() {
    return thirdPartyContactPhone;
  }

  public void setThirdPartyContactPhone(String thirdPartyContactPhone) {
    this.thirdPartyContactPhone = thirdPartyContactPhone;
  }

  @Length(min = 0, max = 128, message = "交付地点长度必须介于 0 和 128 之间")
  public String getDeliveryPlace() {
    return deliveryPlace;
  }

  public void setDeliveryPlace(String deliveryPlace) {
    this.deliveryPlace = deliveryPlace;
  }

  @Length(min = 0, max = 32, message = "服务期限长度必须介于 0 和 32 之间")
  public String getServiceTerm() {
    return serviceTerm;
  }

  public void setServiceTerm(String serviceTerm) {
    this.serviceTerm = serviceTerm;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getServiceStartDate() {
    return serviceStartDate;
  }

  public void setServiceStartDate(Date serviceStartDate) {
    this.serviceStartDate = serviceStartDate;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getServiceEndDate() {
    return serviceEndDate;
  }

  public void setServiceEndDate(Date serviceEndDate) {
    this.serviceEndDate = serviceEndDate;
  }

  @Length(min = 0, max = 64, message = "经办人长度必须介于 0 和 64 之间")
  public String getAgent() {
    return agent;
  }

  public void setAgent(String agent) {
    this.agent = agent;
  }

  public List<ContractAttachmentEntity> getContractAttachmentList() {
    return contractAttachmentList;
  }

  public void setContractAttachmentList(List<ContractAttachmentEntity> contractAttachmentList) {
    this.contractAttachmentList = contractAttachmentList;
  }

  public List<ContractGoodEntity> getContractGoodList() {
    return contractGoodList;
  }

  public void setContractGoodList(List<ContractGoodEntity> contractGoodList) {
    this.contractGoodList = contractGoodList;
  }
}