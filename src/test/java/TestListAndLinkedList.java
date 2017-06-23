import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TestListAndLinkedList {

	public static void main(String[] args) {
//		List<String> list=new ArrayList<String>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		list.add("4");
//		list.add("5");
//		
//		for (String string : list) {
//			System.out.print(string+" ");
//		}				
		
//		Set<String> set=new HashSet<String>();
//		set.add("A");
//		set.add("B");
//		set.add("C");
//		set.add("D");
//		set.add("E");
//		set.add("F");
//		set.add("G");
//		set.add("H");
//		
//		Set<String> removeSet=new HashSet<String>();
//		removeSet.add("B");
//		removeSet.add("C");
//		removeSet.add("G");
//		removeSet.add("K");
//		removeSet.add("W");
//		removeSet.add("X");
//		
//		set.removeAll(removeSet);
//		
//		for (String string : set) {
//			System.out.println(string);
//		}
		
//		   List<Student> stu = new ArrayList<Student>();  
//	        stu.add(new Student("1","yi"));  
//	        stu.add(new Student("3","san"));  
//	        stu.add(new Student("3","san"));  
//	        stu.add(new Student("2","er"));  
//	        stu.add(new Student("2","er"));  
//	        //set集合保存的是引用不同地址的对象  
//	        Set<Student> ts = new HashSet<Student>();  
//	        ts.addAll(stu);  
//	          
//	        for (Student student : ts) {  
//	            System.out.println(student.getId()+"-"+student.getName());  
//	        }  
		
		List<HotelActivityTitle> hat=new ArrayList<HotelActivityTitle>();
		hat.add(new HotelActivityTitle("ACT001","测试活动1"));
		hat.add(new HotelActivityTitle("ACT001","测试活动1"));
		hat.add(new HotelActivityTitle("ACT002","测试活动2"));
		hat.add(new HotelActivityTitle("ACT003","测试活动3"));
		hat.add(new HotelActivityTitle("ACT003","测试活动3"));
		hat.add(new HotelActivityTitle("ACT002","测试活动2"));
		hat.add(new HotelActivityTitle("ACT004","测试活动4"));
		
		Set<HotelActivityTitle> set=new HashSet<HotelActivityTitle>(hat);
		
		for (HotelActivityTitle hotelActivityTitle : set) {
			System.out.println(hotelActivityTitle.getActCode()+" : "+hotelActivityTitle.getActName());
		}
		
	}

}
