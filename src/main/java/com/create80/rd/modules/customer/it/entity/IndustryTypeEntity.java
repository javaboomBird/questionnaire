/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.it.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 污染行业类型Entity
 * @author yzx
 * @version 2018-05-21
 */
public class IndustryTypeEntity extends DataEntity<IndustryTypeEntity> {
	
	private static final long serialVersionUID = 1L;
	private String industryTypeName;		// 类型名称
	
	public IndustryTypeEntity() {
		super();
	}

	public IndustryTypeEntity(String id){
		super(id);
	}

	@Length(min=0, max=32, message="类型名称长度必须介于 0 和 32 之间")
	public String getIndustryTypeName() {
		return industryTypeName;
	}

	public void setIndustryTypeName(String industryTypeName) {
		this.industryTypeName = industryTypeName;
	}
	
}