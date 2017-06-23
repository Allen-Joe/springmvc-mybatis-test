package concurrency.runnable;

public class TestTaskMainThread {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new TestTask()).start();
		}
	}

}
