package com.hao.xu.lang.interceptor;

import com.hao.xu.lang.annotation.ExcludeInterceptor;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:57 2019/3/2
 */
public class InterceptorOne implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

		//获取到目标方法对象
		HandlerMethod method = (HandlerMethod) o;
		//取到方法上的注解
		ExcludeInterceptor methodAnnotation = method.getMethodAnnotation(ExcludeInterceptor.class);
		if (Objects.isNull(methodAnnotation)) {
			//无此注解的一律拦截
			httpServletResponse.sendRedirect("http://localhost:8080/html/interceptor.html");
			return false;
		}

		System.out.println("Interceptor_preHandle_One");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

		System.out.println("Interceptor_postHandle_One");
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

		System.out.println("Interceptor_afterCompletion_One");
	}
}
