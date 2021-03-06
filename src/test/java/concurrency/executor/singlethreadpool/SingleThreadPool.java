package concurrency.executor.singlethreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
	
	public static void main(String[] args) {
		ExecutorService executor=Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			executor.execute(new LiftOff());
		}
		
		executor.shutdown();//防止新任务提交到executor中
		//!executor.execute(new LiftOff());
	}

}
