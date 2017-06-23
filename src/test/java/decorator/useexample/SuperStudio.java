package decorator.useexample;

public class SuperStudio extends Component{
	
	private String name="超级演播厅";
	
	private int price=300;

	@Override
	public int calculate() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	

}
