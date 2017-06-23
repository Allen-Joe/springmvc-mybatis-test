package innerclass.test7;

public class AnonymousConcrete {
	
	public AnonymousAbsrtact createAnonymousAbsrtact(){
		return new AnonymousAbsrtact("创建AnonymousAbsrtact对象啦~~~") {//匿名内部类继承自AnonymousAbsrtact抽象类
		};
	}
	
	public static void main(String[] args) {
		AnonymousConcrete ac=new AnonymousConcrete();
		AnonymousAbsrtact aa=ac.createAnonymousAbsrtact();
		System.out.println(aa);
	}

}
