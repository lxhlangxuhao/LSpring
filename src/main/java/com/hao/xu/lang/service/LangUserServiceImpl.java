package com.hao.xu.lang.service;

import com.hao.xu.lang.annotation.DataSource;
import com.hao.xu.lang.entity.LangUser;
import com.hao.xu.lang.entity.User;
import com.hao.xu.lang.mapper.oracle.LangUserMapper;
import com.hao.xu.lang.mapper.mysql.UserMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:50 2019/6/9
 */
@Service
public class LangUserServiceImpl implements LangUserService {

	@Resource
	private LangUserMapper langUserMapper;

//	@Resource
	private UserMapper userMapper;

	@Resource
	private UserService userService;


	@Override
	@Transactional
	@DataSource(DataSource.ORACLE)
	public LangUser selectByPrimaryKey(int id) {
		//新增
		LangUser langUser = new LangUser();
		langUser.setName("小风啊");
		langUser.setAge(20);
		langUser.setScore("55");
		langUserMapper.insert(langUser);
//		LangUser langUser2 = null;
//		langUser2.getAge();


		return null;
	}

	@Override
//	@Transactional
//	@DataSource(DataSource.MYSQL)
	public void insertUser(User user) {
		User user1 = new User();
		user1.setId(20);
		user1.setName("aaa");
		user1.setDepartment("aa");
		user1.setScore(0);
		userMapper.insertUser(user1);
	}

}
