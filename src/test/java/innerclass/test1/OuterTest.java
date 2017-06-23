package innerclass.test1;

public class OuterTest {
	
	//内部接口，是静态的
	interface InterfaceA{
		void doSomeTingA();
	}
	
	interface InterfaceB{
		void doSomeTingB();
	}
	
	public static void main(String[] args) {
		
		InterfaceA interfaceA=new InterfaceA() {
			
			public void doSomeTingA() {
				// TODO Auto-generated method stub
				System.out.println("doSomeTingA...");
			}
		};
		interfaceA.doSomeTingA();
		
		InterfaceB interfaceB=new InterfaceB() {
			
			public void doSomeTingB() {
				// TODO Auto-generated method stub
				System.out.println("doSomeTingB...");
			}
		};
		
		interfaceB.doSomeTingB();
		
	}

}
