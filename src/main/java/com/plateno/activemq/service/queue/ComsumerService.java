package com.plateno.activemq.service.queue;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @描述：消费者ConsumerService
 * @创建人：Chenliqiao
 * @创建时间：2017年6月22日下午5:00:16
 * @version v1.0
 */
@Service
public class ComsumerService {
	
	@Resource(name="queueJmsTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * 
	 * @描述:接收消息
	 * @param destination
	 * @return
	 * @返回类型 TextMessage
	 * @创建人 Chenliqiao
	 * @创建时间 2017年6月22日下午4:59:46
	 */
	public TextMessage receiveMessage(Destination destination){
		TextMessage tm=(TextMessage) jmsTemplate.receive(destination);
		
		try {
			System.out.println("从队列"+destination.toString()+"收到了消息：\t"+tm.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tm;
	}

}
