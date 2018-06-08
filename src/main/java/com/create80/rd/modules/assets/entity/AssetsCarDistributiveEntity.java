/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.entity;

import com.create80.rd.modules.group.entity.SysGroupEntity;
import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 车辆分配Entity
 *
 * @author yzx
 * @version 2018-06-08
 */
public class AssetsCarDistributiveEntity extends DataEntity<AssetsCarDistributiveEntity> {

  private static final long serialVersionUID = 1L;
  private String assetsId;    // 资产
  private String groupId;    // 分组

  private SysGroupEntity sysGroup;
  private AssetsManagerEntity assetsManager;


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

  public AssetsCarDistributiveEntity() {
    super();
  }

  public AssetsCarDistributiveEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "资产长度必须介于 1 和 64 之间")
  public String getAssetsId() {
    return assetsId;
  }

  public void setAssetsId(String assetsId) {
    this.assetsId = assetsId;
  }

  @Length(min = 1, max = 64, message = "分组长度必须介于 1 和 64 之间")
  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

}