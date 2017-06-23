package innerclass.test1;

public interface InterfaceTest {
	
	int getNum();
	
	/**
	 * 
	 * @描述：位于接口内部的类是嵌套类，默认是public和static
	 * @创建人：Chenliqiao
	 * @创建时间：2017年4月6日下午4:59:38
	 * @version v1.0
	 */
	class InterfaceTestImpl implements InterfaceTest{

		public int getNum() {
			// TODO Auto-generated method stub
			return 1;
		}
		
		public static void main(String[] args) {
			InterfaceTest it=new InterfaceTestImpl();
			System.out.println(it.getNum());
		}
		
	}
	

}
