package com.plateno.activemq.service.topic;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubService {

	@Resource(name="topicJmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public TextMessage receiveMessage(Destination destination){
		TextMessage textMessage=(TextMessage) jmsTemplate.receive(destination);
		try {
			System.out.println("从订阅的队列"+destination.toString()+"收到了消息：\t"+textMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return textMessage;
	}
}
