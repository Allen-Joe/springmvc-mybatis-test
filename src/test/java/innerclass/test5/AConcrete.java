package innerclass.test5;

public class AConcrete {
	
	public AInterface createAInterface(){
		//内部类定义方法的作用域内，作用域之外不能访问
//		AInterface a;
//		if(true){
//			class AInterfaceImpl implements AInterface{
//				public void doSometing() {
//					// TODO Auto-generated method stub
//				}
//				
//			}
//			a=new AInterfaceImpl();
//		}
		
		//内部类定义方法内，此内部类属于该方法的一部分，不属于AConcrete类，即该方法之外不能访问这个内部类
		class AInterfaceImpl implements AInterface{
			public void doSometing() {
				// TODO Auto-generated method stub
			}
			
		}
		AInterface a=new AInterfaceImpl();
		return a;
	}
	
	public static void main(String[] args) {
		AConcrete aConcrete=new AConcrete();
		System.out.println(aConcrete.createAInterface());
	}

}
