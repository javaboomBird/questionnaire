/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.projectmanager.entity;

import org.hibernate.validator.constraints.Length;
import com.create80.rd.modules.sys.entity.User;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.google.common.collect.Lists;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 项目管理Entity
 *
 * @author yzx
 * @version 2018-05-30
 */
public class ProjectEntity extends DataEntity<ProjectEntity> {

  private static final long serialVersionUID = 1L;
  private String projectCode;    // 项目编号
  private String projectName;    // 项目名称
  private String projectDescription;    // 描述
  private String projectType;    // 项目类型
  private String projectStatus;    // 项目状态
  private String managerId;
  private User manager;    // 项目经理
  private Date planStartTime;    // 计划开始时间
  private Date planEndTime;    // 计划结束时间
  private Date actualStartTime;    // 时间开始时间
  private Date actualEndTime;    // 实际结束时间
  private String progress;    // 进度
  private List<ProjectContactRelationEntity> projectContactRelationList = Lists
      .newArrayList();    // 子表列表
  private List<ProjectMemberEntity> projectMemberList = Lists.newArrayList();    // 子表列表

  public ProjectEntity() {
    super();
  }

  public ProjectEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 32, message = "项目编号长度必须介于 1 和 32 之间")
  public String getProjectCode() {
    return projectCode;
  }

  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
  }

  @Length(min = 1, max = 32, message = "项目名称长度必须介于 1 和 32 之间")
  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  @Length(min = 0, max = 255, message = "描述长度必须介于 0 和 255 之间")
  public String getProjectDescription() {
    return projectDescription;
  }

  public void setProjectDescription(String projectDescription) {
    this.projectDescription = projectDescription;
  }

  @Length(min = 0, max = 1, message = "项目类型长度必须介于 0 和 1 之间")
  public String getProjectType() {
    return projectType;
  }

  public void setProjectType(String projectType) {
    this.projectType = projectType;
  }

  @Length(min = 0, max = 1, message = "项目状态长度必须介于 0 和 1 之间")
  public String getProjectStatus() {
    return projectStatus;
  }

  public void setProjectStatus(String projectStatus) {
    this.projectStatus = projectStatus;
  }

  @NotNull(message = "项目经理不能为空")

  public String getManagerId() {
    return managerId;
  }

  public void setManagerId(String managerId) {
    this.managerId = managerId;
  }

  public User getManager() {
    return manager;
  }

  public void setManager(User manager) {
    this.manager = manager;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getPlanStartTime() {
    return planStartTime;
  }

  public void setPlanStartTime(Date planStartTime) {
    this.planStartTime = planStartTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getPlanEndTime() {
    return planEndTime;
  }

  public void setPlanEndTime(Date planEndTime) {
    this.planEndTime = planEndTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getActualStartTime() {
    return actualStartTime;
  }

  public void setActualStartTime(Date actualStartTime) {
    this.actualStartTime = actualStartTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getActualEndTime() {
    return actualEndTime;
  }

  public void setActualEndTime(Date actualEndTime) {
    this.actualEndTime = actualEndTime;
  }

  @Length(min = 0, max = 10, message = "进度长度必须介于 0 和 10 之间")
  public String getProgress() {
    return progress;
  }

  public void setProgress(String progress) {
    this.progress = progress;
  }

  public List<ProjectContactRelationEntity> getProjectContactRelationList() {
    return projectContactRelationList;
  }

  public void setProjectContactRelationList(
      List<ProjectContactRelationEntity> projectContactRelationList) {
    this.projectContactRelationList = projectContactRelationList;
  }

  public List<ProjectMemberEntity> getProjectMemberList() {
    return projectMemberList;
  }

  public void setProjectMemberList(List<ProjectMemberEntity> projectMemberList) {
    this.projectMemberList = projectMemberList;
  }
}