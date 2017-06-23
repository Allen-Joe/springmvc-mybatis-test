package blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
	private BlockingQueue<String> queue;
	private volatile boolean isRuning=true;
	private static final int DEFAULT_RANGR_FOR_SLEEP=1000;
	/**
	 * AtomicInteger，一个提供原子操作的Integer的类。
	 * 在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，不可避免的会用到synchronized关键字。
	 * 而AtomicInteger则通过一种线程安全的加减操作接口。
	 */
	private static AtomicInteger count=new AtomicInteger();

	public Producer(BlockingQueue<String> queue) {
		// TODO Auto-generated constructor stub
		this.queue=queue;
	}

	public void run() {
		// TODO Auto-generated method stub
		String data=null;
		Random random=new Random();
		System.out.println("启动生产者线程("+Thread.currentThread().getName()+")啦！！");
		try {
			while(isRuning){
				System.out.println("("+Thread.currentThread().getName()+")正在生产数据...");
				Thread.sleep(random.nextInt(DEFAULT_RANGR_FOR_SLEEP));
				
				data="data:"+count.incrementAndGet();
				System.out.println("("+Thread.currentThread().getName()+")将数据："+data+"放入队列中...");
				if(!this.queue.offer(data, 2, TimeUnit.SECONDS)){
					System.out.println("("+Thread.currentThread().getName()+")放入数据："+data+"失败");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}finally{
			System.out.println("退出生产者线程("+Thread.currentThread().getName()+")啦！！");
		}
		
	}
	
	public void stop(){
		this.isRuning=false;
	}

}
