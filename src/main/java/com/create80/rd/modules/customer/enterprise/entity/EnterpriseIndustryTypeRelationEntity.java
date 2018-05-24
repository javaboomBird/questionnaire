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
public class EnterpriseIndustryTypeRelationEntity extends DataEntity<EnterpriseIndustryTypeRelationEntity> {
	
	private static final long serialVersionUID = 1L;
	private EnterpriseEntity enterpriseEntity;		// 企业ID 父类
	      private String industryTypeId;		// 污染行业类型
	
	public EnterpriseIndustryTypeRelationEntity() {
		super();
	}

	public EnterpriseIndustryTypeRelationEntity(String id){
		super(id);
	}

	public EnterpriseIndustryTypeRelationEntity(EnterpriseEntity enterpriseEntity){
		this.enterpriseEntity = enterpriseEntity;
	}

	     @Length(min=0, max=64, message="企业ID长度必须介于 0 和 64 之间")
	public EnterpriseEntity getEnterpriseEntity() {
		return enterpriseEntity;
	}

	public void setEnterpriseEntity(EnterpriseEntity enterpriseEntity) {
		this.enterpriseEntity = enterpriseEntity;
	}
	     @Length(min=0, max=64, message="污染行业类型长度必须介于 0 和 64 之间")
	public String getIndustryTypeId() {
		return industryTypeId;
	}

	public void setIndustryTypeId(String industryTypeId) {
		this.industryTypeId = industryTypeId;
	}
	
}