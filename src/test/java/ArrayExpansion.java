import java.util.ArrayList;
import java.util.List;


public class ArrayExpansion {
	
	public static void main(String[] args) {
		
		/**
		 * 给数组intArray扩容
		 */
//		int[] intArray=new int[10];
//		for (int i = 0; i < intArray.length; i++) {
//			intArray[i]=i;
//			System.out.print(intArray[i]);
//		}
//		
//		int newArray[]=new int[intArray.length*2];
//		for (int i = 0; i < intArray.length; i++) {
//			newArray[i]=intArray[i];
//		}
//		intArray=newArray;
//		System.out.println(intArray.length);
		
		List list=new ArrayList<String>(5);//list自动扩容
		System.out.println(list.size());
		for (int i = 0; i < 6; i++) {
			list.add(i);
			System.out.println(list.get(i));
		}
		System.out.println(list.size());
	}

}
