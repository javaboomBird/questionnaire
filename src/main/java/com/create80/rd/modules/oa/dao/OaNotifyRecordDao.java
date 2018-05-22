/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.oa.dao;

import com.create80.rd.modules.oa.entity.OaNotifyRecord;
import com.create80.rd.common.persistence.CrudDao;
import com.create80.rd.common.persistence.annotation.MyBatisDao;
import java.util.List;

import com.create80.rd.common.persistence.CrudDao;
import com.create80.rd.common.persistence.annotation.MyBatisDao;
import com.create80.rd.modules.oa.entity.OaNotifyRecord;

/**
 * 通知通告记录DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface OaNotifyRecordDao extends CrudDao<OaNotifyRecord> {

	/**
	 * 插入通知记录
	 * @param oaNotifyRecordList
	 * @return
	 */
	public int insertAll(List<OaNotifyRecord> oaNotifyRecordList);
	
	/**
	 * 根据通知ID删除通知记录
	 * @param oaNotifyId 通知ID
	 * @return
	 */
	public int deleteByOaNotifyId(String oaNotifyId);
	
}