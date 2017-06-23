package concurrency.util.cyclicbarrier;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BankWaterService implements Runnable{
	
	private CyclicBarrier c=new CyclicBarrier(4, this);
	
	private Executor executor=Executors.newFixedThreadPool(4);
	
	//private ConcurrentHashMap<String, Integer>  sheetBankWaterCount=new ConcurrentHashMap<String, Integer>();
	private volatile HashMap<String, Integer>  sheetBankWaterCount=new HashMap<String, Integer>();
	
	private void count(){
		for (int i = 0; i < 4; i++) {
			executor.execute(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					//计算银数数据
					sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
					//计算完成后，插入一个内存屏障
					try {
						c.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			});
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		int result=0;
		for (int value : sheetBankWaterCount.values()) {
			result+=value;
		}
		System.out.println(result);
		System.out.println(sheetBankWaterCount.keySet());
	}
	
	public static void main(String[] args) {
		BankWaterService service=new BankWaterService();
		service.count();
	}

}
