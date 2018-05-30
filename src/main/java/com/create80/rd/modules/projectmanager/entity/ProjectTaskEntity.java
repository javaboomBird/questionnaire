/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.projectmanager.entity;

import org.hibernate.validator.constraints.Length;
import com.create80.rd.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.google.common.collect.Lists;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 项目任务信息管理Entity
 *
 * @author yzx
 * @version 2018-05-29
 */
public class ProjectTaskEntity extends DataEntity<ProjectTaskEntity> {

  private static final long serialVersionUID = 1L;
  private String projectId;    // 项目
  private String stageId;    // 阶段
  private String taskPre;    // 前置任务
  private String taskName;    // 任务名称
  private String taskStatus;    // 任务状态
  private String managerId;
  private User manager;    // 负责人
  private Double estimateTime;    // 预估工时
  private Date planStartTime;    // 计划开始时间
  private Date planEndTime;    // 计划结束时间
  private Date actualStartTime;    // 实际开始时间
  private Date actualEndTime;    // 实际结束时间
  private String progress;    // 进度
  private List<ProjectTaskMemberEntity> projectTaskMemberList = Lists.newArrayList();    // 子表列表

  private ProjectEntity project;
  private ProjectStageEntity stage;

  public ProjectTaskEntity() {
    super();
  }

  public ProjectTaskEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "项目长度必须介于 1 和 64 之间")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  @Length(min = 1, max = 64, message = "阶段长度必须介于 1 和 64 之间")
  public String getStageId() {
    return stageId;
  }

  public void setStageId(String stageId) {
    this.stageId = stageId;
  }

  @Length(min = 0, max = 64, message = "前置任务长度必须介于 0 和 64 之间")
  public String getTaskPre() {
    return taskPre;
  }

  public void setTaskPre(String taskPre) {
    this.taskPre = taskPre;
  }

  @Length(min = 1, max = 32, message = "任务名称长度必须介于 1 和 32 之间")
  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  @Length(min = 0, max = 1, message = "任务状态长度必须介于 0 和 1 之间")
  public String getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(String taskStatus) {
    this.taskStatus = taskStatus;
  }


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

  public Double getEstimateTime() {
    return estimateTime;
  }

  public void setEstimateTime(Double estimateTime) {
    this.estimateTime = estimateTime;
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

  public List<ProjectTaskMemberEntity> getProjectTaskMemberList() {
    return projectTaskMemberList;
  }

  public void setProjectTaskMemberList(List<ProjectTaskMemberEntity> projectTaskMemberList) {
    this.projectTaskMemberList = projectTaskMemberList;
  }

  public ProjectEntity getProject() {
    return project;
  }

  public void setProject(ProjectEntity project) {
    this.project = project;
  }

  public ProjectStageEntity getStage() {
    return stage;
  }

  public void setStage(ProjectStageEntity stage) {
    this.stage = stage;
  }
}