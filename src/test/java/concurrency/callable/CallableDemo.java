package concurrency.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	
	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		
//		Future<String> result=executor.submit(new TaskWithResult(1));
//		
//		try {
//			System.out.println(result.get());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			executor.shutdown();//不管是否发生异常都会被执行
//		}
		
		List<Future<String>> futures=new ArrayList<Future<String>>();
		
		for (int i = 0; i < 10; i++) {
			futures.add((executor.submit(new TaskWithResult(i))));
		}
		
		try {
			for (Future<String> future : futures) {
				System.out.println(future.get());			
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			executor.shutdown();
		}
	}

}
