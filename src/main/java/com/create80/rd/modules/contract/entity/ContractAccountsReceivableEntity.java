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
 * 合同收款管理Entity
 *
 * @author lzp
 * @version 2018-05-23
 */
public class ContractAccountsReceivableEntity extends DataEntity<ContractAccountsReceivableEntity> {

  private static final long serialVersionUID = 1L;
  private String contractId;    // 合同 id
  private String sn;    // 应收款序号
  private String name;    // 应收款名称
  private String condition;    // 应收款条件
  private Double accountsReceivable;    // 应收账款
  private Integer accountsReceivablePercent;    // 应收账款百分比
  private String accountsReceivableMethod;    // 应收账款方式
  private Date accountsReceivableDate;    // 应收账款时间
  private String keepNotification;    // 是否持续提醒
  private List<ContractAccountsReceivedEntity> contractAccountsReceivedList = Lists
      .newArrayList();    // 子表列表

  public ContractAccountsReceivableEntity() {
    super();
  }

  public ContractAccountsReceivableEntity(String id) {
    super(id);
  }

  @Length(min = 0, max = 64, message = "合同 id长度必须介于 0 和 64 之间")
  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }

  @Length(min = 0, max = 64, message = "应收款序号长度必须介于 0 和 64 之间")
  public String getSn() {
    return sn;
  }

  public void setSn(String sn) {
    this.sn = sn;
  }

  @Length(min = 0, max = 64, message = "应收款名称长度必须介于 0 和 64 之间")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Length(min = 0, max = 128, message = "应收款条件长度必须介于 0 和 128 之间")
  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public Double getAccountsReceivable() {
    return accountsReceivable;
  }

  public void setAccountsReceivable(Double accountsReceivable) {
    this.accountsReceivable = accountsReceivable;
  }

  public Integer getAccountsReceivablePercent() {
    return accountsReceivablePercent;
  }

  public void setAccountsReceivablePercent(Integer accountsReceivablePercent) {
    this.accountsReceivablePercent = accountsReceivablePercent;
  }

  @Length(min = 0, max = 64, message = "应收账款方式长度必须介于 0 和 64 之间")
  public String getAccountsReceivableMethod() {
    return accountsReceivableMethod;
  }

  public void setAccountsReceivableMethod(String accountsReceivableMethod) {
    this.accountsReceivableMethod = accountsReceivableMethod;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getAccountsReceivableDate() {
    return accountsReceivableDate;
  }

  public void setAccountsReceivableDate(Date accountsReceivableDate) {
    this.accountsReceivableDate = accountsReceivableDate;
  }

  public String getKeepNotification() {
    return keepNotification;
  }

  public void setKeepNotification(String keepNotification) {
    this.keepNotification = keepNotification;
  }

  public List<ContractAccountsReceivedEntity> getContractAccountsReceivedList() {
    return contractAccountsReceivedList;
  }

  public void setContractAccountsReceivedList(
      List<ContractAccountsReceivedEntity> contractAccountsReceivedList) {
    this.contractAccountsReceivedList = contractAccountsReceivedList;
  }
}