package decorator.useexample;

public class Client {
	
	public static void main(String[] args) {
		
		Component component=new CartoonStatio();
		component=new Balloon(component);
		component=new Lamplight(component);
		component=new Microphone(component);
		
		System.out.println("----start----"); 
		System.out.println("描述："+component.getDescription()); 
		System.out.println("总价"+component.calculate()); 
		System.out.println("----end----"); 
		System.out.println();
		
		Component component1=new JokerStudio();
		component1=new Balloon(component1);
		component1=new Lamplight(component1);
		component1=new Microphone(component1);
		
		System.out.println("----start----"); 
		System.out.println("描述："+component1.getDescription()); 
		System.out.println("总价"+component1.calculate()); 
		System.out.println("----end----"); 
		System.out.println();
		
		Component component2=new SuperStudio();
		component2=new Balloon(component2);
		component2=new Lamplight(component2);
		component2=new Microphone(component2);
		
		System.out.println("----start----"); 
		System.out.println("描述："+component2.getDescription()); 
		System.out.println("总价"+component2.calculate()); 
		System.out.println("----end----"); 
		
	}

}
