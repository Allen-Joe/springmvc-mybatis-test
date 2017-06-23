package innerclass.test4;

public class Other {
	
	public static void main(String[] args) {
		Outer outer=new Outer();
		System.out.println(outer); 
		Outer.Inner inner=outer.new Inner();
		System.out.println(inner);
		System.out.println(inner.createOuter());
	}

}
