import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ThreadPoolExecutorTest3 {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		/**
//		 * newScheduledThreadPool
//		 * 创建一个定长线程池，支持定时及周期性任务执行。延迟执行示例代码如下：
//		 * 表示延迟3秒执行。
//		 */
//	     ScheduledExecutorService scheduleThreadPool=Executors.newScheduledThreadPool(5);
//	     scheduleThreadPool.schedule(new Runnable() {
//			
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("delay 3 seconds");				
//			}
//		}, 3, TimeUnit.SECONDS);
//
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * newScheduledThreadPool
		 * 创建一个定长线程池，支持定时及周期性任务执行。延迟执行示例代码如下：
		 * 表示延迟1秒每3秒执行一次。
		 */
	     ScheduledExecutorService scheduleThreadPool=Executors.newScheduledThreadPool(5);
	     scheduleThreadPool.scheduleAtFixedRate(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("delay 1 seconds, and excute every 3 seconds");
				
			}
		}, 1, 3, TimeUnit.SECONDS);

	}

}
