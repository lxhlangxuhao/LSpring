package com.hao.xu.lang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:57 2019/3/2
 */
public class InterceptorThree implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

		System.out.println("Interceptor_preHandle_Three");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

		System.out.println("Interceptor_postHandle_Three");
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

		System.out.println("Interceptor_afterCompletion_Three");
	}
}
