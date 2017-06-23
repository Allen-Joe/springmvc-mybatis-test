package blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		 // 声明一个容量为10的缓存队列
		BlockingQueue<String> queue=new LinkedBlockingDeque<String>(10);
		
		Producer producer1=new Producer(queue);
		Producer producer2=new Producer(queue);
		Producer producer3=new Producer(queue);
		
		Consumer consumer=new Consumer(queue);
		
		//借助Executors线程池
		ExecutorService threadPool=Executors.newCachedThreadPool();
		// 启动线程
		threadPool.execute(producer1);
		threadPool.execute(producer2);
		threadPool.execute(producer3);
		threadPool.execute(consumer);
		
		//执行10s
		Thread.sleep(10*1000);
		producer1.stop();
		producer2.stop();
		producer3.stop();
		
		Thread.sleep(2000);
		//退出线程池
		threadPool.shutdown();
		
	}

}
