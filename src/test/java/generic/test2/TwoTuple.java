package generic.test2;

public class TwoTuple<A,B> {

	protected A a;
	protected B b;
	
	public TwoTuple(A _a,B _b){
		this.a=_a;
		this.b=_b;
	}
	
	public String toString(){
		return "("+a+" "+b+")";
	}
}
