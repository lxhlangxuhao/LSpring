package com.hao.xu.lang.controller;

import com.hao.xu.lang.annotation.ExcludeInterceptor;
import javax.jms.TextMessage;
import javax.servlet.http.HttpSession;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:14 2019/3/2
 */
@RestController
public class HelloController {


//	@Resource
	private JmsTemplate jmsTemplate;


	@RequestMapping(value = "/hi")
	public String hello(HttpSession session) {

		System.out.println("hi");
		return "hi";
	}

	@RequestMapping(value = "/hello")
	@ExcludeInterceptor
	public String hello2(HttpSession session) {

		System.out.println("hello");
		return "hello";
	}



	@RequestMapping(value = "/sendMess")
	@ExcludeInterceptor
	public void sendMess(HttpSession session) {

		jmsTemplate.send(session1 -> {
			TextMessage msg = session1.createTextMessage();
			msg.setText(" hello activemq !");
			return msg;
		});
	}


}
