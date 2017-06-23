package decorator.define;

public class ConcreteDecoratorA extends Decorartor{

	public ConcreteDecoratorA(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	
	public void method1(){
		System.out.println("ConcreteDecoratorA-->method1()");
	}
	
	public  void operate(){
		this.method1();
		super.operate();
	}

}
