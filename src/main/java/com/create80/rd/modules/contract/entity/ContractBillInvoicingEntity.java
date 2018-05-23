/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.entity;

import com.create80.rd.common.persistence.DataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.Length;

/**
 * 合同开票管理Entity
 *
 * @author lzp
 * @version 2018-05-23
 */
public class ContractBillInvoicingEntity extends DataEntity<ContractBillInvoicingEntity> {

  private static final long serialVersionUID = 1L;
  private String contractId;    // 合同 id
  private String sn;    // 应开票序号
  private String name;    // 应开票名称
  private String condition;    // 应开票条件
  private Double billInvoicing;    // 应开票金额
  private Date billInvoicingDate;    // 应开票时间
  private String keepNotification;    // 是否持续提醒
  private List<ContractBillInvoicedEntity> contractBillInvoicedList = Lists
      .newArrayList();    // 子表列表

  public ContractBillInvoicingEntity() {
    super();
  }

  public ContractBillInvoicingEntity(String id) {
    super(id);
  }

  @Length(min = 0, max = 64, message = "合同 id长度必须介于 0 和 64 之间")
  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }

  @Length(min = 0, max = 64, message = "应开票序号长度必须介于 0 和 64 之间")
  public String getSn() {
    return sn;
  }

  public void setSn(String sn) {
    this.sn = sn;
  }

  @Length(min = 0, max = 64, message = "应开票名称长度必须介于 0 和 64 之间")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Length(min = 0, max = 128, message = "应开票条件长度必须介于 0 和 128 之间")
  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public Double getBillInvoicing() {
    return billInvoicing;
  }

  public void setBillInvoicing(Double billInvoicing) {
    this.billInvoicing = billInvoicing;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getBillInvoicingDate() {
    return billInvoicingDate;
  }

  public void setBillInvoicingDate(Date billInvoicingDate) {
    this.billInvoicingDate = billInvoicingDate;
  }

  public String getKeepNotification() {
    return keepNotification;
  }

  public void setKeepNotification(String keepNotification) {
    this.keepNotification = keepNotification;
  }

  public List<ContractBillInvoicedEntity> getContractBillInvoicedList() {
    return contractBillInvoicedList;
  }

  public void setContractBillInvoicedList(
      List<ContractBillInvoicedEntity> contractBillInvoicedList) {
    this.contractBillInvoicedList = contractBillInvoicedList;
  }
}