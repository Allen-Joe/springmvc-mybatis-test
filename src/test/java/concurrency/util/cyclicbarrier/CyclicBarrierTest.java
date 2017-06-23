package concurrency.util.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
	//private static CyclicBarrier c=new CyclicBarrier(2);//同步屏障，参数2表示屏障拦截的线程数量
	private static CyclicBarrier c=new CyclicBarrier(2, new OtherTask());//当线程达到屏障时，优先执行barrierAction，即OtherTask
	
	public static void main(String[] args){
		
		//c=new CyclicBarrier(3);//同步屏障可以重新初始化，并且生效
		//c.reset();//重置内存屏障的计数器
		new Thread(new Runnable() {			
			public void run() {
				// TODO Auto-generated method stub
				try {
					c.await();//线程调用await()告诉CyclicBarrier（内存屏障）我已经到达屏障了，然后阻塞自己
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				System.out.println(Thread.currentThread().getName()+" is finished");
			}
		},"thread1").start();
		
		try {
			c.await();//最后一个线程调用await()告诉CyclicBarrier（内存屏障）我已经到达屏障了，然后屏障打开，所有被拦截的线程继续运行
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(Thread.currentThread().getName()+" is finished");
	}
	
	static class OtherTask implements Runnable{//barrierAction

		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+" is barrierAction and finished~");
		}
		
	}

}
