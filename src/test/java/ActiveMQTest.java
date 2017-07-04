import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.plateno.activemq.model.OrderInfo;
import com.plateno.activemq.service.queue.ComsumerService;
import com.plateno.activemq.service.queue.ProducerService;
import com.plateno.activemq.service.topic.PubService;
import com.plateno.activemq.service.topic.SubService;
import com.plateno.common.util.JsonUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class ActiveMQTest {
	
	@Resource(name="demoQueueDestination")
	private Destination demoQueueDestination;
	
	//队列消息生产者
	@Resource(name="producerService")
	private ProducerService producerService;
	
	//队列消息消费者
	@Resource(name="comsumerService")
	private ComsumerService comsumerService;
	
	@Test
	public void producerSendMsg(){
//		String msg="消息1"+System.currentTimeMillis();
//		producerService.sendMessage(msg);//向默认队列发送消息
//		
//		String msg1="消息2"+System.currentTimeMillis();
//		producerService.sendMessage(demoQueueDestination, msg1);//向指定队列发送消息
		OrderInfo orderInfo=new OrderInfo("0234",new BigDecimal(100.15), new Date(), "allen_joe", 1);
		producerService.sendMessage(demoQueueDestination, JsonUtil.beanToJson(orderInfo));
		
	}
	
	@Test
	public void comsumerReceiveMsg(){
		try {
			String msg=comsumerService.receiveMessage(demoQueueDestination).getText();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ===================发布订阅模式====================
	 */
	@Resource(name="demoTopicDestination")
	private Destination demoTopicDestination;
	
	@Resource(name="pubService")
	private PubService pubService;
	
	@Resource(name="subService")
	private SubService subService;
	
	/**
	 * 
	 * @throws JMSException 
	 * @描述:发布消息
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年6月27日下午12:07:11
	 */
	@Test
	public void pubMessage(){
		pubService.pubMessage(demoTopicDestination, "发布模式-->消息1~");
	}
	
	/**
	 * 
	 * @描述:接受订阅的消息
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年6月27日下午12:10:02
	 */
	@Test
	public void subMessage(){
		subService.receiveMessage(demoTopicDestination);
	}

}
