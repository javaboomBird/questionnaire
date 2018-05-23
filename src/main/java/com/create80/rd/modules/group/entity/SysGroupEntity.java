/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.group.entity;

import com.create80.rd.modules.sys.entity.Office;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.google.common.collect.Lists;

import com.create80.rd.common.persistence.DataEntity;

/**
 * 分组管理Entity
 * @author yzx
 * @version 2018-05-23
 */
public class SysGroupEntity extends DataEntity<SysGroupEntity> {
	
	private static final long serialVersionUID = 1L;
	private Office office;		// 组织
	private String groupName;		// 组名
	private List<SysUserGroupEntity> sysUserGroupList = Lists.newArrayList();		// 子表列表
	
	public SysGroupEntity() {
		super();
	}

	public SysGroupEntity(String id){
		super(id);
	}

	@NotNull(message="组织不能为空")
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=0, max=32, message="组名长度必须介于 0 和 32 之间")
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public List<SysUserGroupEntity> getSysUserGroupList() {
		return sysUserGroupList;
	}

	public void setSysUserGroupList(List<SysUserGroupEntity> sysUserGroupList) {
		this.sysUserGroupList = sysUserGroupList;
	}
}