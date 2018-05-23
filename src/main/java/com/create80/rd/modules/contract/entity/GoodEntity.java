/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.entity;

import com.create80.rd.common.persistence.DataEntity;
import com.google.common.collect.Lists;
import java.util.List;
import org.hibernate.validator.constraints.Length;

/**
 * 合同商品管理Entity
 *
 * @author lzp
 * @version 2018-05-23
 */
public class GoodEntity extends DataEntity<GoodEntity> {

  private static final long serialVersionUID = 1L;
  private String no;    // 商品编号
  private String name;    // 商品名称
  private String model;    // 商品型号
  private String type;    // 商品类型
  private String manufacturer;    // 生产厂商
  private String supplier;    // 供应厂商
  private Double purchasePrice;    // 采购价
  private Double tagPrice;    // 建议售价
  private String introduction;    // 商品介绍
  private List<GoodPicEntity> goodPicList = Lists.newArrayList();    // 子表列表

  public GoodEntity() {
    super();
  }

  public GoodEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 128, message = "商品编号长度必须介于 1 和 128 之间")
  public String getNo() {
    return no;
  }

  public void setNo(String no) {
    this.no = no;
  }

  @Length(min = 1, max = 128, message = "商品名称长度必须介于 1 和 128 之间")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Length(min = 0, max = 128, message = "商品型号长度必须介于 0 和 128 之间")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  @Length(min = 0, max = 8, message = "商品类型长度必须介于 0 和 8 之间")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Length(min = 0, max = 128, message = "生产厂商长度必须介于 0 和 128 之间")
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Length(min = 0, max = 128, message = "供应厂商长度必须介于 0 和 128 之间")
  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public Double getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(Double purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public Double getTagPrice() {
    return tagPrice;
  }

  public void setTagPrice(Double tagPrice) {
    this.tagPrice = tagPrice;
  }

  @Length(min = 0, max = 256, message = "商品介绍长度必须介于 0 和 256 之间")
  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public List<GoodPicEntity> getGoodPicList() {
    return goodPicList;
  }

  public void setGoodPicList(List<GoodPicEntity> goodPicList) {
    this.goodPicList = goodPicList;
  }
}