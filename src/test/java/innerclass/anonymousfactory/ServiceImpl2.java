package innerclass.anonymousfactory;

public class ServiceImpl2 implements Service{
	
	private ServiceImpl2(){}//私有化构造器，是创建对象的方式只能通过serviceFactory
	
	//ServiceImpl2的服务工厂
	public static ServiceFactory serviceFactory=new ServiceFactory() {
		
		public Service getService() {
			// TODO Auto-generated method stub
			return new ServiceImpl2();
		}
	};

	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("ServiceImpl2->method1");
	}

	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("ServiceImpl2->method2");
	}

}
