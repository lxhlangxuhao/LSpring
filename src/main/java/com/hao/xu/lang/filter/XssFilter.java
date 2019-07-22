package com.hao.xu.lang.filter;

/**
 * @Author: Xuhao
 * @Description: Xss跨脚本攻击过滤器
 * @Date: Created in 22:40 2019/7/22
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class XssFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {

		chain.doFilter(new XssHttpServletRequestWraper((HttpServletRequest)request), response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

