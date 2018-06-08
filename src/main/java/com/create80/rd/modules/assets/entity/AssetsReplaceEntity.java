/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.entity;

import org.hibernate.validator.constraints.Length;
import com.create80.rd.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 资产替换Entity
 *
 * @author yzx
 * @version 2018-06-07
 */
public class AssetsReplaceEntity extends DataEntity<AssetsReplaceEntity> {

  private static final long serialVersionUID = 1L;
  private String replaceNo;    // 更换单号
  private String originalAssetsId;    // 被替换资产编号
  private String replaceAssetsId;    // 替换资产编号
  private String replaceManagerId;
  private User replaceManager;    // 资产替换负责人
  private Date replaceTime;    // 更换时间
  private String replaceReason;    // 更换原因
  private AssetsManagerEntity originalAssetsManager;
  private AssetsManagerEntity replaceAssetsManager;

  public AssetsReplaceEntity() {
    super();
  }

  public AssetsReplaceEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "更换单号长度必须介于 1 和 64 之间")
  public String getReplaceNo() {
    return replaceNo;
  }

  public void setReplaceNo(String replaceNo) {
    this.replaceNo = replaceNo;
  }

  @Length(min = 0, max = 64, message = "被替换资产编号长度必须介于 0 和 64 之间")
  public String getOriginalAssetsId() {
    return originalAssetsId;
  }

  public void setOriginalAssetsId(String originalAssetsId) {
    this.originalAssetsId = originalAssetsId;
  }

  @Length(min = 0, max = 64, message = "替换资产编号长度必须介于 0 和 64 之间")
  public String getReplaceAssetsId() {
    return replaceAssetsId;
  }

  public void setReplaceAssetsId(String replaceAssetsId) {
    this.replaceAssetsId = replaceAssetsId;
  }


  public String getReplaceManagerId() {
    return replaceManagerId;
  }

  public void setReplaceManagerId(String replaceManagerId) {
    this.replaceManagerId = replaceManagerId;
  }

  public User getReplaceManager() {
    return replaceManager;
  }

  public void setReplaceManager(User replaceManager) {
    this.replaceManager = replaceManager;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getReplaceTime() {
    return replaceTime;
  }

  public void setReplaceTime(Date replaceTime) {
    this.replaceTime = replaceTime;
  }

  @Length(min = 0, max = 255, message = "更换原因长度必须介于 0 和 255 之间")
  public String getReplaceReason() {
    return replaceReason;
  }

  public void setReplaceReason(String replaceReason) {
    this.replaceReason = replaceReason;
  }

  public AssetsManagerEntity getOriginalAssetsManager() {
    return originalAssetsManager;
  }

  public void setOriginalAssetsManager(
      AssetsManagerEntity originalAssetsManager) {
    this.originalAssetsManager = originalAssetsManager;
  }

  public AssetsManagerEntity getReplaceAssetsManager() {
    return replaceAssetsManager;
  }

  public void setReplaceAssetsManager(
      AssetsManagerEntity replaceAssetsManager) {
    this.replaceAssetsManager = replaceAssetsManager;
  }
}