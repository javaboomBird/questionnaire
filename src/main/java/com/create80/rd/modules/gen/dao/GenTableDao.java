/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.gen.dao;

import com.create80.rd.modules.gen.entity.GenTable;
import com.create80.rd.common.persistence.CrudDao;
import com.create80.rd.common.persistence.annotation.MyBatisDao;
import com.create80.rd.modules.gen.entity.GenTable;

/**
 * 业务表DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTableDao extends CrudDao<GenTable> {
	
}
