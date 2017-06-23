package decorator.define;

public class ConcreteDecoratorB extends Decorartor{

	public ConcreteDecoratorB(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	
	public void method2(){
		System.out.println("ConcreteDecoratorB-->method2()");
	}
	
	public  void operate(){
		super.operate();
		this.method2();
	}

}
