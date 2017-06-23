package concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicIntegerTest {
	
	private static AtomicInteger ai=new AtomicInteger();//原子更新基本类型类
	
	private static int[] intarray=new int[]{1,2};
	private static AtomicIntegerArray ai_array=new AtomicIntegerArray(intarray);//原子更新数组类
	
	private static AtomicReference<User> ar_user=new AtomicReference<User>();//原子更新引用类
	
	public static void main(String[] args) {
		System.out.println(ai.getAndIncrement());//返回自增前的值
		System.out.println(ai.get());
		
		ai_array.getAndSet(0, 3);
		System.out.println(ai_array.get(0));
		System.out.println(intarray[0]);//复制多一份数据组，不影响原来数组的值
		
		User user=new User("AAA", "22");
		ar_user.set(user);
		User updateUser=new User("BBB", "25");
		ar_user.compareAndSet(user, updateUser);
		System.out.println(ar_user.get().getName()+" "+ar_user.get().getAge());
		
	}
	
	static class User{
		private String name;
		private String age;
		public User(String name,String age){
			this.name=name;
			this.age=age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		
		
	}

}
