package generic.test1;

public class Holder3<T> {
	
	private T a;
	
	public Holder3(T a){
		this.a=a;
	}
	
	public void set(T a){
		this.a=a;
	}
	
	public T get(){
		return a;
	}
	
	public static void main(String[] args) {
		//基类
		Holder3<AutoMobile> holder3=new Holder3<AutoMobile>(new AutoMobile("AAA"));
		AutoMobile autoMobile=holder3.get();
		autoMobile.showName();
		
		//导出类
		Holder3<SubAutoMobile> subHolder3=new Holder3<SubAutoMobile>(new SubAutoMobile("sub_AAA")); 
		AutoMobile subAutoMobile=subHolder3.get();
		subAutoMobile.showName();
	}

}
