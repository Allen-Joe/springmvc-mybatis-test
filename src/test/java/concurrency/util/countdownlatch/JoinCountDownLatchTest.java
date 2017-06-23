package concurrency.util.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class JoinCountDownLatchTest {
	
	private static CountDownLatch c=new CountDownLatch(2);
	
	public static void main(String[] args) {
		Thread thread1=new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				c.countDown();
				System.out.println("thread1 finish");
			}
		});
		Thread thread2=new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				c.countDown();
				System.out.println("thread2 finish");
			}
		});
		try {
			thread1.start();
			thread2.start();
			c.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		thread1.start();
//		thread2.start();
//		try {
//			thread1.join();
//			thread2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("main thread wait all thread finished~~");
		System.out.println("all thread finished~~");
		
	}

}
