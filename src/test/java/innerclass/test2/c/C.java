package innerclass.test2.c;

import innerclass.test2.a.A;
import innerclass.test2.b.B;

public class C extends B{

	public A getBInner(){
		return new BInner();
	}
	
	public static void main(String[] args) {
		C c=new C();
		A a=c.getBInner();
		System.out.println(a);
	}
}
