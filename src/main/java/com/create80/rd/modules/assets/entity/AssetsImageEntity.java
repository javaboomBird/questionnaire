/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 资产管理Entity
 * @author yzx
 * @version 2018-06-05
 */
public class AssetsImageEntity extends DataEntity<AssetsImageEntity> {
	
	private static final long serialVersionUID = 1L;
	private AssetsManagerEntity assetsManagerEntity;		// 资产 父类
	      private String path;		// 保存路径
	
	public AssetsImageEntity() {
		super();
	}

	public AssetsImageEntity(String id){
		super(id);
	}

	public AssetsImageEntity(AssetsManagerEntity assetsManagerEntity){
		this.assetsManagerEntity = assetsManagerEntity;
	}

	     @Length(min=0, max=64, message="资产长度必须介于 0 和 64 之间")
	public AssetsManagerEntity getAssetsManagerEntity() {
		return assetsManagerEntity;
	}

	public void setAssetsManagerEntity(AssetsManagerEntity assetsManagerEntity) {
		this.assetsManagerEntity = assetsManagerEntity;
	}
	     @Length(min=0, max=64, message="保存路径长度必须介于 0 和 64 之间")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}