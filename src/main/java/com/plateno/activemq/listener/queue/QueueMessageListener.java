package com.plateno.activemq.listener.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.plateno.activemq.model.OrderInfo;
import com.plateno.common.util.JsonUtil;

/**
 * 
 * @描述：监听的类，必须实现“MessageListerner”接口
 * @创建人：Chenliqiao
 * @创建时间：2017年6月23日上午11:12:42
 * @version v1.0
 */
public class QueueMessageListener implements MessageListener{

	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage tm=(TextMessage) message;
		
		try {
//			System.out.println("QueueMessageListener监听到了文本消息：\t"
//			        + tm.getText());
			System.out.println("QueueMessageListener监听到了文本消息：\t"
	        + JsonUtil.jsonToBean(tm.getText(), OrderInfo.class).toString());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
