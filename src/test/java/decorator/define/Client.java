package decorator.define;

public class Client {
	
	public static void main(String[] args) {
		Component component=new ConcreteComponent();//创建被装饰对象
		
		System.out.println("----未装饰前----");
		component.operate();
		
		System.out.println("----第一次装饰后----");
		component=new ConcreteDecoratorA(component);//第一次装饰
		component.operate();
		
		System.out.println("----第二次装饰后----");
		component=new ConcreteDecoratorB(component);//第二次装饰
		component.operate();
	}

}
