import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class JavaSerialTest {

	/**
	 * 
	 * @throws IOException 
	 * @描述:对象序列化
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年3月22日下午4:49:33
	 */
	public static byte[] ObjectSerialToByte(Object object) throws IOException{
		//定义一个字节数组输出流
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		
		//定义对象输出流
		ObjectOutputStream out=new ObjectOutputStream(os);
		
		//将对象写入字节数组输出流，序列化对象
		out.writeObject(object);
		
		byte[] studentByteArray=os.toByteArray();
		
		return studentByteArray;
	}
	
	/**
	 * 
	 * @描述:对象的反序列化
	 * @param studentByteArray
	 * @throws IOException 
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年3月22日下午5:16:55
	 */
	public static Object ByteSerialToObject(byte[] studentByteArray) throws Exception{
		ByteArrayInputStream is=new ByteArrayInputStream(studentByteArray);
		
		ObjectInputStream in=new ObjectInputStream(is);
		
		Object object=in.readObject();
		
		return object;
	}
	
	public static void main(String[] args) throws Exception {
		Student student=new Student();
		student.setId("1");
		student.setName("AA");
		
		byte[] studentByteArray=ObjectSerialToByte(student);
		
		for (byte b : studentByteArray) { 
			System.out.print(b);
			System.out.print(" ");
		}
		
		Student stu=(Student)ByteSerialToObject(studentByteArray);
		
		System.out.println(stu.getName());
	}
}
