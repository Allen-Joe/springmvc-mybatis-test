package concurrency.util.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeTest {
	
	private static final Exchanger<String> exgr=new Exchanger<String>();
	
	private static final ExecutorService executor=Executors.newFixedThreadPool(2);
	
	public static void main(String[] args) {
		
		executor.execute(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				String A=Thread.currentThread().getName()+"'s datas";
				try {
					exgr.exchange(A);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
        executor.execute(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					String B=Thread.currentThread().getName()+"'s datas";
					String A=exgr.exchange(B);
					System.out.println(A);
					System.out.println(B);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        
        executor.shutdown();
	}

}
