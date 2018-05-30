/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.projectmanager.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 项目模板Entity
 * @author yzx
 * @version 2018-05-30
 */
public class ProjectTemplateEntity extends DataEntity<ProjectTemplateEntity> {
	
	private static final long serialVersionUID = 1L;
	      private String projectId;		// 项目
	      private String templateName;		// 模板名称
	
	public ProjectTemplateEntity() {
		super();
	}

	public ProjectTemplateEntity(String id){
		super(id);
	}

	     @Length(min=1, max=64, message="项目长度必须介于 1 和 64 之间")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	     @Length(min=1, max=64, message="模板名称长度必须介于 1 和 64 之间")
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
}