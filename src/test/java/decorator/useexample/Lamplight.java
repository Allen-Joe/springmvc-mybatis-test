package decorator.useexample;

public class Lamplight extends Decorator{
	
	private String name="灯光";
	
	private int price=25;
	
	public Lamplight(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public int calculate(){
		int sum=super.calculate()+this.price;
		return sum;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String description=super.getDescription()+"+"+this.name;
		return description;
	}
	

}
