package blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
	
	private BlockingQueue<String> queue;
	private static final int DEFAULT_RANGE_FOR_SLEEP=1000;

	public Consumer(BlockingQueue<String> queue) {
		// TODO Auto-generated constructor stub
		this.queue=queue;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("启动消费者线程啦！！");
		Random random=new Random();
		boolean isRunning=true;
		try {
			while(isRunning){
				System.out.println("从队列中获取数据...");
				String data=this.queue.poll(2, TimeUnit.SECONDS);
				if(data!=null){
					System.out.println("拿到数据："+data);
					System.out.println("正在消费数据...");
					Thread.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
				}else{
					// 超过2s还没数据，认为所有生产线程都已经退出，自动退出消费线程。
					isRunning=false;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}finally{
			System.out.println("退出消费者线程");
		}
	}

}
