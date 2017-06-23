package exception.exceptionwhilemodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用while循环建立异常“恢复模型”
 * @描述：
 * @创建人：Chenliqiao
 * @创建时间：2017年3月27日上午11:19:15
 * @version v1.0
 */
public class WhileModel {
	
	public static void main(String[] args) {
		int i=0;
		List<Student> students=new ArrayList<Student>();
		while(true){
			try {
				Student student=students.get(i);
				System.out.println(student.getName()+"【已恢复】");
				break;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				if(i==3){
					students.add(new Student("stu1"));
					students.add(new Student("stu2"));
					students.add(new Student("stu3"));
					students.add(new Student("stu4"));
					students.add(new Student("stu5"));
					students.add(new Student("stu6"));
					students.add(new Student("stu7"));
					students.add(new Student("stu8"));
					students.add(new Student("stu9"));
				}
			} finally{
				i++;
			}
		}
	}

}
