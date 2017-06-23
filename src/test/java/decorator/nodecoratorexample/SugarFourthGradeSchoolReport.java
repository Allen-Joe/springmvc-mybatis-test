package decorator.nodecoratorexample;

public class SugarFourthGradeSchoolReport extends FourthGradeSchoolReport{
	
	private void reportHighScore(){
		System.out.println("这次考试，语文最高是78，数学最高是80，自然最高是80");
	}
	
	private void reportSort(){
		System.out.println("这次在班里排名38名");
	}
	
	@Override
	public void report() {
		this.reportHighScore();
		super.report();
		this.reportSort();
	}

}
