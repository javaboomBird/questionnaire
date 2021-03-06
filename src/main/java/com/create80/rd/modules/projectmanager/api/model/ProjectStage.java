package com.create80.rd.modules.projectmanager.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjectStage implements Serializable {
  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.id
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String id;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.project_id
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String projectId;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.stage_name
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String stageName;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.stage_type
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String stageType;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.stage_status
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String stageStatus;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.stage_num
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private Integer stageNum;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.manager_id
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String managerId;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.plan_start_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private Date planStartTime;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.plan_end_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private Date planEndTime;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.actual_start_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private Date actualStartTime;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.actual_end_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private Date actualEndTime;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.progress
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String progress;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.has_document
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String hasDocument;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.insert_by
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String insertBy;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.insert_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private Date insertTime;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.update_by
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String updateBy;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.update_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private Date updateTime;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.remarks
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String remarks;

  /**
   *
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column project_stage.is_deleted
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private String isDeleted;

  private List<ProjectDocument> projectDocumentList;

  private Project project;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table project_stage
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.id
   *
   * @return the value of project_stage.id
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.id
   *
   * @param id the value for project_stage.id
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.project_id
   *
   * @return the value of project_stage.project_id
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getProjectId() {
    return projectId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.project_id
   *
   * @param projectId the value for project_stage.project_id
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.stage_name
   *
   * @return the value of project_stage.stage_name
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getStageName() {
    return stageName;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.stage_name
   *
   * @param stageName the value for project_stage.stage_name
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.stage_type
   *
   * @return the value of project_stage.stage_type
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getStageType() {
    return stageType;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.stage_type
   *
   * @param stageType the value for project_stage.stage_type
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setStageType(String stageType) {
    this.stageType = stageType;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.stage_status
   *
   * @return the value of project_stage.stage_status
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getStageStatus() {
    return stageStatus;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.stage_status
   *
   * @param stageStatus the value for project_stage.stage_status
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setStageStatus(String stageStatus) {
    this.stageStatus = stageStatus;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.stage_num
   *
   * @return the value of project_stage.stage_num
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public Integer getStageNum() {
    return stageNum;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.stage_num
   *
   * @param stageNum the value for project_stage.stage_num
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setStageNum(Integer stageNum) {
    this.stageNum = stageNum;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.manager_id
   *
   * @return the value of project_stage.manager_id
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getManagerId() {
    return managerId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.manager_id
   *
   * @param managerId the value for project_stage.manager_id
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setManagerId(String managerId) {
    this.managerId = managerId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.plan_start_time
   *
   * @return the value of project_stage.plan_start_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public Date getPlanStartTime() {
    return planStartTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.plan_start_time
   *
   * @param planStartTime the value for project_stage.plan_start_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setPlanStartTime(Date planStartTime) {
    this.planStartTime = planStartTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.plan_end_time
   *
   * @return the value of project_stage.plan_end_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public Date getPlanEndTime() {
    return planEndTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.plan_end_time
   *
   * @param planEndTime the value for project_stage.plan_end_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setPlanEndTime(Date planEndTime) {
    this.planEndTime = planEndTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.actual_start_time
   *
   * @return the value of project_stage.actual_start_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public Date getActualStartTime() {
    return actualStartTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.actual_start_time
   *
   * @param actualStartTime the value for project_stage.actual_start_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setActualStartTime(Date actualStartTime) {
    this.actualStartTime = actualStartTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.actual_end_time
   *
   * @return the value of project_stage.actual_end_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public Date getActualEndTime() {
    return actualEndTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.actual_end_time
   *
   * @param actualEndTime the value for project_stage.actual_end_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setActualEndTime(Date actualEndTime) {
    this.actualEndTime = actualEndTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.progress
   *
   * @return the value of project_stage.progress
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getProgress() {
    return progress;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.progress
   *
   * @param progress the value for project_stage.progress
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setProgress(String progress) {
    this.progress = progress;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.has_document
   *
   * @return the value of project_stage.has_document
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getHasDocument() {
    return hasDocument;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.has_document
   *
   * @param hasDocument the value for project_stage.has_document
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setHasDocument(String hasDocument) {
    this.hasDocument = hasDocument;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.insert_by
   *
   * @return the value of project_stage.insert_by
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getInsertBy() {
    return insertBy;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.insert_by
   *
   * @param insertBy the value for project_stage.insert_by
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setInsertBy(String insertBy) {
    this.insertBy = insertBy;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.insert_time
   *
   * @return the value of project_stage.insert_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public Date getInsertTime() {
    return insertTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.insert_time
   *
   * @param insertTime the value for project_stage.insert_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.update_by
   *
   * @return the value of project_stage.update_by
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getUpdateBy() {
    return updateBy;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.update_by
   *
   * @param updateBy the value for project_stage.update_by
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.update_time
   *
   * @return the value of project_stage.update_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public Date getUpdateTime() {
    return updateTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.update_time
   *
   * @param updateTime the value for project_stage.update_time
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.remarks
   *
   * @return the value of project_stage.remarks
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getRemarks() {
    return remarks;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.remarks
   *
   * @param remarks the value for project_stage.remarks
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column project_stage.is_deleted
   *
   * @return the value of project_stage.is_deleted
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public String getIsDeleted() {
    return isDeleted;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column project_stage.is_deleted
   *
   * @param isDeleted the value for project_stage.is_deleted
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  public void setIsDeleted(String isDeleted) {
    this.isDeleted = isDeleted;
  }

  public List<ProjectDocument> getProjectDocumentList() {
    return projectDocumentList;
  }

  public void setProjectDocumentList(List<ProjectDocument> projectDocumentList) {
    this.projectDocumentList=projectDocumentList;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table project_stage
   *
   * @mbg.generated Wed Jun 20 15:54:41 CST 2018
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", projectId=").append(projectId);
    sb.append(", stageName=").append(stageName);
    sb.append(", stageType=").append(stageType);
    sb.append(", stageStatus=").append(stageStatus);
    sb.append(", stageNum=").append(stageNum);
    sb.append(", managerId=").append(managerId);
    sb.append(", planStartTime=").append(planStartTime);
    sb.append(", planEndTime=").append(planEndTime);
    sb.append(", actualStartTime=").append(actualStartTime);
    sb.append(", actualEndTime=").append(actualEndTime);
    sb.append(", progress=").append(progress);
    sb.append(", hasDocument=").append(hasDocument);
    sb.append(", insertBy=").append(insertBy);
    sb.append(", insertTime=").append(insertTime);
    sb.append(", updateBy=").append(updateBy);
    sb.append(", updateTime=").append(updateTime);
    sb.append(", remarks=").append(remarks);
    sb.append(", isDeleted=").append(isDeleted);
    sb.append(", projectDocumentList=").append(projectDocumentList);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}