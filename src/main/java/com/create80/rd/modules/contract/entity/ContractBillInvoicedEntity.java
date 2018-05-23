/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.entity;

import com.create80.rd.common.persistence.DataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.hibernate.validator.constraints.Length;

/**
 * 合同开票管理Entity
 *
 * @author lzp
 * @version 2018-05-23
 */
public class ContractBillInvoicedEntity extends DataEntity<ContractBillInvoicedEntity> {

  private static final long serialVersionUID = 1L;
  private ContractBillInvoicingEntity invoicingEntity;    // 应开票序号 父类
  private String sn;    // 已开票序号
  private String name;    // 已开票名称
  private Double billInvoiced;    // 已开票金额
  private Date billInvoicedDate;    // 已开票时间
  private Date receiptDate;    // 收票回执时间
  private String picPath;    // 已开票照片路径

  public ContractBillInvoicedEntity() {
    super();
  }

  public ContractBillInvoicedEntity(String id) {
    super(id);
  }

  public ContractBillInvoicedEntity(ContractBillInvoicingEntity invoicingEntity) {
    this.invoicingEntity = invoicingEntity;
  }

  @Length(min = 0, max = 64, message = "应开票序号长度必须介于 0 和 64 之间")
  public ContractBillInvoicingEntity getInvoicingEntity() {
    return invoicingEntity;
  }

  public void setInvoicingEntity(ContractBillInvoicingEntity invoicingEntity) {
    this.invoicingEntity = invoicingEntity;
  }

  @Length(min = 0, max = 64, message = "已开票序号长度必须介于 0 和 64 之间")
  public String getSn() {
    return sn;
  }

  public void setSn(String sn) {
    this.sn = sn;
  }

  @Length(min = 0, max = 64, message = "已开票名称长度必须介于 0 和 64 之间")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getBillInvoiced() {
    return billInvoiced;
  }

  public void setBillInvoiced(Double billInvoiced) {
    this.billInvoiced = billInvoiced;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getBillInvoicedDate() {
    return billInvoicedDate;
  }

  public void setBillInvoicedDate(Date billInvoicedDate) {
    this.billInvoicedDate = billInvoicedDate;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getReceiptDate() {
    return receiptDate;
  }

  public void setReceiptDate(Date receiptDate) {
    this.receiptDate = receiptDate;
  }

  @Length(min = 0, max = 256, message = "已开票照片路径长度必须介于 0 和 256 之间")
  public String getPicPath() {
    return picPath;
  }

  public void setPicPath(String picPath) {
    this.picPath = picPath;
  }

}