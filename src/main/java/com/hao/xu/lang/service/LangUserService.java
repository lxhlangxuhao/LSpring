package com.hao.xu.lang.service;

import com.hao.xu.lang.entity.LangUser;
import com.hao.xu.lang.entity.User;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:49 2019/6/9
 */
public interface LangUserService {

	LangUser selectByPrimaryKey(int id);



	void insertUser(User user);
}
