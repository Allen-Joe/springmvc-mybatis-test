package decorator.decoratorexample;

public class SortDecorator extends Decorator{

	public SortDecorator(SchoolReport schoolReport) {
		super(schoolReport);
		// TODO Auto-generated constructor stub
	}
	
	public void reportSort(){
		System.out.println("这次的排名是：....");
	}
	
	public void sign(){
		this.reportSort();
		super.sign();
	}

}
