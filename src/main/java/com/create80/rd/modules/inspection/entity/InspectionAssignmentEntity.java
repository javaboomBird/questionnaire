/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.inspection.entity;

import com.create80.rd.modules.assets.api.model.AssetsManager;
import com.create80.rd.modules.assets.entity.AssetsManagerEntity;
import com.create80.rd.modules.group.entity.SysGroupEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 巡检分配Entity
 *
 * @author yzx
 * @version 2018-06-13
 */
public class InspectionAssignmentEntity extends DataEntity<InspectionAssignmentEntity> {

  private static final long serialVersionUID = 1L;
  private String assetId;    // 数采仪资产id
  private String teamId;    // 运维组
  private String inspectionTimes;    // 每月维护次数

  private Date inspectionMonth;    // 生效月份
  private String insertBy;    // insert_by
  private Date insertTime;    // insert_time
  private Date updateTime;    // update_time
  private String isDeleted;    // is_deleted

  private AssetsManagerEntity assetsManager;

  private SysGroupEntity sysGroup;


  public SysGroupEntity getSysGroup() {
    return sysGroup;
  }

  public void setSysGroup(SysGroupEntity sysGroup) {
    this.sysGroup = sysGroup;
  }

  public AssetsManagerEntity getAssetsManager() {
    return assetsManager;
  }

  public void setAssetsManager(AssetsManagerEntity assetsManager) {
    this.assetsManager = assetsManager;
  }

  public InspectionAssignmentEntity() {
    super();
  }

  public InspectionAssignmentEntity(String id) {
    super(id);
  }

  public String getAssetId() {
    return assetId;
  }

  public void setAssetId(String assetId) {
    this.assetId = assetId;
  }

  @Length(min = 0, max = 64, message = "运维组长度必须介于 0 和 64 之间")
  public String getTeamId() {
    return teamId;
  }

  public void setTeamId(String teamId) {
    this.teamId = teamId;
  }

  public String getInspectionTimes() {
    return inspectionTimes;
  }

  public void setInspectionTimes(String inspectionTimes) {
    this.inspectionTimes = inspectionTimes;
  }

  @JsonFormat(pattern = "yyyy-MM")
  public Date getInspectionMonth() {
    return inspectionMonth;
  }

  public void setInspectionMonth(Date inspectionMonth) {
    this.inspectionMonth = inspectionMonth;
  }

  public Date getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Length(min = 0, max = 64, message = "insert_by长度必须介于 0 和 64 之间")
  public String getInsertBy() {
    return insertBy;
  }

  public void setInsertBy(String insertBy) {
    this.insertBy = insertBy;
  }


  public String getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(String isDeleted) {
    this.isDeleted = isDeleted;
  }

}