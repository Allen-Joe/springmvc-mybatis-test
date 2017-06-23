package decorator.useexample;

public class Microphone extends Decorator{
	
	private String name="麦克风";
	
	private int price=20;
	
	public Microphone(Component component) {
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
