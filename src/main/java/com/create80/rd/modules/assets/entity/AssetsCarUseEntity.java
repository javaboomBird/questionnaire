/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 车辆使用Entity
 *
 * @author yzx
 * @version 2018-06-08
 */
public class AssetsCarUseEntity extends DataEntity<AssetsCarUseEntity> {

  private static final long serialVersionUID = 1L;
  private String assetsId;    // 车辆
  private String managerId;    // 使用人
  private String usePurpose;    // 使用目的
  private String beforeMileage;    // 使用前里程
  private String afterMileage;    // 使用后里程
  private Date startTime;    // 开始时间
  private Date endTime;    // 结束时间
  private AssetsManagerEntity assetsManager;

  public AssetsCarUseEntity() {
    super();
  }

  public AssetsCarUseEntity(String id) {
    super(id);
  }

  @Length(min = 0, max = 64, message = "车辆长度必须介于 0 和 64 之间")
  public String getAssetsId() {
    return assetsId;
  }

  public void setAssetsId(String assetsId) {
    this.assetsId = assetsId;
  }

  @Length(min = 0, max = 64, message = "使用人长度必须介于 0 和 64 之间")
  public String getManagerId() {
    return managerId;
  }

  public void setManagerId(String managerId) {
    this.managerId = managerId;
  }

  @Length(min = 0, max = 255, message = "使用目的长度必须介于 0 和 255 之间")
  public String getUsePurpose() {
    return usePurpose;
  }

  public void setUsePurpose(String usePurpose) {
    this.usePurpose = usePurpose;
  }

  @Length(min = 0, max = 20, message = "使用前里程长度必须介于 0 和 20 之间")
  public String getBeforeMileage() {
    return beforeMileage;
  }

  public void setBeforeMileage(String beforeMileage) {
    this.beforeMileage = beforeMileage;
  }

  @Length(min = 0, max = 20, message = "使用后里程长度必须介于 0 和 20 之间")
  public String getAfterMileage() {
    return afterMileage;
  }

  public void setAfterMileage(String afterMileage) {
    this.afterMileage = afterMileage;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public AssetsManagerEntity getAssetsManager() {
    return assetsManager;
  }

  public void setAssetsManager(AssetsManagerEntity assetsManager) {
    this.assetsManager = assetsManager;
  }
}