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
public class CustomerPicEntity extends DataEntity<CustomerPicEntity> {
	
	private static final long serialVersionUID = 1L;
	private CustomerEntity customerEntity;		// 客户 父类
	      private String filePath;		// 保存路径
	
	public CustomerPicEntity() {
		super();
	}

	public CustomerPicEntity(String id){
		super(id);
	}

	public CustomerPicEntity(CustomerEntity customerEntity){
		this.customerEntity = customerEntity;
	}

	     @Length(min=1, max=64, message="客户长度必须介于 1 和 64 之间")
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	     @Length(min=0, max=256, message="保存路径长度必须介于 0 和 256 之间")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}