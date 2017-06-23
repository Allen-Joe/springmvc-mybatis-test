package concurrency.threadlocal;

public class CounterTask implements Runnable{
	
	private ThreadLocalDemo threadLocalDemo;
	
	public CounterTask(ThreadLocalDemo threadLocalDemo){
		this.threadLocalDemo=threadLocalDemo;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			threadLocalDemo.count();
			System.out.println(Thread.currentThread()+":"+threadLocalDemo.getSum());
		}
		System.out.println(Thread.currentThread()+" total->:"+threadLocalDemo.getSum());
	}

}
