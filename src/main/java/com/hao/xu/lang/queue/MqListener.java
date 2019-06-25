package com.hao.xu.lang.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Author: Xuhao
 * @Description: 配置文件方式监听 queue模式
 * @Date: Created in 13:01 2019/3/10
 */
public class MqListener implements MessageListener {


	@Override
	public void onMessage(Message message) {

		TextMessage requestInfo = (TextMessage) message;
		try {
			System.out.println("正在监听");
			System.out.println("监听到的消息是:" + requestInfo.getText());
		} catch (JMSException e) {
			System.out.println(e.getErrorCode());
		}
	}


}
