package com.hao.xu.lang.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 14:58 2019/3/3
 */
public class ContextListener implements ServletContextListener {


	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("容器创建");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("容器销毁");
	}
}
