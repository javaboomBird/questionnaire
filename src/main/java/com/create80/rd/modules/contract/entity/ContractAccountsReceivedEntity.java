/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 合同收款管理Entity
 * @author lzp
 * @version 2018-05-31
 */
public class ContractAccountsReceivedEntity extends DataEntity<ContractAccountsReceivedEntity> {
	
	private static final long serialVersionUID = 1L;
	private ContractAccountsReceivableEntity receivableEntity;		// 付款序号 父类
	      private String sn;		// 已收款序号
	      private String name;		// 已收款名称
	      private Double accountsReceived;		// 已收账款
	      private Integer accountsReceivedPercent;		// 已收账款百分比
	      private String accountsReceivedMethod;		// 已收账款方式
	      private Date accountsReceivedDate;		// 已收账款时间
	
	public ContractAccountsReceivedEntity() {
		super();
	}

	public ContractAccountsReceivedEntity(String id){
		super(id);
	}

	public ContractAccountsReceivedEntity(ContractAccountsReceivableEntity receivableEntity){
		this.receivableEntity = receivableEntity;
	}

	     @Length(min=0, max=64, message="付款序号长度必须介于 0 和 64 之间")
	public ContractAccountsReceivableEntity getReceivableEntity() {
		return receivableEntity;
	}

	public void setReceivableEntity(ContractAccountsReceivableEntity receivableEntity) {
		this.receivableEntity = receivableEntity;
	}
	     @Length(min=1, max=64, message="已收款序号长度必须介于 1 和 64 之间")
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}
	
	     @Length(min=0, max=64, message="已收款名称长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Double getAccountsReceived() {
		return accountsReceived;
	}

	public void setAccountsReceived(Double accountsReceived) {
		this.accountsReceived = accountsReceived;
	}
	
	public Integer getAccountsReceivedPercent() {
		return accountsReceivedPercent;
	}

	public void setAccountsReceivedPercent(Integer accountsReceivedPercent) {
		this.accountsReceivedPercent = accountsReceivedPercent;
	}
	
	     @Length(min=0, max=64, message="已收账款方式长度必须介于 0 和 64 之间")
	public String getAccountsReceivedMethod() {
		return accountsReceivedMethod;
	}

	public void setAccountsReceivedMethod(String accountsReceivedMethod) {
		this.accountsReceivedMethod = accountsReceivedMethod;
	}
	
	     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAccountsReceivedDate() {
		return accountsReceivedDate;
	}

	public void setAccountsReceivedDate(Date accountsReceivedDate) {
		this.accountsReceivedDate = accountsReceivedDate;
	}
	
}