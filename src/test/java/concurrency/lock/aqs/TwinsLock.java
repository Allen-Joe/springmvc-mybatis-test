package concurrency.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock{
	
	private final Sync sync=new Sync(10);
	
	private static final class Sync extends AbstractQueuedSynchronizer{
		
		Sync(int count){
			if(count<0){
				throw new IllegalArgumentException("count must large than zero.");
			}
			setState(count);
		}
		
		@Override
		protected int tryAcquireShared(int reduceCount) {
			// TODO Auto-generated method stub
			for (;;) {
				int current=getState();
				int newCount=current-reduceCount;
				if(newCount<0||compareAndSetState(current, newCount)){
					return newCount;
				}
			}
		}
		
		@Override
		protected boolean tryReleaseShared(int returnCount) {
			// TODO Auto-generated method stub
			for(;;){
				int current=getState();
				int newCount=current+returnCount;
				if(compareAndSetState(current, newCount)){
					return true;
				}
			}
		}
	}

	public void lock() {
		// TODO Auto-generated method stub
		sync.acquireShared(1);
	}
	
	public void unlock() {
		// TODO Auto-generated method stub
		sync.releaseShared(1);
	}
	
	/**
	 * ===============其他业务方法================
	 */

	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
