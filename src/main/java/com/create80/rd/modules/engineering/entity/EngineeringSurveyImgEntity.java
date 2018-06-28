/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.engineering.entity;

import com.create80.rd.modules.customer.customer.entity.CustomerEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 勘察图片Entity
 *
 * @author yzx
 * @version 2018-06-27
 */
public class EngineeringSurveyImgEntity extends DataEntity<EngineeringSurveyImgEntity> {

  private static final long serialVersionUID = 1L;
  private String engineeringId;    // 工单
  private String customerId;    // 客户
  private Date uploadTime;    // 上传时间
  private String uploadBy;    // 上传者
  private String iamgePath;    // 图片路径
  private String description;    // description

  private EngineeringWorkOrderEntity engineeringWorkOrder;
  private CustomerEntity customer;


  public EngineeringSurveyImgEntity() {
    super();
  }

  public EngineeringSurveyImgEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "工单长度必须介于 1 和 64 之间")
  public String getEngineeringId() {
    return engineeringId;
  }

  public void setEngineeringId(String engineeringId) {
    this.engineeringId = engineeringId;
  }

  @Length(min = 1, max = 64, message = "客户长度必须介于 1 和 64 之间")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getUploadTime() {
    return uploadTime;
  }

  public void setUploadTime(Date uploadTime) {
    this.uploadTime = uploadTime;
  }

  @Length(min = 0, max = 64, message = "上传者长度必须介于 0 和 64 之间")
  public String getUploadBy() {
    return uploadBy;
  }

  public void setUploadBy(String uploadBy) {
    this.uploadBy = uploadBy;
  }

  @Length(min = 0, max = 500, message = "图片路径长度必须介于 0 和 500 之间")
  public String getIamgePath() {
    return iamgePath;
  }

  public void setIamgePath(String iamgePath) {
    this.iamgePath = iamgePath;
  }

  @Length(min = 0, max = 100, message = "description长度必须介于 0 和 100 之间")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EngineeringWorkOrderEntity getEngineeringWorkOrder() {
    return engineeringWorkOrder;
  }

  public void setEngineeringWorkOrder(
      EngineeringWorkOrderEntity engineeringWorkOrder) {
    this.engineeringWorkOrder = engineeringWorkOrder;
  }

  public CustomerEntity getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerEntity customer) {
    this.customer = customer;
  }
}