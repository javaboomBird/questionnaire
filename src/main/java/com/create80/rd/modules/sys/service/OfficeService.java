/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.sys.service;

import com.create80.rd.modules.sys.dao.OfficeDao;
import com.create80.rd.modules.sys.entity.Office;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.create80.rd.common.service.TreeService;
import com.create80.rd.modules.sys.dao.OfficeDao;
import com.create80.rd.modules.sys.entity.Office;
import com.create80.rd.modules.sys.utils.UserUtils;

/**
 * 机构Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class OfficeService extends TreeService<OfficeDao, Office> {

	public List<Office> findAll(){
		return UserUtils.getOfficeList();
	}

	public List<Office> findList(Boolean isAll){
		if (isAll != null && isAll){
			return UserUtils.getOfficeAllList();
		}else{
			return UserUtils.getOfficeList();
		}
	}
	
	@Transactional(readOnly = true)
	public List<Office> findList(Office office){
		if(office != null){
			office.setParentIds(office.getParentIds()+"%");
			return dao.findByParentIdsLike(office);
		}
		return  new ArrayList<Office>();
	}
	
	@Transactional(readOnly = false)
	public void save(Office office) {
		super.save(office);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Office office) {
		super.delete(office);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
	
}
