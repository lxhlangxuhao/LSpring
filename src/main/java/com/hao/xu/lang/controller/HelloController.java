package com.hao.xu.lang.controller;

import com.hao.xu.lang.annotation.ExcludeInterceptor;
import com.hao.xu.lang.entity.User;
import javax.jms.TextMessage;
import javax.servlet.http.HttpSession;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:14 2019/3/2
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {


	//	@Resource
	private JmsTemplate jmsTemplate;


	@RequestMapping(value = "/testGet",method = RequestMethod.GET)
	@ResponseBody
	public String testGet(String name, String age) {

		return name+":"+age;
	}

	@RequestMapping(value = "/testPost",method = RequestMethod.POST)
	@ResponseBody
	public String testPost(String name, String age) {

		return "testPost";
	}


	@RequestMapping(value = "/testPostEntity",method = RequestMethod.POST)
	@ResponseBody
	public String testPostEntity(User user) {

		return user.toString();
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
