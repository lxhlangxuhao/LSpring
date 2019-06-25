package com.hao.xu.lang.spring.aop.proxy.cglib;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 22:28 2019/6/6
 */
public class AgentServiceImpl {

	public String addAgent(String name) {
		System.out.println("新增代理人：" + name);
		return name;
	}
}
