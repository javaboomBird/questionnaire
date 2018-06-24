/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.eiareport.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 环评报告信息管理Entity
 *
 * @author yzx
 * @version 2018-06-22
 */
public class CustomerEiaReportPicEntity extends DataEntity<CustomerEiaReportPicEntity> {

  private static final long serialVersionUID = 1L;
  private CustomerEiaReportEntity eiaReportEntity;    // 环评报告 父类
  private String type;    // 图片类型
  private String name;    // 图片名
  private String filePath;    // 图片保存路径

  public CustomerEiaReportPicEntity() {
    super();
  }

  public CustomerEiaReportPicEntity(String id) {
    super(id);
  }

  public CustomerEiaReportPicEntity(CustomerEiaReportEntity eiaReportEntity) {
    this.eiaReportEntity = eiaReportEntity;
  }

  @Length(min = 0, max = 64, message = "环评报告长度必须介于 0 和 64 之间")
  public CustomerEiaReportEntity getEiaReportEntity() {
    return eiaReportEntity;
  }

  public void setEiaReportEntity(CustomerEiaReportEntity eiaReportEntity) {
    this.eiaReportEntity = eiaReportEntity;
  }

  @Length(min = 0, max = 32, message = "图片类型长度必须介于 0 和 32 之间")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Length(min = 0, max = 64, message = "图片名长度必须介于 0 和 64 之间")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Length(min = 0, max = 256, message = "图片保存路径长度必须介于 0 和 256 之间")
  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

}