package innerclass.moreextends;

public class C extends A{//第一次继承

	public B getB(){
		return new B() {//此处为第二次继承
		};
	}
}
