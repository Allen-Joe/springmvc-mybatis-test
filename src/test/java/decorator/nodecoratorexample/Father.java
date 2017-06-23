package decorator.nodecoratorexample;

public class Father {
	
	public static void main(String[] args) {
		
//		SchoolReport sr=new FourthGradeSchoolReport();
//		sr.report();
//		sr.sign("XXX");
		SchoolReport sr=new SugarFourthGradeSchoolReport();
		sr.report();
		sr.sign("XXX");
	}

}
