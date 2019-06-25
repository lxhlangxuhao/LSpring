package com.hao.xu.lang.mapper.oracle;

import com.hao.xu.lang.AspectLang.DynamicDataSourceHolder;
import com.hao.xu.lang.annotation.DataSource;
import com.hao.xu.lang.entity.LangUser;
import com.hao.xu.lang.mapper.mysql.UserMapper;
import core.BasejunitTest;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 22:22 2019/6/15
 */
public class LangUserMapperTest extends BasejunitTest {

	private Logger logger= LogManager.getLogger(this.getClass());


	@Resource
	private LangUserMapper langUserMapper;

	@Resource
	private UserMapper userMapper;

	@Test
	@Transactional
	public void test() {
		LangUser langUser = langUserMapper.selectByPrimaryKey(-1);
		logger.info("姓名："+langUser.getName());
		langUser.setName("喜洋洋");

		LangUser langUser3 = new LangUser();
		langUser3.setName("红太狼");
		langUser3.setAge(5);
		langUser3.setScore("90");
		langUserMapper.insert(langUser3);

		LangUser langUser1 = langUserMapper.selectByPrimaryKey(-1);
		logger.info("姓名："+langUser1.getName());
		LangUser langUser2 = langUserMapper.selectByPrimaryKey(-1);
		logger.info("姓名："+langUser2.getName());

	}

}