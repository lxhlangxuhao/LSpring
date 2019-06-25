package com.hao.xu.lang.service;

import com.hao.xu.lang.config.DynamicDataSourceContextHolder;
import com.hao.xu.lang.entity.User;
import com.hao.xu.lang.mapper.oracle.LangUserMapper;
import com.hao.xu.lang.mapper.mysql.UserMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:38 2019/6/9
 */
@Service
public class UserServiceImpl implements  UserService {

	@Resource
	private LangUserMapper langUserMapper;

//	@Resource
	private UserMapper userMapper;

	@Override
	public User findUser(int id) {
		DynamicDataSourceContextHolder.setDataSourceType("mysqlDataSource");
		return userMapper.selectByPrimaryKey(1);
	}
}
