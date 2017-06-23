package container.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
	
	public static void printQueue(Queue queue){
		while(queue.peek()!=null){
			//System.out.print(queue.remove()+" ");
			System.out.print(queue.poll()+" ");
		}
		//System.out.println(queue.poll());
		System.out.println();
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<Integer>();
		Random random=new Random(47);
		for (int i = 0; i < 10; i++) {
			queue.add(random.nextInt(i+10));
		}
		printQueue(queue);
		printQueue(queue);
		
		Queue<Character> queue1=new LinkedList<Character>();
		for (Character character : "Brontosaurus".toCharArray()) {
			//queue1.offer(character);
			queue1.add(character);
		}
		printQueue(queue1); 
		printQueue(queue1); 
	}

}
