package decorator.define;

public abstract class Decorartor extends Component{
	
	private Component component;
	
	public Decorartor(Component component){
		this.component=component;		
	}
	
	public  void operate(){
		this.component.operate();
	}

}
