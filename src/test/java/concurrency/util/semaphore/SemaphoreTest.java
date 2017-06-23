package concurrency.util.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	private static final int THREAD_COUNT=30;
	private static final int SEMAPHORE_COUNT=10;
	private static ExecutorService executor=Executors.newFixedThreadPool(THREAD_COUNT);
	private static Semaphore s=new Semaphore(SEMAPHORE_COUNT,true);
	
	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			executor.execute(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					try {
						s.acquire();//获取许可证
						System.out.println(Thread.currentThread().getName()+" save data "+System.currentTimeMillis()+" remain permit count:"+s.availablePermits());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						s.release();////释放许可证
					}
				} 
			});
		}
		executor.shutdown();
	}

}
