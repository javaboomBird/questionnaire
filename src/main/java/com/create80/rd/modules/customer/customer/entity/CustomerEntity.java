/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.customer.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.create80.rd.modules.sys.entity.Area;
import java.util.List;
import com.google.common.collect.Lists;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 企业信息管理Entity
 *
 * @author yzx
 * @version 2018-06-22
 */
public class CustomerEntity extends DataEntity<CustomerEntity> {

  private static final long serialVersionUID = 1L;
  private String name;    // 客户名称
  private String type;    // 客户类型
  private String lat;    // 纬度
  private String lng;    // 经度
  private String uscCode;    // 社会信用代码
  private String legalPerson;    // 法人
  private String registeredCapital;    // 注册资本
  private Date registeredDate;    // 注册日期
  private String registeredAddress;    // 注册地址
  private String registeredPostcode;    // 注册邮编
  private String areaId;
  private Area area;    // 区域
  private String businessScope;    // 经营范围
  private String businessPhone;    // 办公电话
  private String businessFax;    // fax 号码
  private String bankAccount;    // 银行账户名称
  private String bankNumber;    // 银行账户卡号
  private String bankName;    // 开户行名称
  private String taxNumber;    // 税号
  private String taxPhone;    // 开票电话
  private String recyclingType;    // 回用类型
  private String statusType;    // 状态
  private List<CustomerBusinessTypeRelationEntity> customerBusinessTypeRelationList = Lists
      .newArrayList();    // 子表列表
  private List<CustomerContactEntity> customerContactList = Lists.newArrayList();    // 子表列表
  private List<CustomerIndustryTypeRelationEntity> customerIndustryTypeRelationList = Lists
      .newArrayList();    // 子表列表
  private List<CustomerPicEntity> customerPicList = Lists.newArrayList();    // 子表列表
  private List<CustomerPollutionTypeRelationEntity> customerPollutionTypeRelationList = Lists
      .newArrayList();    // 子表列表

  public CustomerEntity() {
    super();
  }

  public CustomerEntity(String id) {
    super(id);
  }

  @Length(min = 0, max = 64, message = "客户名称长度必须介于 0 和 64 之间")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Length(min = 0, max = 10, message = "客户类型长度必须介于 0 和 10 之间")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  @Length(min = 0, max = 32, message = "社会信用代码长度必须介于 0 和 32 之间")
  public String getUscCode() {
    return uscCode;
  }

  public void setUscCode(String uscCode) {
    this.uscCode = uscCode;
  }

  @Length(min = 0, max = 32, message = "法人长度必须介于 0 和 32 之间")
  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }

  public String getRegisteredCapital() {
    return registeredCapital;
  }

  public void setRegisteredCapital(String registeredCapital) {
    this.registeredCapital = registeredCapital;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  @Length(min = 0, max = 128, message = "注册地址长度必须介于 0 和 128 之间")
  public String getRegisteredAddress() {
    return registeredAddress;
  }

  public void setRegisteredAddress(String registeredAddress) {
    this.registeredAddress = registeredAddress;
  }

  public String getRegisteredPostcode() {
    return registeredPostcode;
  }

  public void setRegisteredPostcode(String registeredPostcode) {
    this.registeredPostcode = registeredPostcode;
  }


  public String getAreaId() {
    return areaId;
  }

  public void setAreaId(String areaId) {
    this.areaId = areaId;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  @Length(min = 0, max = 512, message = "经营范围长度必须介于 0 和 512 之间")
  public String getBusinessScope() {
    return businessScope;
  }

  public void setBusinessScope(String businessScope) {
    this.businessScope = businessScope;
  }

  @Length(min = 0, max = 32, message = "办公电话长度必须介于 0 和 32 之间")
  public String getBusinessPhone() {
    return businessPhone;
  }

  public void setBusinessPhone(String businessPhone) {
    this.businessPhone = businessPhone;
  }

  @Length(min = 0, max = 32, message = "fax 号码长度必须介于 0 和 32 之间")
  public String getBusinessFax() {
    return businessFax;
  }

  public void setBusinessFax(String businessFax) {
    this.businessFax = businessFax;
  }

  @Length(min = 0, max = 64, message = "银行账户名称长度必须介于 0 和 64 之间")
  public String getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }

  @Length(min = 0, max = 32, message = "银行账户卡号长度必须介于 0 和 32 之间")
  public String getBankNumber() {
    return bankNumber;
  }

  public void setBankNumber(String bankNumber) {
    this.bankNumber = bankNumber;
  }

  @Length(min = 0, max = 32, message = "开户行名称长度必须介于 0 和 32 之间")
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  @Length(min = 0, max = 32, message = "税号长度必须介于 0 和 32 之间")
  public String getTaxNumber() {
    return taxNumber;
  }

  public void setTaxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
  }

  @Length(min = 0, max = 32, message = "开票电话长度必须介于 0 和 32 之间")
  public String getTaxPhone() {
    return taxPhone;
  }

  public void setTaxPhone(String taxPhone) {
    this.taxPhone = taxPhone;
  }

  @Length(min = 0, max = 1, message = "回用类型长度必须介于 0 和 1 之间")
  public String getRecyclingType() {
    return recyclingType;
  }

  public void setRecyclingType(String recyclingType) {
    this.recyclingType = recyclingType;
  }

  @Length(min = 0, max = 1, message = "状态长度必须介于 0 和 1 之间")
  public String getStatusType() {
    return statusType;
  }

  public void setStatusType(String statusType) {
    this.statusType = statusType;
  }

  public List<CustomerBusinessTypeRelationEntity> getCustomerBusinessTypeRelationList() {
    return customerBusinessTypeRelationList;
  }

  public void setCustomerBusinessTypeRelationList(
      List<CustomerBusinessTypeRelationEntity> customerBusinessTypeRelationList) {
    this.customerBusinessTypeRelationList = customerBusinessTypeRelationList;
  }

  public List<CustomerContactEntity> getCustomerContactList() {
    return customerContactList;
  }

  public void setCustomerContactList(List<CustomerContactEntity> customerContactList) {
    this.customerContactList = customerContactList;
  }

  public List<CustomerIndustryTypeRelationEntity> getCustomerIndustryTypeRelationList() {
    return customerIndustryTypeRelationList;
  }

  public void setCustomerIndustryTypeRelationList(
      List<CustomerIndustryTypeRelationEntity> customerIndustryTypeRelationList) {
    this.customerIndustryTypeRelationList = customerIndustryTypeRelationList;
  }

  public List<CustomerPicEntity> getCustomerPicList() {
    return customerPicList;
  }

  public void setCustomerPicList(List<CustomerPicEntity> customerPicList) {
    this.customerPicList = customerPicList;
  }

  public List<CustomerPollutionTypeRelationEntity> getCustomerPollutionTypeRelationList() {
    return customerPollutionTypeRelationList;
  }

  public void setCustomerPollutionTypeRelationList(
      List<CustomerPollutionTypeRelationEntity> customerPollutionTypeRelationList) {
    this.customerPollutionTypeRelationList = customerPollutionTypeRelationList;
  }
}