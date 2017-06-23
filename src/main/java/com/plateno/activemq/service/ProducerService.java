package com.plateno.activemq.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * 
 * @描述：消息生产者
 * @创建人：Chenliqiao
 * @创建时间：2017年6月22日下午4:44:09
 * @version v1.0
 */
@Service
public class ProducerService {
	
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * 
	 * @描述:向指定队列发送消息
	 * @param destination
	 * @param msg
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年6月22日下午4:43:57
	 */
	public void sendMessage(Destination destination,final String msg){
		System.out.println("向队列"+destination.toString()+"发送了消息--------"+msg);
		jmsTemplate.send(new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(msg);
			}
		});
	}
	
	/**
	 * 
	 * @描述:向默认队列发送消息
	 * @param msg
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年6月22日下午4:49:30
	 */
	public void sendMessage(final String msg){
		String destination=jmsTemplate.getDefaultDestination().toString();
		System.out.println("向默认队列"+destination+"发送了消息---------"+msg);
		jmsTemplate.send(new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(msg);
			}
		});
		
	}

}
