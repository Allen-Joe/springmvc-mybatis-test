package decorator.decoratorexample;

public class FourthSchoolReport extends SchoolReport{

	@Override
	public void report() {
		// TODO Auto-generated method stub
		System.out.println("成绩单");
	}

	@Override
	public void sign() {
		// TODO Auto-generated method stub
		System.out.println("家长签名");
	}

}
