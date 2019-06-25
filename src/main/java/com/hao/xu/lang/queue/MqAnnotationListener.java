package com.hao.xu.lang.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:54 2019/3/10
 */
//@Component
//@EnableJms
public class MqAnnotationListener {

//	@JmsListener(containerFactory = "jmsListenerContainerFactory", destination = "hello")
	public void myListener(Message message) {

		TextMessage text = (TextMessage) message;
		try {
			System.out.println("注解的方式监听到mq消息");
			System.out.println(text.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
