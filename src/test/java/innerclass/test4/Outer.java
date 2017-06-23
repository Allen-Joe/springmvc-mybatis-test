package innerclass.test4;

public class Outer {
	
	class Inner{
		public Inner(){
			System.out.println("正在初始化内部类~~");
		}
		
		public Outer createOuter(){
			return Outer.this;//new Outer();
		}
	}

}
