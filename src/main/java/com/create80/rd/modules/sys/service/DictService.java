/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.sys.service;

import com.create80.rd.modules.sys.dao.DictDao;
import com.create80.rd.modules.sys.entity.Dict;
import com.create80.rd.modules.sys.utils.DictUtils;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.create80.rd.common.service.CrudService;
import com.create80.rd.common.utils.CacheUtils;
import com.create80.rd.modules.sys.dao.DictDao;
import com.create80.rd.modules.sys.entity.Dict;
import com.create80.rd.modules.sys.utils.DictUtils;

/**
 * 字典Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class DictService extends CrudService<DictDao, Dict> {
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		super.save(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	@Transactional(readOnly = false)
	public void delete(Dict dict) {
		super.delete(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

}
