package concurrency.callable;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String>{
	
	private int id;
	
	public TaskWithResult(int id){
		this.id=id;
	}

	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "result of TaskWithResult "+this.id;
	}

}
