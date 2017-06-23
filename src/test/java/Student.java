import java.io.Serializable;


public class Student implements Serializable{
	
	/**
	 * @字段：serialVersionUID
	 * @功能描述：
	 * @创建人：Chenliqiao
	 * @创建时间：2017年3月22日下午5:12:27
	 */
	
	private static final long serialVersionUID = 1L;
	public String id;  
	public String name;  
	public Student() {  
	}  
	public Student(String id,String name) {  
	this.id = id;  
	this.name = name;  
	}  
	public String getId() {  
	return id;  
	}  
	public void setId(String id) {  
	this.id = id;  
	}  
	public String getName() {  
	return name;  
	}  
	public void setName(String name) {  
	this.name = name;  
	}  
	@Override  
	public boolean equals(Object obj) {  
	Student s=(Student)obj;   
	return id.equals(s.id) && name.equals(s.name);   
	}  
	@Override  
	public int hashCode() {  
	String in = id + name;  
	return in.hashCode();  
	}  

}
