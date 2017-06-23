package concurrency.threadlocal;

import java.util.concurrent.TimeUnit;

public class Profiler {
	
	private static final ThreadLocal<Long> TIME_THREADLOCAL=new ThreadLocal<Long>(){//匿名内部类
		@Override
		protected Long initialValue() {
			// TODO Auto-generated method stub
			return System.currentTimeMillis();
		}
	};
	
	public static final void begin(){
		TIME_THREADLOCAL.set(System.currentTimeMillis());
	}
	
	public static final Long end(){
		return System.currentTimeMillis()-TIME_THREADLOCAL.get();
	}
	
	public static void main(String[] args) throws Exception {
		Profiler.begin();
		TimeUnit.SECONDS.sleep(2);
		System.out.println(Thread.currentThread().getName()); 
		System.out.println("Cost: "+Profiler.end()+" mills");
	}

}
