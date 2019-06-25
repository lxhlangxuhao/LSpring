package com.hao.xu.lang.listener;

import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:13 2019/3/3
 */
public class OnlineListener implements HttpSessionListener {


	private int onlineNum = 0;

	@Override
	public void sessionCreated(HttpSessionEvent event) {

		ServletContext servletContext = event.getSession().getServletContext();
		Integer onlineNum = (Integer)servletContext.getAttribute("onlineNum");
		if (Objects.isNull(onlineNum)) {
			onlineNum = 1;
		} else {
			onlineNum++;
		}
		servletContext.setAttribute("onlineNum", onlineNum);

		this.onlineNum = this.onlineNum + 1;
		System.out.println("当前在线人数："+ this.onlineNum);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {

		ServletContext servletContext = event.getSession().getServletContext();
		Integer onlineNum = (Integer)servletContext.getAttribute("onlineNum");
		onlineNum--;

		servletContext.setAttribute("onlineNum", onlineNum);//再把num装到ServletContext域中,方便页面中得到num信息

	}
}
