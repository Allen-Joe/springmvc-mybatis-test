package concurrency.runnable;

public class MainThread {

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			LiftOff liftOffTask=new LiftOff();
			liftOffTask.run();
		}
	}
}
