package concurrency.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Mutex implements Lock{
	
	private static class Sync extends AbstractQueuedSynchronizer{
		
		@Override
		protected boolean isHeldExclusively() {
			// TODO Auto-generated method stub
			return getState()==1;
		}
		
		@Override
		protected boolean tryAcquire(int arg) {
			// TODO Auto-generated method stub
			if(compareAndSetState(0, 1)){
				setExclusiveOwnerThread(Thread.currentThread());
				System.out.println(Thread.currentThread().getName()+" has get sync status "+System.currentTimeMillis());
				return true;
			}
			System.out.println(Thread.currentThread().getName()+" has not get sync status "+System.currentTimeMillis()+",keep waiting....");
			return false;
		}
		
		@Override
		protected boolean tryRelease(int arg) {
			// TODO Auto-generated method stub
			if(getState()==0)
				throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			System.out.println(Thread.currentThread().getName()+" has release sync status "+System.currentTimeMillis());
			return true;
		}
		
		Condition newCondition() {
			// TODO Auto-generated method stub
			return new ConditionObject();
		}
		
		
	}

	//将需要的操作代理到sync上面
	private final Sync sync=new Sync();
	
	public void lock() {
		// TODO Auto-generated method stub
		sync.acquire(1);
	}

	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		sync.acquireInterruptibly(1);
	} 

	public boolean tryLock() {
		// TODO Auto-generated method stub
		return sync.tryAcquire(1);
	}

	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	public void unlock() {
		// TODO Auto-generated method stub
		sync.release(1);
	}

	public Condition newCondition() {
		// TODO Auto-generated method stub
		return sync.newCondition();
	}
	

}
