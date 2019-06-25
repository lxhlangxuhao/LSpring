package com.hao.xu.lang.spring.aop.proxy.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:41 2019/6/6
 */
public class CglibProxy implements MethodInterceptor {

	private Object proxyObject;

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("CGlib动态代理，监听开始！");
		Object result = method.invoke(proxyObject, objects);
		System.out.println("CGlib动态代理，监听结束！");
		return result;
	}


	private Object getCglibProxy(Object objectTarget){
		this.proxyObject = objectTarget;
		Enhancer enhancer = new Enhancer();
		//设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
		enhancer.setSuperclass(objectTarget.getClass());
		enhancer.setCallback(this);// 设置回调

		return enhancer.create();//创建并返回代理对象
	}


	public static void main(String[] args) {
		CglibProxy cglib = new CglibProxy();//实例化CglibProxy对象
		AgentServiceImpl agentService =  (AgentServiceImpl) cglib.getCglibProxy(new AgentServiceImpl());//获取代理对象
		agentService.addAgent("小狗");
	}

}
