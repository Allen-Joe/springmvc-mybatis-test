package generic.test2;

public class ThreeTuple<A,B,C> extends TwoTuple<A, B>{
	
	protected C c;

	public ThreeTuple(A _a, B _b,C _c) {
		super(_a, _b);
		this.c=_c;
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "("+a+","+b+","+c+")";
	}

}
