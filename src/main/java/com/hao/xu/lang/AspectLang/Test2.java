package com.hao.xu.lang.AspectLang;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:52 2019/6/14
 */

@Component
@Aspect
@Order(1)
public class Test2 {

	@Pointcut("execution(* com.hao.xu.lang.mapper.*.*.*(..))")
	public void tewt() {

	}

	@Before(value = "tewt()")
	public void ss() {
		System.out.println(11111111);
	}


}
