package com.create80.rd.modules.sys.service;


import com.create80.rd.common.service.CrudService;
import com.create80.rd.modules.sys.dao.UserDao;
import com.create80.rd.modules.sys.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户service
 */
@Service
@Transactional(readOnly = true)
public class UserService extends CrudService<UserDao, User> {


}
