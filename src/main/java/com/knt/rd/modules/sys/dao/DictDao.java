/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.knt.rd.modules.sys.dao;

import java.util.List;

import com.knt.rd.common.persistence.CrudDao;
import com.knt.rd.common.persistence.annotation.MyBatisDao;
import com.knt.rd.modules.sys.entity.Dict;

/**
 * 字典DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

	public List<String> findTypeList(Dict dict);
	
}
