package concurrency.sleep;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SleepDemo {
	
	public static void main(String[] args) {
		
		Thread thread=new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				Random random=new Random();
				int sleepTime=0;
				try {
					sleepTime=random.nextInt(10);
					TimeUnit.MILLISECONDS.sleep(sleepTime*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					System.out.println("sleep time:"+sleepTime+"s");
				}
			}
		});
		thread.start();
	}

}
