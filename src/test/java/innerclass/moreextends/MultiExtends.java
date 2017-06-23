package innerclass.moreextends;

public class MultiExtends {
	
	static void takeA(A a){
		System.out.println("第一次继承");
	}
	static void takeB(B b){
		System.out.println("第二次继承");
	}
	
	public static void main(String[] args) {
		C c=new C();
		takeA(c);
		takeB(c.getB());
	}

}
