package exception.myexception;

/**
 * 
 * @描述：自定义异常
 * @创建人：Chenliqiao
 * @创建时间：2017年3月27日上午10:59:07
 * @version v1.0
 */
public class MyException extends Exception{
	
	private String exMessage;

	public MyException(String _exMessage){
		this.exMessage=_exMessage;
	}
	
	public void showMsg(){
		System.out.println(this.exMessage);
	}
	
	public static void main(String[] args) throws MyException {
//		try {
//			throw new MyException("myException");
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace(System.err);
//		}
		throw new MyException("myException");
	}
}
