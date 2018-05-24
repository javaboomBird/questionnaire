/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.government.entity;

import org.hibernate.validator.constraints.Length;
import com.create80.rd.modules.sys.entity.Area;
import java.util.List;
import com.google.common.collect.Lists;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 政府信息管理Entity
 * @author yzx
 * @version 2018-05-24
 */
public class GovernmentEntity extends DataEntity<GovernmentEntity> {
	
	private static final long serialVersionUID = 1L;
	      private String governmentName;		// 政府名称
	      private String lat;		// 纬度
	      private String lng;		// 经度
	      private String uscCode;		// 统一社会信用代码
	      private String address;		// 地址
	      private String registeredPostcode;		// 注册邮编
	      private String businessPhone;		// 办公电话
	      private String businessFax;		// fax 号码
	      private String bankAccount;		// 银行账户名称
	      private String bankNumber;		// 银行账户卡号
	      private String bankName;		// 开户行名称
	      private String taxNumber;		// 税号
	      private String taxPhone;		// 开票电话
			  private String areaId;
			  private Area area;		// 区域ID
	private List<ContactEntity> contactList = Lists.newArrayList();		// 子表列表
	
	public GovernmentEntity() {
		super();
	}

	public GovernmentEntity(String id){
		super(id);
	}

	     @Length(min=1, max=64, message="政府名称长度必须介于 1 和 64 之间")
	public String getGovernmentName() {
		return governmentName;
	}

	public void setGovernmentName(String governmentName) {
		this.governmentName = governmentName;
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
	
	     @Length(min=1, max=32, message="统一社会信用代码长度必须介于 1 和 32 之间")
	public String getUscCode() {
		return uscCode;
	}

	public void setUscCode(String uscCode) {
		this.uscCode = uscCode;
	}
	
	     @Length(min=1, max=128, message="地址长度必须介于 1 和 128 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRegisteredPostcode() {
		return registeredPostcode;
	}

	public void setRegisteredPostcode(String registeredPostcode) {
		this.registeredPostcode = registeredPostcode;
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
	
	     @Length(min=0, max=32, message="税号长度必须介于 0 和 32 之间")
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
	


	     public String getAreaId(){
	       return areaId;
	     }

	     public void setAreaId(String areaId){
	     this.areaId = areaId;
	     }

	    public Area getArea() {
	    	return area;
     	}

	   public void setArea(Area area) {
		   this.area = area;
   	}
	public List<ContactEntity> getContactList() {
		return contactList;
	}

	public void setContactList(List<ContactEntity> contactList) {
		this.contactList = contactList;
	}
}