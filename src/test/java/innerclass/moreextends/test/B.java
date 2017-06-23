package innerclass.moreextends.test;

import java.util.ArrayList;
import java.util.List;

public class B {
	
	private U[] array=new U[10];
	
	public void addUToArray(U u){
		for (int i=0;i<array.length;i++) {
			if(array[i]==null){
				array[i]=u;
				break;
			}
				
		}
	}
	
	public void clearArray(U u){
		for (int i=0;i<array.length;i++) {
			if(array[i]==u){
				array[i]=null;
			}
				
		}
	}
	
	public void forEachArrayUMehtod(){
		for (U u : array) {
			if(u!=null){
				u.method1();
				u.method2();
				u.method3();
			}
		}
	}
	
	public static void main(String[] args) {
		List<U> us=new ArrayList<U>();
		A[] as={new A("对象1"),new A("对象2"),new A("对象3")};
		B b=new B();
		for (A a : as) {
			U u=a.getU();
			b.addUToArray(u);
			us.add(u);
		}
		b.forEachArrayUMehtod();
		for (U u : us) {
			b.clearArray(u);
		}
		b.forEachArrayUMehtod();
		
	}

}
