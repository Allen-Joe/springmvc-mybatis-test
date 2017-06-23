import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.plateno.activemq.model.OrderInfo;
import com.plateno.activemq.service.ComsumerService;
import com.plateno.activemq.service.ProducerService;
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
	
	

}
