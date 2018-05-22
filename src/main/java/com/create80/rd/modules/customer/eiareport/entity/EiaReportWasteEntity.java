/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.customer.eiareport.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 环评报告信息管理Entity
 * @author yzx
 * @version 2018-05-22
 */
public class EiaReportWasteEntity extends DataEntity<EiaReportWasteEntity> {
	
	private static final long serialVersionUID = 1L;
	private EiaReportEntity eiaReportEntity;		// 环评报告 父类
	private String type;		// 排放类型
	private String allowConcentration;		// 允许浓度
	private String allowScale;		// 允许总量
	
	public EiaReportWasteEntity() {
		super();
	}

	public EiaReportWasteEntity(String id){
		super(id);
	}

	public EiaReportWasteEntity(EiaReportEntity eiaReportEntity){
		this.eiaReportEntity = eiaReportEntity;
	}

	@Length(min=1, max=64, message="环评报告长度必须介于 1 和 64 之间")
	public EiaReportEntity getEiaReportEntity() {
		return eiaReportEntity;
	}

	public void setEiaReportEntity(EiaReportEntity eiaReportEntity) {
		this.eiaReportEntity = eiaReportEntity;
	}
	
	@Length(min=0, max=32, message="排放类型长度必须介于 0 和 32 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=128, message="允许浓度长度必须介于 0 和 128 之间")
	public String getAllowConcentration() {
		return allowConcentration;
	}

	public void setAllowConcentration(String allowConcentration) {
		this.allowConcentration = allowConcentration;
	}
	
	@Length(min=0, max=128, message="允许总量长度必须介于 0 和 128 之间")
	public String getAllowScale() {
		return allowScale;
	}

	public void setAllowScale(String allowScale) {
		this.allowScale = allowScale;
	}
	
}