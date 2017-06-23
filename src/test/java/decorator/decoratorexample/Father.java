package decorator.decoratorexample;

public class Father {
	
	public static void main(String[] args) {
		SchoolReport sr=new FourthSchoolReport();//子类实例化的对象，向上转型为SchoolReport引用
		
		sr.report();
		sr.sign();
		
		sr=new HighScoreDecorator(sr);//第一次动态为对象sr进行装饰
		
		sr.report();
		sr.sign();
		
		sr=new SortDecorator(sr);//第二次动态为对象sr进行装饰
		
		sr.report();
		sr.sign();
		
	}

}
