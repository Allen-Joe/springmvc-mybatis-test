package concurrency.util.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
	
	private static CyclicBarrier cyclicBarrider=new CyclicBarrier(2);//同步屏障
	
	private static AtomicInteger count=new AtomicInteger(0);
	
	public static void main(String[] args){
		Thread evenThread=new Thread(new EvenPrintTask(),"evenThread");
		Thread oddThread=new Thread(new OddPrintTask(),"oddThread");
		oddThread.start();
		evenThread.start();
	}
	
	static class OddPrintTask implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			while(count.get()<20){
				try {
					cyclicBarrider.await();
					System.out.println(Thread.currentThread().getName()+": "+count.incrementAndGet());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		
	}
	
	static class EvenPrintTask implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			while(count.get()<20){
				try {
					cyclicBarrider.await();
					TimeUnit.SECONDS.sleep(1);//延迟1秒，让奇数线程先打印
					System.out.println(Thread.currentThread().getName()+": "+count.incrementAndGet());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		
	}

}
