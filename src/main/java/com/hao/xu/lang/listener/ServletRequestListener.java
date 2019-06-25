package com.hao.xu.lang.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 14:48 2019/3/3
 */
public class ServletRequestListener implements javax.servlet.ServletRequestListener {


	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
		System.out.println("requst 销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
		System.out.println("requst 创建");
	}
}
