package innerclass.test3;

public class Outer {

	private int value=0;
	
	private int getValue(){
		return value;
	}
	
	class Inner{	
		public void visitOuter(){
			value++;
			getValue();
		}
	}
	
	private void visitInner(){
		Inner inner=new Inner();
		inner.visitOuter();
	}
	
	public static void main(String[] args) {
		Outer outer=new Outer();
		outer.visitInner();
		System.out.println(outer.value);
	}
}
