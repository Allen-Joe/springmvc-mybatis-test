package concurrency.threadlocal;

public class ThreadLocalDemo {
	
	private static final ThreadLocal<Integer> COUNTER_THREADLOCAL=new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	public void count(){
		COUNTER_THREADLOCAL.set(COUNTER_THREADLOCAL.get()+1);
	}
	
	public int getSum(){
		return COUNTER_THREADLOCAL.get();
	}
	
	public static void main(String[] args) {
		ThreadLocalDemo threadLocalDemo=new ThreadLocalDemo();
		
		new Thread(new CounterTask(threadLocalDemo),"thread one ").start();
		new Thread(new CounterTask(threadLocalDemo),"thread two ").start();
		new Thread(new CounterTask(threadLocalDemo),"thread three ").start();
	}

}
