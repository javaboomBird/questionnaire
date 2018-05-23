/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.eiareport.entity;


import com.create80.rd.modules.customer.enterprise.entity.EnterpriseEntity;
import com.create80.rd.modules.customer.pt.entity.PollutionTypeEntity;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.google.common.collect.Lists;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 环评报告信息管理Entity
 * @author yzx
 * @version 2018-05-22
 */
public class EiaReportEntity extends DataEntity<EiaReportEntity> {
	
	private static final long serialVersionUID = 1L;
	private String enterpriseId;		// 企业
	private String approved;		// 有审批
	private Date approveDate;		// 审批时间
	private String accepted;		// 三同时验收
	private Date acceptDate;		// 验收时间
	private String expanded;		// 存在扩建
	private String expendedDevice;		// 扩建设备
	private String pollutionTypeId;		// 排污类型
	private String pollutionPermitStatus;		// 排污许可状况
	private String reportFile;		// 环评报告文件
	private String enterpriseName;
	private String pollutionTypeName;

	private List<EiaReportPicEntity> eiaReportPicList = Lists.newArrayList();		// 子表列表
	private List<EiaReportWasteEntity> eiaReportWasteList = Lists.newArrayList();		// 子表列表

	private EnterpriseEntity enterprise;

	private PollutionTypeEntity pollutionType;
	
	public EiaReportEntity() {
		super();
	}

	public EiaReportEntity(String id){
		super(id);
	}

	@Length(min=1, max=64, message="企业长度必须介于 1 和 64 之间")
	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	
	@Length(min=0, max=1, message="有审批长度必须介于 0 和 1 之间")
	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	
	@Length(min=0, max=1, message="三同时验收长度必须介于 0 和 1 之间")
	public String getAccepted() {
		return accepted;
	}

	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}
	
	@Length(min=0, max=1, message="存在扩建长度必须介于 0 和 1 之间")
	public String getExpanded() {
		return expanded;
	}

	public void setExpanded(String expanded) {
		this.expanded = expanded;
	}
	
	@Length(min=0, max=256, message="扩建设备长度必须介于 0 和 256 之间")
	public String getExpendedDevice() {
		return expendedDevice;
	}

	public void setExpendedDevice(String expendedDevice) {
		this.expendedDevice = expendedDevice;
	}
	
	@Length(min=0, max=64, message="排污类型长度必须介于 0 和 64 之间")
	public String getPollutionTypeId() {
		return pollutionTypeId;
	}

	public void setPollutionTypeId(String pollutionTypeId) {
		this.pollutionTypeId = pollutionTypeId;
	}
	
	@Length(min=0, max=1, message="排污许可状况长度必须介于 0 和 1 之间")
	public String getPollutionPermitStatus() {
		return pollutionPermitStatus;
	}

	public void setPollutionPermitStatus(String pollutionPermitStatus) {
		this.pollutionPermitStatus = pollutionPermitStatus;
	}
	
	@Length(min=0, max=256, message="环评报告文件长度必须介于 0 和 256 之间")
	public String getReportFile() {
		return reportFile;
	}

	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
	}
	
	public List<EiaReportPicEntity> getEiaReportPicList() {
		return eiaReportPicList;
	}

	public void setEiaReportPicList(List<EiaReportPicEntity> eiaReportPicList) {
		this.eiaReportPicList = eiaReportPicList;
	}
	public List<EiaReportWasteEntity> getEiaReportWasteList() {
		return eiaReportWasteList;
	}

	public void setEiaReportWasteList(List<EiaReportWasteEntity> eiaReportWasteList) {
		this.eiaReportWasteList = eiaReportWasteList;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getPollutionTypeName() {
		return pollutionTypeName;
	}

	public void setPollutionTypeName(String pollutionTypeName) {
		this.pollutionTypeName = pollutionTypeName;
	}

	public EnterpriseEntity getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(EnterpriseEntity enterprise) {
		this.enterprise = enterprise;
	}

	public PollutionTypeEntity getPollutionType() {
		return pollutionType;
	}

	public void setPollutionType(
			PollutionTypeEntity pollutionType) {
		this.pollutionType = pollutionType;
	}
}