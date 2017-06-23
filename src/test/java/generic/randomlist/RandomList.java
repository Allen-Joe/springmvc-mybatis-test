package generic.randomlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList<T> {
	
	private List<T> storage=new ArrayList<T>();
	private Random random=new Random(47);
	
	public void add(T item){
		storage.add(item);
	}
	
	public T next(){
		T item=storage.get(random.nextInt(storage.size()));
		return item;
	}
	
	public static void main(String[] args) {
		RandomList<String> randomList=new RandomList<String>();
		for (String str : "A B C D E F".split(" ")) { 
			randomList.storage.add(str);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(randomList.next());
		}
		
		RandomList<Integer> randomList1=new RandomList<Integer>();
		for (String str : "1 2 3 4 5 6".split(" ")) { 
			randomList1.storage.add(Integer.parseInt(str));
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(randomList1.next());
		}
	}
}
