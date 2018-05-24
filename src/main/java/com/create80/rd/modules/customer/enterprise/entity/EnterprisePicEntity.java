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
public class EnterprisePicEntity extends DataEntity<EnterprisePicEntity> {
	
	private static final long serialVersionUID = 1L;
	private EnterpriseEntity enterpriseEntity;		// 企业 父类
	      private String filePath;		// 图片路径
	
	public EnterprisePicEntity() {
		super();
	}

	public EnterprisePicEntity(String id){
		super(id);
	}

	public EnterprisePicEntity(EnterpriseEntity enterpriseEntity){
		this.enterpriseEntity = enterpriseEntity;
	}

	     @Length(min=1, max=64, message="企业长度必须介于 1 和 64 之间")
	public EnterpriseEntity getEnterpriseEntity() {
		return enterpriseEntity;
	}

	public void setEnterpriseEntity(EnterpriseEntity enterpriseEntity) {
		this.enterpriseEntity = enterpriseEntity;
	}
	     @Length(min=0, max=256, message="图片路径长度必须介于 0 和 256 之间")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}