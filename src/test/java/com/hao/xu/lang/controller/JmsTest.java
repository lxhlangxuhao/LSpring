package com.hao.xu.lang.controller;

import core.BaseJunitTest;
import java.util.Date;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 19:44 2019/3/9
 */

public class JmsTest extends BaseJunitTest {

//	@Resource
	private JmsTemplate jmsTemplate;

	@Test
	public void objectMessage() {

		jmsTemplate.send("keyOne", session -> {
			ObjectMessage objectMessage = session.createObjectMessage();
			objectMessage.setObject(new Date());
			return objectMessage;
		});
	}

	@Test
	public void mapMessage() {

		jmsTemplate.send("keyTwo", session -> {
			MapMessage mapMessage = session.createMapMessage();
			mapMessage.setBoolean("key1", true);
			mapMessage.setDouble("key2", 2.3);
			mapMessage.setBytes("key3", new byte[]{1,2,3});
			return mapMessage;
		});
	}


	@Test
	public void mapMessage2() {

		jmsTemplate.convertAndSend("hello", "hello mqProduct！");
		jmsTemplate.convertAndSend("hi", "hi mqProduct！");


	}




}