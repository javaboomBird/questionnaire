/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.common.persistence;

import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import com.create80.rd.common.utils.IdGen;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.create80.rd.common.utils.IdGen;
import com.create80.rd.modules.sys.entity.User;
import com.create80.rd.modules.sys.utils.UserUtils;

/**
 * 数据Entity类
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

  private static final long serialVersionUID = 1L;

  protected String remarks;  // 备注
//	protected User createBy;	// 创建者
//	protected Date createDate;	// 创建日期
//	protected User updateBy;	// 更新者
//	protected Date updateDate;	// 更新日期
//	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）

  protected User insertBy;  // 创建者
  protected Date insertTime;  // 创建日期
  protected User updateBy;  // 更新者
  protected Date updateTime;  // 更新日期
  protected String isDeleted;  // 删除标记（N：正常；Y删除）

  public DataEntity() {
    super();
    this.isDeleted = DEL_FLAG_NORMAL;
  }

  public DataEntity(String id) {
    super(id);
  }

  /**
   * 插入之前执行方法，需要手动调用
   */
  @Override
  public void preInsert() {
    // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
    if (!this.isNewRecord) {
      setId(IdGen.uuid());
    }
    User user = UserUtils.getUser();
    if (StringUtils.isNotBlank(user.getId())) {
      this.updateBy = user;
      this.insertBy = user;
    }
    this.insertTime = new Date();
    this.updateTime = this.insertTime;
  }

  /**
   * 更新之前执行方法，需要手动调用
   */
  @Override
  public void preUpdate() {
    User user = UserUtils.getUser();
    if (StringUtils.isNotBlank(user.getId())) {
      this.updateBy = user;
    }
    this.updateTime = new Date();
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  @JsonIgnore
  public User getInsertBy() {
    return insertBy;
  }

  public void setInsertBy(User insertBy) {
    this.insertBy = insertBy;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  @JsonIgnore
  public User getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(User updateBy) {
    this.updateBy = updateBy;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(String isDeleted) {
    this.isDeleted = isDeleted;
  }
}
