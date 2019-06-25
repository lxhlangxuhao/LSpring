package com.hao.xu.lang.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:39 2019/3/2
 */
public class FilterOne implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("FilterOne_init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("FilterOne_doFilter_start");
//		HttpServletRequest request1 = (HttpServletRequest) request;
//		String requestURI = request1.getRequestURI();
//		StringBuffer requestURL = request1.getRequestURL();
//		String servletPath = request1.getServletPath();


		chain.doFilter(request, response);
		System.out.println("FilterOner_doFilter_end");
	}

	@Override
	public void destroy() {

		System.out.println("FilterOne_destroy");
	}
}
