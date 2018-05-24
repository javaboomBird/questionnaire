/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.enterprise.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 企业信息管理Entity
 * @author yzx
 * @version 2018-05-24
 */
public class EnterprisePollutionTypeRelationEntity extends DataEntity<EnterprisePollutionTypeRelationEntity> {
	
	private static final long serialVersionUID = 1L;
	private EnterpriseEntity enterpriseEntity;		// 企业ID 父类
	      private String pollutionTypeId;		// 排污类型
	
	public EnterprisePollutionTypeRelationEntity() {
		super();
	}

	public EnterprisePollutionTypeRelationEntity(String id){
		super(id);
	}

	public EnterprisePollutionTypeRelationEntity(EnterpriseEntity enterpriseEntity){
		this.enterpriseEntity = enterpriseEntity;
	}

	     @Length(min=0, max=64, message="企业ID长度必须介于 0 和 64 之间")
	public EnterpriseEntity getEnterpriseEntity() {
		return enterpriseEntity;
	}

	public void setEnterpriseEntity(EnterpriseEntity enterpriseEntity) {
		this.enterpriseEntity = enterpriseEntity;
	}
	     @Length(min=0, max=64, message="排污类型长度必须介于 0 和 64 之间")
	public String getPollutionTypeId() {
		return pollutionTypeId;
	}

	public void setPollutionTypeId(String pollutionTypeId) {
		this.pollutionTypeId = pollutionTypeId;
	}
	
}