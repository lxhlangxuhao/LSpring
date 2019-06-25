package com.hao.xu.lang.spring.aop.proxy.jdk;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:18 2019/6/6
 */
public interface UserService {

	//新增用户抽象方法
	void addUser(String userName,String password);
	//删除用户抽象方法
	String delUser(String userName);
}
