package arraylist.copyonwritearraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
	
	public static void main(String[] args) {
		
		//ArrayList
		//ArrayList<Integer> list=new ArrayList<Integer>();//抛出并发异常
		
		//LinkedList
		//LinkedList<Integer> list=new LinkedList<Integer>();//抛出并发异常
		
		/**
		 * Vector(相对线程安全)
		 * Vector虽然是线程安全的，但是只是一种相对的线程安全而不是绝对的线程安全，
		 * 它只能够保证增、删、改、查的单个操作一定是原子的，不会被打断，但是如果组合起来用，并不能保证线程安全性
		 */
		//Vector<Integer> list=new Vector<Integer>();//抛出并发异常
		
		/**
		 * CopyOnWriteArrayList(绝对线程安全)
		 * CopyOnWriteArrayList的缺点，就是修改代价十分昂贵，每次修改都伴随着一次的数组复制；
		 * 但同时优点也十分明显，就是在并发下不会产生任何的线程安全问题，也就是绝对的线程安全，
		 * 这也是为什么我们要使用CopyOnWriteArrayList的原因。
		 */
		CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<Integer>();//正常运行
		
	    for (int i = 0; i < 10; i++){
	        list.add(i);
	    }
		
		ListThread1 thread1=new ListThread1(list);
		ListThread2 thread2=new ListThread2(list);
		thread1.start();
		thread2.start();
		
	}
	
	static class ListThread1 extends Thread{
		
		private List<Integer> list;
		
		public ListThread1(List<Integer> list){
			this.list=list;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (Integer val : list) {
				System.out.print(val+"ListThread1\t");
			}
			System.out.println();
		}
		
	}
	
	static class ListThread2 extends Thread{
		
        private List<Integer> list;
		
		public ListThread2(List<Integer> list){
			this.list=list;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+"ListThread2\t");
				list.remove(i);
			}
			System.out.println();
		}
		
	}

}
