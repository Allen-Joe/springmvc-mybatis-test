package concurrency.lock.aqs;

import java.util.concurrent.TimeUnit;


public class TwinsLockTest {
	
	private static final TwinsLock lock=new TwinsLock();
	
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 10; i++) {
			Worker worker=new Worker();
			worker.setDaemon(true);
			worker.start();
		}
		
		for (int i = 0; i < 10; i++) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println();
		}
		
	}
	
	private static class Worker extends Thread{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			lock.lock();
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	}

}
