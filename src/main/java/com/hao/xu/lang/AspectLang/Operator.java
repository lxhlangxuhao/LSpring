package com.hao.xu.lang.AspectLang;

import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author: Xuhao
 * @Description: aop 日志
 * @Date: Created in 21:54 2019/6/4
 */
@Component
@Aspect
public class Operator {

	private static final Logger logger = LoggerFactory.getLogger(Operator.class);


	@Pointcut("execution(* com.hao.xu.lang.service.*.*(..))")
	public void pointCutService() {}

	@Before("pointCutService()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("doBefore:在方法被调用之前调用通知");
	}

	@After("pointCutService()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("doAfter:在方法完成之后调用通知，无论方法执行是否成功");
	}

	@AfterReturning(pointcut = "pointCutService()",returning = "returning")
	public void doAfterReturning(JoinPoint joinPoint,Object returning) {
		System.out.println("AfterReturning:在方法成功执行之后调用通知");
	}

	@AfterThrowing(pointcut = "pointCutService()",throwing = "error")
	public void afterThrowingLog(JoinPoint joinPoint,Throwable error) {
		System.out.println("afterThrowing:在方法抛出异常后调用通知");
	}

	@Around("pointCutService()")
	public Object aroundLog(ProceedingJoinPoint joinpoint) {

		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = sra.getRequest();

		logger.info("请求开始===地址:" + request.getRequestURL().toString());
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		Object[] args = joinpoint.getArgs();
		try {
			//获取请求参数集合并进行遍历拼接
			if (args.length > 0) {
				if ("POST".equals(method)) {
					for (Object arg : args) {
						logger.info("请求开始===参数:" + new Gson().toJson(arg));
					}
				} else if ("GET".equals(method)) {
					//restful 风格无需打印参数
					logger.info("请求开始===参数:" + queryString);
				}
			}
		}catch (Exception e){
			logger.error("对象转换参数错误",e);
		}
		Object result = null;
		try {
			result = joinpoint.proceed();
			logger.info("请求结束===返回值:" + new Gson().toJson(result));
		}catch (Exception e){
			logger.error("对象转换返回值错误",e);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return result;
	}


}
