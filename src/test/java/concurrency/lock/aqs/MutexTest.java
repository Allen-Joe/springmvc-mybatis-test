package concurrency.lock.aqs;

public class MutexTest {
	
	private static Mutex lock=new Mutex();
	
	private static int count=0;
	
	public static void main(String[] args) {		
		
		Thread thread1=new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				count++;
				System.out.println(Thread.currentThread().getName()+" this is Mutex lock "+count +" "+System.currentTimeMillis());
				lock.unlock();
			}
		},"thread1");
		
       Thread thread2=new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				count++;
				System.out.println(Thread.currentThread().getName()+" this is Mutex lock "+count+" "+System.currentTimeMillis());
				lock.unlock();
			}
		},"thread2");
       
       Thread thread3=new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				count++;
				System.out.println(Thread.currentThread().getName()+" this is Mutex lock "+count+" "+System.currentTimeMillis());
				lock.unlock();
			}
		},"thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
