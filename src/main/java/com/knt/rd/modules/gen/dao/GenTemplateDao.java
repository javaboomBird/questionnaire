/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.knt.rd.modules.gen.dao;

import com.knt.rd.common.persistence.CrudDao;
import com.knt.rd.common.persistence.annotation.MyBatisDao;
import com.knt.rd.modules.gen.entity.GenTemplate;

/**
 * 代码模板DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTemplateDao extends CrudDao<GenTemplate> {
	
}