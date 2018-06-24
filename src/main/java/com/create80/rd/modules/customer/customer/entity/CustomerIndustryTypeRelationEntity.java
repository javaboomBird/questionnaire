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
public class CustomerIndustryTypeRelationEntity extends DataEntity<CustomerIndustryTypeRelationEntity> {
	
	private static final long serialVersionUID = 1L;
	private CustomerEntity customerEntity;		// 客户 父类
	      private String industryTypeId;		// 污染行业类型
	
	public CustomerIndustryTypeRelationEntity() {
		super();
	}

	public CustomerIndustryTypeRelationEntity(String id){
		super(id);
	}

	public CustomerIndustryTypeRelationEntity(CustomerEntity customerEntity){
		this.customerEntity = customerEntity;
	}

	     @Length(min=0, max=64, message="客户长度必须介于 0 和 64 之间")
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	     @Length(min=0, max=64, message="污染行业类型长度必须介于 0 和 64 之间")
	public String getIndustryTypeId() {
		return industryTypeId;
	}

	public void setIndustryTypeId(String industryTypeId) {
		this.industryTypeId = industryTypeId;
	}
	
}