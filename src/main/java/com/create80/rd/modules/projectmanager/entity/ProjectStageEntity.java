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
 * 项目阶段管理Entity
 *
 * @author yzx
 * @version 2018-05-29
 */
public class ProjectStageEntity extends DataEntity<ProjectStageEntity> {

  private static final long serialVersionUID = 1L;
  private String projectId;    // 项目
  private String stageName;    // 阶段名称
  private String stageType;    // 阶段类型
  private String stageStatus;    // 阶段状态
  private String stageNum;    // 阶段序号
  private String managerId;
  private User manager;    // 负责人
  private Date planStartTime;    // 计划开始时间
  private Date planEndTime;    // 计划结束时间
  private Date actualStartTime;    // 实际开始时间
  private Date actualEndTime;    // 实际结束时间
  private String progress;    // 进度
  private String hasDocument;    // 有交接文档

  private ProjectEntity projectEntity;
  private List<ProjectDocumentEntity> projectDocumentList = Lists.newArrayList();    // 子表列表

  public ProjectStageEntity() {
    super();
  }

  public ProjectStageEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "项目长度必须介于 1 和 64 之间")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  @Length(min = 1, max = 64, message = "阶段名称长度必须介于 1 和 64 之间")
  public String getStageName() {
    return stageName;
  }

  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  @Length(min = 0, max = 1, message = "阶段类型长度必须介于 0 和 1 之间")
  public String getStageType() {
    return stageType;
  }

  public void setStageType(String stageType) {
    this.stageType = stageType;
  }

  @Length(min = 0, max = 1, message = "阶段状态长度必须介于 0 和 1 之间")
  public String getStageStatus() {
    return stageStatus;
  }

  public void setStageStatus(String stageStatus) {
    this.stageStatus = stageStatus;
  }

  public String getStageNum() {
    return stageNum;
  }

  public void setStageNum(String stageNum) {
    this.stageNum = stageNum;
  }

  @NotNull(message = "负责人不能为空")

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

  @Length(min = 0, max = 1, message = "有交接文档长度必须介于 0 和 1 之间")
  public String getHasDocument() {
    return hasDocument;
  }

  public void setHasDocument(String hasDocument) {
    this.hasDocument = hasDocument;
  }

  public List<ProjectDocumentEntity> getProjectDocumentList() {
    return projectDocumentList;
  }

  public void setProjectDocumentList(List<ProjectDocumentEntity> projectDocumentList) {
    this.projectDocumentList = projectDocumentList;
  }

  public ProjectEntity getProjectEntity() {
    return projectEntity;
  }

  public void setProjectEntity(ProjectEntity projectEntity) {
    this.projectEntity = projectEntity;
  }
}