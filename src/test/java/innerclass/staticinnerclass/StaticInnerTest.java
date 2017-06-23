package innerclass.staticinnerclass;

import innerclass.staticinnerclass.StaticInnerTest.StaticInner.StaticInnerInner;

public class StaticInnerTest {
	
	public static class StaticInner{//嵌套类，即静态内部类
		public StaticInner(){
			System.out.println("我是嵌套类StaticInner，我初始化啦~~");
		}
		
		public static class StaticInnerInner{
			public StaticInnerInner(){
				System.out.println("我是嵌套类的嵌套类StaticInnerInner，我初始化啦~~");
			}
		}
	}
	
	public static void main(String[] args) {
		StaticInner staticInner=new StaticInner();
		System.out.println(staticInner);
		StaticInnerInner staticInnerInner=new StaticInnerInner();
		System.out.println(staticInnerInner);
	}

}
