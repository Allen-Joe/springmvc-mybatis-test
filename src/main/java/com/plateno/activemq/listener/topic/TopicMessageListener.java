package com.plateno.activemq.listener.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicMessageListener implements MessageListener{

	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage tm=(TextMessage) message;
		
		try {
			System.out.println("TopicMessageListener监听到了文本消息：\t"
			        + tm.getText());
//			System.out.println("QueueMessageListener监听到了文本消息：\t"
//	        + JsonUtil.jsonToBean(tm.getText(), OrderInfo.class).toString());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
