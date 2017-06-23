package blockingqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProductConsumeTest {
	private static final int QUEUE_SIZE=10;
	/**
	 * 阻塞队列实现
	 */
	//private static ArrayBlockingQueue<String> contains=new ArrayBlockingQueue<String>(QUEUE_SIZE);
	
	private static LinkedList<String> contains=new LinkedList<String>();
	private static final ExecutorService threadPool=Executors.newFixedThreadPool(2);
	
	public static void main(String[] args) throws Exception {

		Producter producter=new Producter(contains);
		Consumer consumer1=new Consumer(contains);
		Consumer consumer2=new Consumer(contains);
		Consumer consumer3=new Consumer(contains);
		threadPool.execute(producter);
		TimeUnit.SECONDS.sleep(3);
		threadPool.execute(consumer1);
		threadPool.execute(consumer2);
		threadPool.execute(consumer3);
		
		threadPool.shutdown();
		
	}
	
	static class Producter implements Runnable{
		
//		private ArrayBlockingQueue<String> queue;
//		
//		public Producter(ArrayBlockingQueue<String> queue){			
//			this.queue=queue;
//		}
		
		private LinkedList<String> queue;
		
		public Producter(LinkedList<String> queue){			
			this.queue=queue;
		}
		

		public void run() {
			// TODO Auto-generated method stub
			synchronized (contains) {
				while(true){
					if(this.queue.size()==QUEUE_SIZE){
						System.out.println("生产线程阻塞");
						try {
								contains.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					product();
					contains.notifyAll();
				}
			}
		}
		
		private void product(){	
//			try {
				//this.queue.put("production");
				this.queue.add("production");
				System.out.println(Thread.currentThread().getName()+"[生产线程]生产了production");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}
	
	static class Consumer implements Runnable{
//		private ArrayBlockingQueue<String> queue;
//		
//		public Consumer(ArrayBlockingQueue<String> queue){
//			this.queue=queue;
//		}
		
		private LinkedList<String> queue;
		public Consumer(LinkedList<String> queue){
		   this.queue=queue;
	    }

		public void run() {
			// TODO Auto-generated method stub
			synchronized (contains) {
				while(true){
					if(this.queue.isEmpty()){
						System.out.println("消费线程阻塞");
						try {
								contains.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					consume();
					contains.notifyAll();
				}
		   }
		}
		
		private void consume(){
//			try {
//				System.out.println(Thread.currentThread().getName()+"[消费线程]消费了"+this.queue.take());
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+"[消费线程]消费了"+this.queue.pop());
		}
		
	}

}
