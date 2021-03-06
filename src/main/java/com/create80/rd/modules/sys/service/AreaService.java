/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.sys.service;

import com.create80.rd.modules.sys.entity.Area;
import com.create80.rd.modules.sys.dao.AreaDao;
import com.create80.rd.modules.sys.entity.Area;
import com.create80.rd.modules.sys.utils.UserUtils;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.create80.rd.common.service.TreeService;
import com.create80.rd.modules.sys.dao.AreaDao;
import com.create80.rd.modules.sys.entity.Area;
import com.create80.rd.modules.sys.utils.UserUtils;

/**
 * 区域Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends TreeService<AreaDao, Area> {

	public List<Area> findAll(){
		return UserUtils.getAreaList();
	}

	@Transactional(readOnly = false)
	public void save(Area area) {
		super.save(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Area area) {
		super.delete(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
}
