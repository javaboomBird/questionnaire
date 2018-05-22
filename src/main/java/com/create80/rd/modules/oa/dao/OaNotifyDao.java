/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.oa.dao;

import com.create80.rd.modules.oa.entity.OaNotify;
import com.create80.rd.common.persistence.CrudDao;
import com.create80.rd.common.persistence.annotation.MyBatisDao;
import com.create80.rd.common.persistence.CrudDao;
import com.create80.rd.common.persistence.annotation.MyBatisDao;
import com.create80.rd.modules.oa.entity.OaNotify;

/**
 * 通知通告DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface OaNotifyDao extends CrudDao<OaNotify> {
	
	/**
	 * 获取通知数目
	 * @param oaNotify
	 * @return
	 */
	public Long findCount(OaNotify oaNotify);
	
}