package decorator.decoratorexample;

public abstract class Decorator extends SchoolReport{
	
	private SchoolReport schoolReport;//特殊的代理类
	
	public Decorator(SchoolReport schoolReport){
		this.schoolReport=schoolReport;
	}
	
	public  void report(){
		this.schoolReport.report();
	}
	
	public  void sign(){
		this.schoolReport.sign();
	}

}
