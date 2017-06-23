package innerclass.moreextends.test;

public class A {
	
	private String name;
	
	public A(String name){
		this.name=name;
	}
	
	public U getU(){
		return new U() {
			
			public void method3() {
				// TODO Auto-generated method stub
				System.out.println("method3【"+name+"】");
			}
			
			public void method2() {
				// TODO Auto-generated method stub
				System.out.println("method2【"+name+"】");
			}
			
			public void method1() {
				// TODO Auto-generated method stub
				System.out.println("method1【"+name+"】");
			}
		};
	}

}
