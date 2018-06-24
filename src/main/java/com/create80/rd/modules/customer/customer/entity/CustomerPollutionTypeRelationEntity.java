/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.customer.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 企业信息管理Entity
 * @author yzx
 * @version 2018-06-22
 */
public class CustomerPollutionTypeRelationEntity extends DataEntity<CustomerPollutionTypeRelationEntity> {
	
	private static final long serialVersionUID = 1L;
	private CustomerEntity customerEntity;		// 企业 父类
	      private String pollutionTypeId;		// 排污类型
	
	public CustomerPollutionTypeRelationEntity() {
		super();
	}

	public CustomerPollutionTypeRelationEntity(String id){
		super(id);
	}

	public CustomerPollutionTypeRelationEntity(CustomerEntity customerEntity){
		this.customerEntity = customerEntity;
	}

	     @Length(min=0, max=64, message="企业长度必须介于 0 和 64 之间")
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	     @Length(min=0, max=64, message="排污类型长度必须介于 0 和 64 之间")
	public String getPollutionTypeId() {
		return pollutionTypeId;
	}

	public void setPollutionTypeId(String pollutionTypeId) {
		this.pollutionTypeId = pollutionTypeId;
	}
	
}