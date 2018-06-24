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
public class CustomerContactEntity extends DataEntity<CustomerContactEntity> {
	
	private static final long serialVersionUID = 1L;
	      private String customerType;		// 联系人类型:0 是企业 1是政府
	private CustomerEntity customerEntity;		// 客户ID 父类
	      private String name;		// 联系人
	      private String title;		// 职务
	      private String phone;		// 电话
	      private String email;		// 邮箱
	
	public CustomerContactEntity() {
		super();
	}

	public CustomerContactEntity(String id){
		super(id);
	}

	public CustomerContactEntity(CustomerEntity customerEntity){
		this.customerEntity = customerEntity;
	}

	     @Length(min=1, max=1, message="联系人类型:0 是企业 1是政府长度必须介于 1 和 1 之间")
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	     @Length(min=0, max=32, message="联系人长度必须介于 0 和 32 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	     @Length(min=0, max=32, message="职务长度必须介于 0 和 32 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	     @Length(min=0, max=32, message="电话长度必须介于 0 和 32 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	     @Length(min=0, max=32, message="邮箱长度必须介于 0 和 32 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}