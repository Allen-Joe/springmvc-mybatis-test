package innerclass.staticinnerclass;

public interface InterfaceStaticClassTest {

	void doSomething();
	
	class StaticInner implements InterfaceStaticClassTest{//位于接口内部的嵌套类默认是public和static

		public void doSomething() {
			// TODO Auto-generated method stub
			System.out.println("接口的嵌套类实现接口，并重写方法doSomething（）");
		}
		
		public static void main(String[] args) {
			StaticInner staticInner=new StaticInner();
			staticInner.doSomething();
		}
		
	}
}
