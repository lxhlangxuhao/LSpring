package com.hao.xu.lang.service;

import com.hao.xu.lang.entity.LangUser;
import com.hao.xu.lang.entity.User;
import com.hao.xu.lang.mapper.mysql.UserMapper;
import com.hao.xu.lang.mapper.oracle.LangUserMapper;
import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 17:10 2019/3/3
 */
@Service
public class TestServiceImpl implements TestService {

	@Resource
	private LangUserMapper langUserMapper;//oracle

	@Resource
	private UserMapper userMapper;//mysql

	private Logger logger= LogManager.getLogger(this.getClass());


	@Override
	@Transactional
	public String test() {

		LangUser langUser = langUserMapper.selectByPrimaryKey(-1);
		LangUser langUser1 = langUserMapper.selectByPrimaryKey(-1);
		LangUser langUser2 = langUserMapper.selectByPrimaryKey(-1);

		return null;
	}

	@Override
	public String test2() {
		LangUser langUser = langUserMapper.selectByPrimaryKey(1);
		langUser.setName("hahah");
		LangUser langUser1 = langUserMapper.selectByPrimaryKey(1);
		LangUser langUser2 = langUserMapper.selectByPrimaryKey(1);
		return null;
	}

}
