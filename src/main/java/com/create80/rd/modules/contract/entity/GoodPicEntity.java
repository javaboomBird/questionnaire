/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.entity;

import com.create80.rd.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 合同商品管理Entity
 *
 * @author lzp
 * @version 2018-05-23
 */
public class GoodPicEntity extends DataEntity<GoodPicEntity> {

  private static final long serialVersionUID = 1L;
  private GoodEntity goodEntity;    // 商品 id 父类
  private String description;    // 图片描述
  private String name;    // 文件名
  private String type;    // 文件类型
  private String path;    // 图片路径

  public GoodPicEntity() {
    super();
  }

  public GoodPicEntity(String id) {
    super(id);
  }

  public GoodPicEntity(GoodEntity goodEntity) {
    this.goodEntity = goodEntity;
  }

  @Length(min = 0, max = 64, message = "商品 id长度必须介于 0 和 64 之间")
  public GoodEntity getGoodEntity() {
    return goodEntity;
  }

  public void setGoodEntity(GoodEntity goodEntity) {
    this.goodEntity = goodEntity;
  }

  @Length(min = 0, max = 128, message = "图片描述长度必须介于 0 和 128 之间")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Length(min = 0, max = 128, message = "文件名长度必须介于 0 和 128 之间")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Length(min = 0, max = 32, message = "文件类型长度必须介于 0 和 32 之间")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Length(min = 0, max = 256, message = "图片路径长度必须介于 0 和 256 之间")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

}