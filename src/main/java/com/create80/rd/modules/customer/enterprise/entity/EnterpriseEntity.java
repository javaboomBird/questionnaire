/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.enterprise.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.create80.rd.modules.sys.entity.Area;
import javax.validation.constraints.NotNull;
import java.util.List;
import com.google.common.collect.Lists;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 企业信息管理Entity
 * @author yzx
 * @version 2018-05-21
 */
public class EnterpriseEntity extends DataEntity<EnterpriseEntity> {
	
	private static final long serialVersionUID = 1L;
	private String enterpriseName;		// 企业名称
	private String lat;		// 纬度
	private String lng;		// 经度
	private String uscCode;		// 信用代码
	private String legalPerson;		// 法人
	private String registeredCapital;		// 注册资本
	private Date registeredDate;		// 注册日期
	private String registeredAddress;		// 注册地址
	private String registeredPostcode;		// 注册邮编
	private Area area;		// 区域
	private String businessScope;		// 经营范围
	private String businessPhone;		// 办公电话
	private String businessFax;		// fax 号码
	private String bankAccount;		// 银行账户名称
	private String bankNumber;		// 银行账户卡号
	private String bankName;		// 开户行名称
	private String taxNumber;		// 税号
	private String taxPhone;		// 开票电话
	private String recyclingType;		// 回用类型
	private String statusType;		// 企业状态
	private List<EnterpriseBusinessTypeRelationEntity> enterpriseBusinessTypeRelationList = Lists.newArrayList();		// 子表列表
	private List<EnterpriseIndustryTypeRelationEntity> enterpriseIndustryTypeRelationList = Lists.newArrayList();		// 子表列表
	private List<EnterprisePollutionTypeRelationEntity> enterprisePollutionTypeRelationList = Lists.newArrayList();		// 子表列表
	
	public EnterpriseEntity() {
		super();
	}

	public EnterpriseEntity(String id){
		super(id);
	}

	@Length(min=1, max=64, message="企业名称长度必须介于 1 和 64 之间")
	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}
	
	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
	@Length(min=0, max=32, message="信用代码长度必须介于 0 和 32 之间")
	public String getUscCode() {
		return uscCode;
	}

	public void setUscCode(String uscCode) {
		this.uscCode = uscCode;
	}
	
	@Length(min=0, max=32, message="法人长度必须介于 0 和 32 之间")
	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	
	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	@Length(min=0, max=128, message="注册地址长度必须介于 0 和 128 之间")
	public String getRegisteredAddress() {
		return registeredAddress;
	}

	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}
	
	public String getRegisteredPostcode() {
		return registeredPostcode;
	}

	public void setRegisteredPostcode(String registeredPostcode) {
		this.registeredPostcode = registeredPostcode;
	}
	
	@NotNull(message="区域不能为空")
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	@Length(min=0, max=512, message="经营范围长度必须介于 0 和 512 之间")
	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	
	@Length(min=0, max=32, message="办公电话长度必须介于 0 和 32 之间")
	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}
	
	@Length(min=0, max=32, message="fax 号码长度必须介于 0 和 32 之间")
	public String getBusinessFax() {
		return businessFax;
	}

	public void setBusinessFax(String businessFax) {
		this.businessFax = businessFax;
	}
	
	@Length(min=0, max=64, message="银行账户名称长度必须介于 0 和 64 之间")
	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Length(min=0, max=32, message="银行账户卡号长度必须介于 0 和 32 之间")
	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	
	@Length(min=0, max=32, message="开户行名称长度必须介于 0 和 32 之间")
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Length(min=1, max=32, message="税号长度必须介于 1 和 32 之间")
	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	
	@Length(min=0, max=32, message="开票电话长度必须介于 0 和 32 之间")
	public String getTaxPhone() {
		return taxPhone;
	}

	public void setTaxPhone(String taxPhone) {
		this.taxPhone = taxPhone;
	}
	
	@Length(min=1, max=1, message="回用类型长度必须介于 1 和 1 之间")
	public String getRecyclingType() {
		return recyclingType;
	}

	public void setRecyclingType(String recyclingType) {
		this.recyclingType = recyclingType;
	}
	
	@Length(min=1, max=1, message="企业状态长度必须介于 1 和 1 之间")
	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	public List<EnterpriseBusinessTypeRelationEntity> getEnterpriseBusinessTypeRelationList() {
		return enterpriseBusinessTypeRelationList;
	}

	public void setEnterpriseBusinessTypeRelationList(List<EnterpriseBusinessTypeRelationEntity> enterpriseBusinessTypeRelationList) {
		this.enterpriseBusinessTypeRelationList = enterpriseBusinessTypeRelationList;
	}
	public List<EnterpriseIndustryTypeRelationEntity> getEnterpriseIndustryTypeRelationList() {
		return enterpriseIndustryTypeRelationList;
	}

	public void setEnterpriseIndustryTypeRelationList(List<EnterpriseIndustryTypeRelationEntity> enterpriseIndustryTypeRelationList) {
		this.enterpriseIndustryTypeRelationList = enterpriseIndustryTypeRelationList;
	}
	public List<EnterprisePollutionTypeRelationEntity> getEnterprisePollutionTypeRelationList() {
		return enterprisePollutionTypeRelationList;
	}

	public void setEnterprisePollutionTypeRelationList(List<EnterprisePollutionTypeRelationEntity> enterprisePollutionTypeRelationList) {
		this.enterprisePollutionTypeRelationList = enterprisePollutionTypeRelationList;
	}
}