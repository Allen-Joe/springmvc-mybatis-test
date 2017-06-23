import java.util.List;


public class ClassLoderTest {
	
	public static void main(String[] args) {
		
		//获取系统类加载器/应用程序类加载器
		ClassLoader applicationClassLoader=ClassLoader.getSystemClassLoader();
		System.out.println(applicationClassLoader);
		
		//获取扩展类加载器
		ClassLoader expensionClassLoader=applicationClassLoader.getParent();
		System.out.println(expensionClassLoader);
		System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));  
		
		//获取启动类加载器
		ClassLoader bootstrapClassLoader=expensionClassLoader.getParent();
		System.out.println(bootstrapClassLoader);//启动类加载器不是用java实现的，获取不到
		
	    System.out.println("------------------------");
		
		System.out.println(ClassLoderTest.class.getClassLoader().getClass().getName());
	    System.out.println(System.class.getClassLoader());
	    System.out.println(List.class.getClassLoader());
	    
	    ClassLoader c1=ClassLoderTest.class.getClassLoader();
	    while(c1!=null){
	    	System.out.print(c1.getClass().getName()+"-->");
	    	c1=c1.getParent();
	    }
	    System.out.println(c1);
	}

}
