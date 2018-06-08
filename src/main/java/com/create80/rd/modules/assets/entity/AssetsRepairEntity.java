/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.assets.entity;

import org.hibernate.validator.constraints.Length;
import com.create80.rd.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 资产维修Entity
 *
 * @author yzx
 * @version 2018-06-06
 */
public class AssetsRepairEntity extends DataEntity<AssetsRepairEntity> {

  private static final long serialVersionUID = 1L;
  private String repairNo;    // 维修编号
  private String assetsId;    // 资产
  private String applicantId;
  private User applicant;    // 申请人
  private Date repairTime;    // 送修时间
  private String faultDescription;    // 故障描述
  private String repairComplete;    // 维修是否完成
  private Date completeTime;    // 完成时间
  private String faultAnalysis;    // 故障分析
  private AssetsManagerEntity assetsManager;

  public AssetsRepairEntity() {
    super();
  }

  public AssetsRepairEntity(String id) {
    super(id);
  }

  @Length(min = 1, max = 64, message = "维修编号长度必须介于 1 和 64 之间")
  public String getRepairNo() {
    return repairNo;
  }

  public void setRepairNo(String repairNo) {
    this.repairNo = repairNo;
  }

  @Length(min = 0, max = 64, message = "资产长度必须介于 0 和 64 之间")
  public String getAssetsId() {
    return assetsId;
  }

  public void setAssetsId(String assetsId) {
    this.assetsId = assetsId;
  }


  public String getApplicantId() {
    return applicantId;
  }

  public void setApplicantId(String applicantId) {
    this.applicantId = applicantId;
  }

  public User getApplicant() {
    return applicant;
  }

  public void setApplicant(User applicant) {
    this.applicant = applicant;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getRepairTime() {
    return repairTime;
  }

  public void setRepairTime(Date repairTime) {
    this.repairTime = repairTime;
  }

  @Length(min = 0, max = 255, message = "故障描述长度必须介于 0 和 255 之间")
  public String getFaultDescription() {
    return faultDescription;
  }

  public void setFaultDescription(String faultDescription) {
    this.faultDescription = faultDescription;
  }

  @Length(min = 0, max = 1, message = "维修是否完成长度必须介于 0 和 1 之间")
  public String getRepairComplete() {
    return repairComplete;
  }

  public void setRepairComplete(String repairComplete) {
    this.repairComplete = repairComplete;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(Date completeTime) {
    this.completeTime = completeTime;
  }

  @Length(min = 0, max = 255, message = "故障分析长度必须介于 0 和 255 之间")
  public String getFaultAnalysis() {
    return faultAnalysis;
  }

  public void setFaultAnalysis(String faultAnalysis) {
    this.faultAnalysis = faultAnalysis;
  }

  public AssetsManagerEntity getAssetsManager() {
    return assetsManager;
  }

  public void setAssetsManager(AssetsManagerEntity assetsManager) {
    this.assetsManager = assetsManager;
  }
}