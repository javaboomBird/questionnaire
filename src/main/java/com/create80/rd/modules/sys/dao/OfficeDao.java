/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.sys.dao;

import com.create80.rd.modules.sys.entity.Office;
import com.create80.rd.common.persistence.TreeDao;
import com.create80.rd.common.persistence.annotation.MyBatisDao;
import com.create80.rd.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}
