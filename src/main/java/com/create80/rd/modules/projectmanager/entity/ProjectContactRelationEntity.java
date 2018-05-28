/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.projectmanager.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 项目管理Entity
 * @author yzx
 * @version 2018-05-28
 */
public class ProjectContactRelationEntity extends DataEntity<ProjectContactRelationEntity> {
	
	private static final long serialVersionUID = 1L;
	private ProjectEntity projectEntity;		// 项目 父类
	      private String contactId;		// 合同
	
	public ProjectContactRelationEntity() {
		super();
	}

	public ProjectContactRelationEntity(String id){
		super(id);
	}

	public ProjectContactRelationEntity(ProjectEntity projectEntity){
		this.projectEntity = projectEntity;
	}

	     @Length(min=1, max=64, message="项目长度必须介于 1 和 64 之间")
	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}
	     @Length(min=1, max=64, message="合同长度必须介于 1 和 64 之间")
	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	
}