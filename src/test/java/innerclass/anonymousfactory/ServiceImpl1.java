package innerclass.anonymousfactory;

public class ServiceImpl1 implements Service{
	
	private ServiceImpl1(){}//私有化构造器，是创建对象的方式只能通过serviceFactory
	
	//ServiceImpl1的服务工厂
	public static ServiceFactory serviceFactory=new ServiceFactory() {
		
		public Service getService() {
			// TODO Auto-generated method stub
			return new ServiceImpl1();
		}
	};

	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("ServiceImpl1->method1");
	}

	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("ServiceImpl1->method2");
	}

}
