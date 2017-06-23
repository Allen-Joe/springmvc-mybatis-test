package exception.test1;

public class ExceptionTest1 {
	
	public static void main(String[] args) {
		try {
			throw new Exception("ExceptionTest1");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			System.out.println("ExceptionTest1【finally】");
		}
	}

}
