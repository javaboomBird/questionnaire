/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.contract.entity;

import org.hibernate.validator.constraints.Length;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 合同管理Entity
 * @author lzp
 * @version 2018-06-12
 */
public class ContractGoodEntity extends DataEntity<ContractGoodEntity> {
	
	private static final long serialVersionUID = 1L;
	private ContractEntity contractEntity;		// 合同 id 父类
	      private String goodId;		// 商品 id
	      private Double sellingPrice;		// 销售单价
	      private Integer sellingQuantity;		// 销售数量
	      private Double totalPrice;		// 销售总价
	
	public ContractGoodEntity() {
		super();
	}

	public ContractGoodEntity(String id){
		super(id);
	}

	public ContractGoodEntity(ContractEntity contractEntity){
		this.contractEntity = contractEntity;
	}

	     @Length(min=0, max=64, message="合同 id长度必须介于 0 和 64 之间")
	public ContractEntity getContractEntity() {
		return contractEntity;
	}

	public void setContractEntity(ContractEntity contractEntity) {
		this.contractEntity = contractEntity;
	}
	     @Length(min=0, max=64, message="商品 id长度必须介于 0 和 64 之间")
	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	
	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public Integer getSellingQuantity() {
		return sellingQuantity;
	}

	public void setSellingQuantity(Integer sellingQuantity) {
		this.sellingQuantity = sellingQuantity;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}