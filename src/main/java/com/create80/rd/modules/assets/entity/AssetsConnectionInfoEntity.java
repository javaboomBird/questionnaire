/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 资产连接信息管理Entity
 *
 * @author yzx
 * @version 2018-06-07
 */
public class AssetsConnectionInfoEntity extends DataEntity<AssetsConnectionInfoEntity> {

  private static final long serialVersionUID = 1L;
  private String sourceAssetsId;    // 源资产
  private String sourceApi;    // 源资产API地址
  private String targetAssetsId;    // 目标资产
  private String targetApi;    // 目标资产API地址
  private String enterpriseId;

  private AssetsManagerEntity sourceAssets;
  private AssetsManagerEntity targetAssets;

  public AssetsConnectionInfoEntity() {
    super();
  }

  public AssetsConnectionInfoEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "源资产长度必须介于 1 和 64 之间")
  public String getSourceAssetsId() {
    return sourceAssetsId;
  }

  public void setSourceAssetsId(String sourceAssetsId) {
    this.sourceAssetsId = sourceAssetsId;
  }

  @Length(min = 0, max = 64, message = "源资产API地址长度必须介于 0 和 64 之间")
  public String getSourceApi() {
    return sourceApi;
  }

  public void setSourceApi(String sourceApi) {
    this.sourceApi = sourceApi;
  }

  @Length(min = 1, max = 64, message = "目标资产长度必须介于 1 和 64 之间")
  public String getTargetAssetsId() {
    return targetAssetsId;
  }

  public void setTargetAssetsId(String targetAssetsId) {
    this.targetAssetsId = targetAssetsId;
  }

  @Length(min = 0, max = 64, message = "目标资产API地址长度必须介于 0 和 64 之间")
  public String getTargetApi() {
    return targetApi;
  }

  public void setTargetApi(String targetApi) {
    this.targetApi = targetApi;
  }

  public AssetsManagerEntity getSourceAssets() {
    return sourceAssets;
  }

  public void setSourceAssets(AssetsManagerEntity sourceAssets) {
    this.sourceAssets = sourceAssets;
  }

  public AssetsManagerEntity getTargetAssets() {
    return targetAssets;
  }

  public void setTargetAssets(AssetsManagerEntity targetAssets) {
    this.targetAssets = targetAssets;
  }

  public String getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(String enterpriseId) {
    this.enterpriseId = enterpriseId;
  }
}