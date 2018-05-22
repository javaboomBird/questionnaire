/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.oa.dao;

import com.create80.rd.modules.oa.entity.TestAudit;
import com.create80.rd.common.persistence.CrudDao;
import com.create80.rd.common.persistence.annotation.MyBatisDao;
import com.create80.rd.common.persistence.CrudDao;
import com.create80.rd.common.persistence.annotation.MyBatisDao;
import com.create80.rd.modules.oa.entity.TestAudit;

/**
 * 审批DAO接口
 * @author thinkgem
 * @version 2014-05-16
 */
@MyBatisDao
public interface TestAuditDao extends CrudDao<TestAudit> {

	public TestAudit getByProcInsId(String procInsId);
	
	public int updateInsId(TestAudit testAudit);
	
	public int updateHrText(TestAudit testAudit);
	
	public int updateLeadText(TestAudit testAudit);
	
	public int updateMainLeadText(TestAudit testAudit);
	
}
