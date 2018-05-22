/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.pt.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 排污类型管理Entity
 * @author yzx
 * @version 2018-05-21
 */
public class PollutionTypeEntity extends DataEntity<PollutionTypeEntity> {
	
	private static final long serialVersionUID = 1L;
	private String pollutionTypeName;		// 类型名称
	
	public PollutionTypeEntity() {
		super();
	}

	public PollutionTypeEntity(String id){
		super(id);
	}

	@Length(min=0, max=32, message="类型名称长度必须介于 0 和 32 之间")
	public String getPollutionTypeName() {
		return pollutionTypeName;
	}

	public void setPollutionTypeName(String pollutionTypeName) {
		this.pollutionTypeName = pollutionTypeName;
	}
	
}