package concurrency.util.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
	
	private static CountDownLatch c=new CountDownLatch(2);
	
	public static void main(String[] args) throws InterruptedException {
		c=new CountDownLatch(5);//CountDownLatch不可能被重新初始化或者修改内部的计数器，例如：此处即使重新初始化或者计数器给成5也不会对下面程序影响
		
		new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(1);
				c.countDown();
				System.out.println(2);
				c.countDown();
			}
		}).start();
		c.await(1, TimeUnit.SECONDS);
		System.out.println(3);
	}

}
