package com.create80.rd.modules.assets.api.model;

import java.io.Serializable;
import java.util.Date;

public class AssetsRepair implements Serializable {

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.id
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String id;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.repair_no
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String repairNo;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.assets_id
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String assetsId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.applicant_id
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String applicantId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.repair_time
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private Date repairTime;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.fault_description
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String faultDescription;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.repair_complete
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String repairComplete;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.complete_time
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private Date completeTime;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.fault_analysis
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String faultAnalysis;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.insert_by
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String insertBy;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.insert_time
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private Date insertTime;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.update_by
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String updateBy;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.update_time
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private Date updateTime;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.remarks
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String remarks;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column assets_repair.is_deleted
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private String isDeleted;


  private AssetsManager assetsManager;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table assets_repair
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.id
   *
   * @return the value of assets_repair.id
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.id
   *
   * @param id the value for assets_repair.id
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.repair_no
   *
   * @return the value of assets_repair.repair_no
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getRepairNo() {
    return repairNo;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.repair_no
   *
   * @param repairNo the value for assets_repair.repair_no
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setRepairNo(String repairNo) {
    this.repairNo = repairNo;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.assets_id
   *
   * @return the value of assets_repair.assets_id
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getAssetsId() {
    return assetsId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.assets_id
   *
   * @param assetsId the value for assets_repair.assets_id
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setAssetsId(String assetsId) {
    this.assetsId = assetsId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.applicant_id
   *
   * @return the value of assets_repair.applicant_id
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getApplicantId() {
    return applicantId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.applicant_id
   *
   * @param applicantId the value for assets_repair.applicant_id
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setApplicantId(String applicantId) {
    this.applicantId = applicantId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.repair_time
   *
   * @return the value of assets_repair.repair_time
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public Date getRepairTime() {
    return repairTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.repair_time
   *
   * @param repairTime the value for assets_repair.repair_time
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setRepairTime(Date repairTime) {
    this.repairTime = repairTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.fault_description
   *
   * @return the value of assets_repair.fault_description
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getFaultDescription() {
    return faultDescription;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.fault_description
   *
   * @param faultDescription the value for assets_repair.fault_description
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setFaultDescription(String faultDescription) {
    this.faultDescription = faultDescription;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.repair_complete
   *
   * @return the value of assets_repair.repair_complete
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getRepairComplete() {
    return repairComplete;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.repair_complete
   *
   * @param repairComplete the value for assets_repair.repair_complete
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setRepairComplete(String repairComplete) {
    this.repairComplete = repairComplete;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.complete_time
   *
   * @return the value of assets_repair.complete_time
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public Date getCompleteTime() {
    return completeTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.complete_time
   *
   * @param completeTime the value for assets_repair.complete_time
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setCompleteTime(Date completeTime) {
    this.completeTime = completeTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.fault_analysis
   *
   * @return the value of assets_repair.fault_analysis
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getFaultAnalysis() {
    return faultAnalysis;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.fault_analysis
   *
   * @param faultAnalysis the value for assets_repair.fault_analysis
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setFaultAnalysis(String faultAnalysis) {
    this.faultAnalysis = faultAnalysis;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.insert_by
   *
   * @return the value of assets_repair.insert_by
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getInsertBy() {
    return insertBy;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.insert_by
   *
   * @param insertBy the value for assets_repair.insert_by
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setInsertBy(String insertBy) {
    this.insertBy = insertBy;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.insert_time
   *
   * @return the value of assets_repair.insert_time
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public Date getInsertTime() {
    return insertTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.insert_time
   *
   * @param insertTime the value for assets_repair.insert_time
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.update_by
   *
   * @return the value of assets_repair.update_by
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getUpdateBy() {
    return updateBy;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.update_by
   *
   * @param updateBy the value for assets_repair.update_by
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.update_time
   *
   * @return the value of assets_repair.update_time
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public Date getUpdateTime() {
    return updateTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.update_time
   *
   * @param updateTime the value for assets_repair.update_time
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.remarks
   *
   * @return the value of assets_repair.remarks
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getRemarks() {
    return remarks;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.remarks
   *
   * @param remarks the value for assets_repair.remarks
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column assets_repair.is_deleted
   *
   * @return the value of assets_repair.is_deleted
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public String getIsDeleted() {
    return isDeleted;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column assets_repair.is_deleted
   *
   * @param isDeleted the value for assets_repair.is_deleted
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  public void setIsDeleted(String isDeleted) {
    this.isDeleted = isDeleted;
  }

  public AssetsManager getAssetsManager() {
    return assetsManager;
  }

  public void setAssetsManager(AssetsManager assetsManager) {
    this.assetsManager = assetsManager;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table assets_repair
   *
   * @mbg.generated Wed Jun 20 16:41:01 CST 2018
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", repairNo=").append(repairNo);
    sb.append(", assetsId=").append(assetsId);
    sb.append(", applicantId=").append(applicantId);
    sb.append(", repairTime=").append(repairTime);
    sb.append(", faultDescription=").append(faultDescription);
    sb.append(", repairComplete=").append(repairComplete);
    sb.append(", completeTime=").append(completeTime);
    sb.append(", faultAnalysis=").append(faultAnalysis);
    sb.append(", insertBy=").append(insertBy);
    sb.append(", insertTime=").append(insertTime);
    sb.append(", updateBy=").append(updateBy);
    sb.append(", updateTime=").append(updateTime);
    sb.append(", remarks=").append(remarks);
    sb.append(", isDeleted=").append(isDeleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}