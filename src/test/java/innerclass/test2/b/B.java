package innerclass.test2.b;

import innerclass.test2.a.A;

public class B {

	 protected	class BInner implements A{
		public BInner() {
			// TODO Auto-generated constructor stub
		}

		public void aMethod() {
			// TODO Auto-generated method stub
			System.out.println("~~~~");
		}
		 
	 }
}
