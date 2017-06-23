package concurrency.wait;

import java.util.concurrent.TimeUnit;

public class WaitNotify {
	
	static boolean flag=true;
	static Object lock=new Object();
	
	static class WaitThread implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			synchronized (lock) {
				System.out.println("monitor enter...");
				while(flag){
					try {
						System.out.println(Thread.currentThread()+" flag true. wait "+System.currentTimeMillis());
						lock.wait();//此处线程释放锁，进入等待队列，状态为WAITING
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(Thread.currentThread()+" flag false. wait "+System.currentTimeMillis());
				System.out.println("monitor exit...");
			}
		}
		
	}
	
	static class NotifyThread implements Runnable{

		public void run() {
			// TODO Auto-generated method stub			
			synchronized (lock) {
				System.out.println(" obtain lock...");
				System.out.println(Thread.currentThread()+" hold lock. notify @"+System.currentTimeMillis());
				flag=false;
				lock.notifyAll();//将等待队列中状态为WAITING的线程，放入状态为BLOCK的同步队列中是线程重新参与锁竞争
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" release lock...");
			}			
			
			synchronized (lock) {
				System.out.println(" obtain lock again...");
				System.out.println(Thread.currentThread()+" hold lock again. notify @"+System.currentTimeMillis());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" release lock again...");
			}			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		new Thread(new WaitThread(),"waitThread").start();
		TimeUnit.SECONDS.sleep(1);
		new Thread(new NotifyThread(),"notifyThread").start();
	}

}
