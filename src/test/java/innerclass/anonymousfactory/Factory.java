package innerclass.anonymousfactory;

/**
 * 
 * @描述：运用匿名内部类实现的工厂模式~~~
 * @创建人：Chenliqiao
 * @创建时间：2017年3月24日下午3:44:15
 * @version v1.0
 */
public class Factory {
	
	/**
	 * 
	 * @描述:获取指定的服务工厂，并创建指定的服务，和执行服务的业务方法
	 * @param factory
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年3月24日下午3:42:52
	 */
	public static void serviceComsumer(ServiceFactory factory){
		Service service=factory.getService();
		service.method1();
		service.method2();
	}
	
	public static void main(String[] args) {
		serviceComsumer(ServiceImpl1.serviceFactory);
		serviceComsumer(ServiceImpl2.serviceFactory);
	}

}
