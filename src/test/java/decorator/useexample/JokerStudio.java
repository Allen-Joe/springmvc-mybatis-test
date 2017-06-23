package decorator.useexample;

public class JokerStudio extends Component{
	
	private String name="小丑演播厅";
	
	private int price=150;

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
