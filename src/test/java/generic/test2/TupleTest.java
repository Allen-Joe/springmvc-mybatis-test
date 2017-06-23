package generic.test2;

public class TupleTest {
	
	static TwoTuple<Integer, String> f(){
		return new TwoTuple<Integer, String>(100,"hello");
	}
	
	static ThreeTuple<String, Integer, Boolean> h(){
		return new ThreeTuple<String, Integer, Boolean>("AAA",666,false);
	}
	
	public static void main(String[] args) {
//		TwoTuple<Integer, String> tuple=new TwoTuple<Integer, String>(100,"hello");
//		System.out.println(tuple.toString());
//		
//		ThreeTuple<String, Integer, Boolean> tuple1=new ThreeTuple<String, Integer, Boolean>("AAA",666,false);
//		System.out.println(tuple1.toString());
		TwoTuple<Integer, String> tuple=f();
		ThreeTuple<String, Integer, Boolean> tuple1=h();
		System.out.println(tuple.toString());
		System.out.println(tuple1.toString());
	}

}
