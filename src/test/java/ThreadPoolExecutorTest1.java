import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolExecutorTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * newCachedThreadPool
		 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
		 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
		 */
		ExecutorService cachedThreadPool=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			final int index=i;
			try {
				Thread.sleep(index*1000);
			} catch (InterruptedException e) {
				 //TODO: handle exception
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {				
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(index+"("+Thread.currentThread().getName()+")");	
				}
			});
		}

	}

}
