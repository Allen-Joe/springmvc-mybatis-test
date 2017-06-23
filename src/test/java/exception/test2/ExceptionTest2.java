package exception.test2;

public class ExceptionTest2 {
	
	public static void main(String[] args){
		Student student=null;
//		try {
//			student.setName("stu1");
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		//student.setName("stud1"); 
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("!!!"); 
			e.printStackTrace();
			System.out.println("!!!~~~"); 
		}
	}

}
