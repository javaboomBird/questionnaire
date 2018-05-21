/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.knt.rd.modules.sys.dao;

import com.knt.rd.common.persistence.TreeDao;
import com.knt.rd.common.persistence.annotation.MyBatisDao;
import com.knt.rd.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	
}
