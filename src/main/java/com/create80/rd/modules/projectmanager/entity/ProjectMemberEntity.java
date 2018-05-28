/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.projectmanager.entity;

import org.hibernate.validator.constraints.Length;
import com.create80.rd.modules.sys.entity.User;
import javax.validation.constraints.NotNull;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 项目管理Entity
 * @author yzx
 * @version 2018-05-28
 */
public class ProjectMemberEntity extends DataEntity<ProjectMemberEntity> {
	
	private static final long serialVersionUID = 1L;
	private ProjectEntity projectEntity;		// 项目 父类
			  private String memberId;
			  private User member;		// 项目成员
	      private String projectRole;		// 项目角色
	
	public ProjectMemberEntity() {
		super();
	}

	public ProjectMemberEntity(String id){
		super(id);
	}

	public ProjectMemberEntity(ProjectEntity projectEntity){
		this.projectEntity = projectEntity;
	}

	     @Length(min=1, max=64, message="项目长度必须介于 1 和 64 之间")
	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}
	     @NotNull(message="项目成员不能为空")


	     public String getMemberId(){
	       return memberId;
	     }

	     public void setMemberId(String memberId){
	     this.memberId = memberId;
	     }

	    public User getMember() {
	    	return member;
     	}

	   public void setMember(User member) {
		   this.member = member;
   	}
	     @Length(min=1, max=1, message="项目角色长度必须介于 1 和 1 之间")
	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}
	
}