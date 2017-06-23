package decorator.useexample;

public abstract class Decorator extends Component{
	
	private Component component;
	
	public Decorator(Component component){
		this.component=component;
	}
	
	@Override
	public int calculate(){
		return component.calculate();
	}	
	
	@Override
	public String getDescription(){
		return component.getDescription();
	}

}
