/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.engineering.entity;

import com.create80.rd.modules.customer.customer.entity.CustomerEntity;
import com.create80.rd.modules.group.api.model.SysGroup;
import com.create80.rd.modules.group.entity.SysGroupEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 工程签到Entity
 *
 * @author yzx
 * @version 2018-06-27
 */
public class EngineeringSignInEntity extends DataEntity<EngineeringSignInEntity> {

  private static final long serialVersionUID = 1L;
  private String engineeringId;    // 工单
  private String teamId;    // 分组
  private Date signTime;    // 签到时间
  private String signLat;    // 签到位置纬度
  private String signLng;    // 签到位置经度
  private String signType;    // 签到类型
  private String customerId;    // 客户
  private String description;    // 签到描述

  private EngineeringWorkOrderEntity engineeringWorkOrder;
  private SysGroupEntity sysGroup;


  public EngineeringSignInEntity() {
    super();
  }

  public EngineeringSignInEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "工单长度必须介于 1 和 64 之间")
  public String getEngineeringId() {
    return engineeringId;
  }

  public void setEngineeringId(String engineeringId) {
    this.engineeringId = engineeringId;
  }

  @Length(min = 1, max = 64, message = "分组长度必须介于 1 和 64 之间")
  public String getTeamId() {
    return teamId;
  }

  public void setTeamId(String teamId) {
    this.teamId = teamId;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getSignTime() {
    return signTime;
  }

  public void setSignTime(Date signTime) {
    this.signTime = signTime;
  }

  public String getSignLat() {
    return signLat;
  }

  public void setSignLat(String signLat) {
    this.signLat = signLat;
  }

  public String getSignLng() {
    return signLng;
  }

  public void setSignLng(String signLng) {
    this.signLng = signLng;
  }

  @Length(min = 0, max = 10, message = "签到类型长度必须介于 0 和 10 之间")
  public String getSignType() {
    return signType;
  }

  public void setSignType(String signType) {
    this.signType = signType;
  }

  @Length(min = 0, max = 64, message = "客户长度必须介于 0 和 64 之间")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  @Length(min = 0, max = 100, message = "签到描述长度必须介于 0 和 100 之间")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EngineeringWorkOrderEntity getEngineeringWorkOrder() {
    return engineeringWorkOrder;
  }

  public void setEngineeringWorkOrder(
      EngineeringWorkOrderEntity engineeringWorkOrder) {
    this.engineeringWorkOrder = engineeringWorkOrder;
  }

  public SysGroupEntity getSysGroup() {
    return sysGroup;
  }

  public void setSysGroup(SysGroupEntity sysGroup) {
    this.sysGroup = sysGroup;
  }
}