package com.plateno.activemq.service.topic;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class PubService {
	
	@Resource(name="topicJmsTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * 
	 * @描述:向指定队列发布消息
	 * @param destination
	 * @param message
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年6月27日上午11:42:31
	 */
	public void pubMessage(Destination destination,final String message){
		System.out.println("向队列"+destination.toString()+"发布了消息："+message);
		jmsTemplate.send(new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(message);
			}
		});
	}

}
