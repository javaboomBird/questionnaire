/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.group.entity;

import org.hibernate.validator.constraints.Length;
import com.create80.rd.modules.sys.entity.User;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 分组管理Entity
 *
 * @author yzx
 * @version 2018-06-08
 */
public class SysUserGroupEntity extends DataEntity<SysUserGroupEntity> {

  private static final long serialVersionUID = 1L;
  private SysGroupEntity sysGroupEntity;    // 分组 父类
  private String userId;
  private User user;    // 用户
  private String groupRole;    // 小组角色

  public SysUserGroupEntity() {
    super();
  }

  public SysUserGroupEntity(String id) {
    super(id);
  }

  public SysUserGroupEntity(SysGroupEntity sysGroupEntity) {
    this.sysGroupEntity = sysGroupEntity;
  }

  @Length(min = 1, max = 64, message = "分组长度必须介于 1 和 64 之间")
  public SysGroupEntity getSysGroupEntity() {
    return sysGroupEntity;
  }

  public void setSysGroupEntity(SysGroupEntity sysGroupEntity) {
    this.sysGroupEntity = sysGroupEntity;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Length(min = 0, max = 1, message = "小组角色长度必须介于 0 和 1 之间")
  public String getGroupRole() {
    return groupRole;
  }

  public void setGroupRole(String groupRole) {
    this.groupRole = groupRole;
  }

}