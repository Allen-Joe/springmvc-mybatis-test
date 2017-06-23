package hashmap.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {
	
	private static AtomicInteger ai=new AtomicInteger(0);
	private static HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>(1);
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {				
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName());
					while(ai.get()<1000){
						hashMap.put(ai.get(), ai.get());
						ai.incrementAndGet();
					}
				}
			}).start();
			
		}
		
		Thread.sleep(5000); 
		
		Set<Map.Entry<Integer, Integer>> set=hashMap.entrySet();
		Iterator<Map.Entry<Integer, Integer>> iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next()+"\t");
		}
	}

}
