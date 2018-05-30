/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.projectmanager.entity;

import org.hibernate.validator.constraints.Length;
import com.create80.rd.modules.sys.entity.User;
import javax.validation.constraints.NotNull;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 项目任务信息管理Entity
 * @author yzx
 * @version 2018-05-29
 */
public class ProjectTaskMemberEntity extends DataEntity<ProjectTaskMemberEntity> {
	
	private static final long serialVersionUID = 1L;
	private ProjectTaskEntity projectTaskEntity;		// 任务 父类
			  private String memberId;
			  private User member;		// 成员
	
	public ProjectTaskMemberEntity() {
		super();
	}

	public ProjectTaskMemberEntity(String id){
		super(id);
	}

	public ProjectTaskMemberEntity(ProjectTaskEntity projectTaskEntity){
		this.projectTaskEntity = projectTaskEntity;
	}

	     @Length(min=1, max=64, message="任务长度必须介于 1 和 64 之间")
	public ProjectTaskEntity getProjectTaskEntity() {
		return projectTaskEntity;
	}

	public void setProjectTaskEntity(ProjectTaskEntity projectTaskEntity) {
		this.projectTaskEntity = projectTaskEntity;
	}
	     @NotNull(message="成员不能为空")


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
}