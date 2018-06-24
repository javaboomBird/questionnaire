/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.entity;

import com.create80.rd.modules.customer.customer.entity.CustomerEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.create80.rd.modules.sys.entity.User;
import java.util.List;
import com.google.common.collect.Lists;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 资产管理Entity
 *
 * @author yzx
 * @version 2018-06-05
 */
public class AssetsManagerEntity extends DataEntity<AssetsManagerEntity> {

  private static final long serialVersionUID = 1L;
  private String assetsNo;    // 资产编号
  private String assetsType;    // 资产类型
  private String assetsName;    // 资产名称
  private String originalManufactor;    // 原厂家
  private String assetsModel;    // 资产型号
  private String assetsSerialNum;    // 资产序列号
  private String assetsNature;    // 资产性质
  private String assetsUseDepartment;    // 资产使用部门
  private String assetsUseUnit;    // 资产使用单位
  private String assetsLocation;    // 资产使用地址
  private Date repairStartTime;    // 保修开始时间
  private Date repairEndTime;    // 保修结束时间
  private String assetsStatus;    // 资产状态
  private String plateNumber;    // 车牌号
  private String managerId;
  private User manager;    // 资产负责人
  private String contactId;    // 合同
  private List<AssetsImageEntity> assetsImageList = Lists.newArrayList();    // 子表列表

  //如果不是内部用户则是需要涉及到企业
  private CustomerEntity customer;

  public AssetsManagerEntity() {
    super();
  }

  public AssetsManagerEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "资产编号长度必须介于 1 和 64 之间")
  public String getAssetsNo() {
    return assetsNo;
  }

  public void setAssetsNo(String assetsNo) {
    this.assetsNo = assetsNo;
  }

  @Length(min = 0, max = 20, message = "资产类型长度必须介于 0 和 20 之间")
  public String getAssetsType() {
    return assetsType;
  }

  public void setAssetsType(String assetsType) {
    this.assetsType = assetsType;
  }

  @Length(min = 0, max = 64, message = "资产名称长度必须介于 0 和 64 之间")
  public String getAssetsName() {
    return assetsName;
  }

  public void setAssetsName(String assetsName) {
    this.assetsName = assetsName;
  }

  @Length(min = 0, max = 64, message = "原厂家长度必须介于 0 和 64 之间")
  public String getOriginalManufactor() {
    return originalManufactor;
  }

  public void setOriginalManufactor(String originalManufactor) {
    this.originalManufactor = originalManufactor;
  }

  @Length(min = 0, max = 64, message = "资产型号长度必须介于 0 和 64 之间")
  public String getAssetsModel() {
    return assetsModel;
  }

  public void setAssetsModel(String assetsModel) {
    this.assetsModel = assetsModel;
  }

  @Length(min = 0, max = 64, message = "资产序列号长度必须介于 0 和 64 之间")
  public String getAssetsSerialNum() {
    return assetsSerialNum;
  }

  public void setAssetsSerialNum(String assetsSerialNum) {
    this.assetsSerialNum = assetsSerialNum;
  }

  @Length(min = 0, max = 1, message = "资产性质长度必须介于 0 和 1 之间")
  public String getAssetsNature() {
    return assetsNature;
  }

  public void setAssetsNature(String assetsNature) {
    this.assetsNature = assetsNature;
  }

  @Length(min = 0, max = 64, message = "资产使用部门长度必须介于 0 和 64 之间")
  public String getAssetsUseDepartment() {
    return assetsUseDepartment;
  }

  public void setAssetsUseDepartment(String assetsUseDepartment) {
    this.assetsUseDepartment = assetsUseDepartment;
  }

  @Length(min = 0, max = 64, message = "资产使用单位长度必须介于 0 和 64 之间")
  public String getAssetsUseUnit() {
    return assetsUseUnit;
  }

  public void setAssetsUseUnit(String assetsUseUnit) {
    this.assetsUseUnit = assetsUseUnit;
  }

  @Length(min = 0, max = 64, message = "资产使用地址长度必须介于 0 和 64 之间")
  public String getAssetsLocation() {
    return assetsLocation;
  }

  public void setAssetsLocation(String assetsLocation) {
    this.assetsLocation = assetsLocation;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getRepairStartTime() {
    return repairStartTime;
  }

  public void setRepairStartTime(Date repairStartTime) {
    this.repairStartTime = repairStartTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getRepairEndTime() {
    return repairEndTime;
  }

  public void setRepairEndTime(Date repairEndTime) {
    this.repairEndTime = repairEndTime;
  }

  @Length(min = 0, max = 1, message = "资产状态长度必须介于 0 和 1 之间")
  public String getAssetsStatus() {
    return assetsStatus;
  }

  public void setAssetsStatus(String assetsStatus) {
    this.assetsStatus = assetsStatus;
  }

  @Length(min = 0, max = 64, message = "车牌号长度必须介于 0 和 64 之间")
  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }


  public String getManagerId() {
    return managerId;
  }

  public void setManagerId(String managerId) {
    this.managerId = managerId;
  }

  public User getManager() {
    return manager;
  }

  public void setManager(User manager) {
    this.manager = manager;
  }

  @Length(min = 0, max = 64, message = "合同长度必须介于 0 和 64 之间")
  public String getContactId() {
    return contactId;
  }

  public void setContactId(String contactId) {
    this.contactId = contactId;
  }

  public List<AssetsImageEntity> getAssetsImageList() {
    return assetsImageList;
  }

  public CustomerEntity getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerEntity customer) {
    this.customer = customer;
  }

  public void setAssetsImageList(List<AssetsImageEntity> assetsImageList) {
    this.assetsImageList = assetsImageList;
  }

}