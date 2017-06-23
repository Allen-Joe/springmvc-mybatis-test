import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class FutureTest {
	private static String a="allens";

	public static class Task implements Callable<String>{

		public String call() throws Exception {
			// TODO Auto-generated method stub
			System.out.println("ah");
			System.out.println(a);
			return "something";
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Future<String>> results=new ArrayList<Future<String>>();
		ExecutorService es=Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			results.add(es.submit(new Task()));
		}
		
		for (Future<String> result : results) {
			System.out.println(result.get());
		}
		
	}

}
