package decorator.useexample;

public class Balloon extends Decorator{
	
	private String name="气球";
	
	private int price=10;
	
	public Balloon(Component component) {
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
