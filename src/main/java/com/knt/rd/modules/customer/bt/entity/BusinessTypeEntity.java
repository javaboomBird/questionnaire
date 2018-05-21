/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.knt.rd.modules.customer.bt.entity;

import org.hibernate.validator.constraints.Length;

import com.knt.rd.common.persistence.DataEntity;

/**
 * 工商行业类型Entity
 * @author yzx
 * @version 2018-05-21
 */
public class BusinessTypeEntity extends DataEntity<BusinessTypeEntity> {
	
	private static final long serialVersionUID = 1L;
	private String businessTypeName;		// 类型名称
	
	public BusinessTypeEntity() {
		super();
	}

	public BusinessTypeEntity(String id){
		super(id);
	}

	@Length(min=0, max=32, message="类型名称长度必须介于 0 和 32 之间")
	public String getBusinessTypeName() {
		return businessTypeName;
	}

	public void setBusinessTypeName(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}
	
}