package generic.genericmethods;

/**
 * 
 * @描述：泛型方法的应用
 * @创建人：Chenliqiao
 * @创建时间：2017年3月27日下午5:29:57
 * @version v1.0
 */
public class GenericMethods {
	
	/**
	 * 
	 * @描述:泛型化方法
	 * @param item
	 * @return
	 * @返回类型 String
	 * @创建人 Chenliqiao
	 * @创建时间 2017年3月27日下午5:39:46
	 */
	public <T> String showClassName(T item){
		return item.getClass().getName();
	}
	
	public <A,B,C> String showClassName(A a,B b,C c){
		return a.getClass().getName()+" "+b.getClass().getName()+" "+c.getClass().getName();
	}
	
	public static void main(String[] args) {
		GenericMethods genericMethods=new GenericMethods();
		System.out.println(genericMethods.showClassName("str"));
		System.out.println(genericMethods.showClassName(1));
		System.out.println(genericMethods.showClassName(true));
		System.out.println(genericMethods.showClassName(0.00));
		System.out.println(genericMethods.showClassName(genericMethods));
		
		//多个参数
		System.out.println(genericMethods.showClassName(1, false, genericMethods));
	}

}
