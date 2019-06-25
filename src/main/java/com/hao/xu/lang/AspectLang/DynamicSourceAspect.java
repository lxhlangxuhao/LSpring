package com.hao.xu.lang.AspectLang;

import com.hao.xu.lang.annotation.DataSource;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 1:01 2019/6/16
 */
public class DynamicSourceAspect {

	/**
	 * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
	 *
	 * @param point
	 * @throws Exception
	 */
	public void intercept(JoinPoint point) throws Exception {
		//spring 动态代理的类 也可以看成*Mapper.java(目标类)的代理类 class com.sun.proxy.$Proxy35
		Class<?> target = point.getTarget().getClass();
		//目标类的接口
		Class<?>[] interfaces = target.getInterfaces();
		MethodSignature signature = (MethodSignature) point.getSignature();
		// 默认使用目标类的注解，如果没有则使用其实现接口的注解
		for (Class<?> clazz : interfaces) {
			resolveDataSource(clazz, signature.getMethod());
		}
	}

	public void returning(JoinPoint jp) {
//		DynamicDataSourceHolder.clearDataSource();
		System.out.println("数据源已移除！");
	}

	/**
	 * 提取目标对象方法注解和类型注解中的数据源标识
	 *
	 * @param clazz
	 * @param method
	 */
	private void resolveDataSource(Class<?> clazz, Method method) {
		try {
			//默认数据源为DataSource.ORACLE数据源
			DynamicDataSourceHolder.setDataSource(DataSource.ORACLE);
			Class<?>[] types = method.getParameterTypes();
			Method m = clazz.getMethod(method.getName(), types);
			// Mapper接口上的@DataSource注解,设置此接口下方法的全部默认源
			if (clazz.isAnnotationPresent(DataSource.class)) {
				DataSource source = clazz.getAnnotation(DataSource.class);
				DynamicDataSourceHolder.setDataSource(source.value());
			}
			// 方法注解可以覆盖接口注解
			if  (m != null && m.isAnnotationPresent(DataSource.class)) {
				DataSource source = m.getAnnotation(DataSource.class);
				DynamicDataSourceHolder.setDataSource(source.value());
			}
		} catch (Exception e) {
			System.out.println(clazz + ":" + e.getMessage());
		}
	}

}