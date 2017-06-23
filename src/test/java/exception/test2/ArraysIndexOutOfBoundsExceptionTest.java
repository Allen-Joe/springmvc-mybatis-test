package exception.test2;

public class ArraysIndexOutOfBoundsExceptionTest {
	
	public static void main(String[] args) {
		try {
			Student[] stuArrays={new Student("stu1"),new Student("stu2")};
			for (int i = 0; i < 3; i++) {
				System.out.println(stuArrays[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
