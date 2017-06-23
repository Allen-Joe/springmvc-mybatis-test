package concurrency.join;

import java.util.concurrent.TimeUnit;

public class Join {
	
	static class Domino implements Runnable{
		
		private Thread thread;
		
		public Domino(Thread thread){
			this.thread=thread;
		}
		
		public void run() {
			// TODO Auto-generated method stub
			//System.out.println(Thread.currentThread().getName()+" enter... and previous is "+thread.getName());
			try {
				long st=System.currentTimeMillis();
				//System.out.println(Thread.currentThread().getName()+" terminate start");
				//thread.join();
				synchronized (thread) {
					while(thread.isAlive()){
						thread.wait();
					}
				}
				System.out.println(Thread.currentThread().getName()+" terminate end , used time:"+(System.currentTimeMillis()-st)/1000+"s");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(Thread.currentThread().getName()+" terminate");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Thread previous=Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			//System.out.println("previous: "+previous.getName());
			Thread thread=new Thread(new Domino(previous),"Thread"+i);
			thread.start();
			previous=thread;
		}
		TimeUnit.SECONDS.sleep(5);
		System.out.println(Thread.currentThread().getName()+" terminate aa");
	}

}
