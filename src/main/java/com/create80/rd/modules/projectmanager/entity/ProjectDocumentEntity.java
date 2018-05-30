/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.projectmanager.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 项目阶段管理Entity
 * @author yzx
 * @version 2018-05-29
 */
public class ProjectDocumentEntity extends DataEntity<ProjectDocumentEntity> {
	
	private static final long serialVersionUID = 1L;
	      private String projectId;		// 项目
	private ProjectStageEntity stageEntity;		// 阶段 父类
	      private String documentName;		// 文档名称
	      private String documentType;		// 文档类型
	      private String filePath;		// 附件
	      private String documentNum;		// 文档序号
	
	public ProjectDocumentEntity() {
		super();
	}

	public ProjectDocumentEntity(String id){
		super(id);
	}

	public ProjectDocumentEntity(ProjectStageEntity stageEntity){
		this.stageEntity = stageEntity;
	}

	     @Length(min=1, max=64, message="项目长度必须介于 1 和 64 之间")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	     @Length(min=1, max=64, message="阶段长度必须介于 1 和 64 之间")
	public ProjectStageEntity getStageEntity() {
		return stageEntity;
	}

	public void setStageEntity(ProjectStageEntity stageEntity) {
		this.stageEntity = stageEntity;
	}
	     @Length(min=0, max=64, message="文档名称长度必须介于 0 和 64 之间")
	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	
	     @Length(min=0, max=1, message="文档类型长度必须介于 0 和 1 之间")
	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	     @Length(min=0, max=255, message="附件长度必须介于 0 和 255 之间")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getDocumentNum() {
		return documentNum;
	}

	public void setDocumentNum(String documentNum) {
		this.documentNum = documentNum;
	}
	
}