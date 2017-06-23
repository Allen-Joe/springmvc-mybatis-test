package innerclass.test1;

public class Outer {
	
	private String message;
	
	public Outer(){
		this.message="我是外部类Outer的私有域";
	}
	
	class Inner{
		public Inner(){
			System.out.println("我是内部类，我初始化啦~~~");
		}
		
		public void messageToString(){
			System.out.println("【内部类方法】:"+message);
		}
	}
	
	private Inner getInner(){
		return new Inner();
	}
	
	public static void main(String[] args) {
		Outer outer=new Outer();
//		Outer.Inner inner=outer.getInner();
//		System.out.println(inner);
//		inner.messageToString();
		Inner inner=outer.new Inner();
		inner.messageToString();
	}

}
