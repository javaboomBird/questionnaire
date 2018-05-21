/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.knt.rd.modules.act.dao;

import com.knt.rd.common.persistence.CrudDao;
import com.knt.rd.common.persistence.annotation.MyBatisDao;
import com.knt.rd.common.persistence.CrudDao;
import com.knt.rd.common.persistence.annotation.MyBatisDao;
import com.knt.rd.modules.act.entity.Act;

/**
 * 审批DAO接口
 * @author thinkgem
 * @version 2014-05-16
 */
@MyBatisDao
public interface ActDao extends CrudDao<Act> {

	public int updateProcInsIdByBusinessId(Act act);
	
}
