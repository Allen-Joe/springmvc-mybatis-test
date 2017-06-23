package decorator.useexample;

public class CartoonStatio extends Component{
	
	private String name="卡通演播厅";
	
	private int price=100;

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
