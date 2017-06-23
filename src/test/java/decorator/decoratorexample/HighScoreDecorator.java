package decorator.decoratorexample;

public class HighScoreDecorator extends Decorator{

	public HighScoreDecorator(SchoolReport schoolReport) {
		super(schoolReport);
		// TODO Auto-generated constructor stub
	}
	
	public void reportHighScore(){
		System.out.println("最高成绩是：...");
	} 
	
	public void report(){
		this.reportHighScore();
		super.report();
	}

}
