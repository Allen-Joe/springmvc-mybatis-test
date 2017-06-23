package concurrency.runnable;

public class TestTask implements Runnable{
	private static int taskCount=0;
	private final int id=taskCount++;
	public TestTask(){		
		System.out.println("start Message: task is startied..."); 
		System.out.println("start Message: task is ended..."); 
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			System.out.println("【"+id+"】"+"TestTask is running...");
			Thread.yield();
		}
	}

}
