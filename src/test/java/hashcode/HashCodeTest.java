package hashcode;

import java.util.HashSet;

public class HashCodeTest {
	
	public static void main(String[] args) {
		
		HashSet<HashCodeObject> set=new HashSet<HashCodeTest.HashCodeObject>();
		HashCodeObject a=new HashCodeObject(1);
		HashCodeObject b=new HashCodeObject(1);
		HashCodeObject c=new HashCodeObject(1);
		HashCodeObject d=new HashCodeObject(2);
		HashCodeObject e=new HashCodeObject(3);
		set.add(a);
		set.add(b);
		set.add(c);
		set.add(d);
		set.add(e);
		
		System.out.println(a.hashCode()==b.hashCode());
		System.out.println(a.equals(b));
		System.out.println(a==b);
		System.out.println(set);
		
	}
	
	static class HashCodeObject{
		private int i;
		
		public HashCodeObject(int i){
			this.i=i;
		}
		
		/**
		 * 
		 * @描述:重写equals方法
		 * @param obj
		 * @return
		 * @创建人：Chenliqiao
		 * @创建时间：2017年6月20日下午5:33:46
		 */
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(obj==null)
				return false;
			if(!(obj instanceof HashCodeObject))
				return false;
			if(this==obj)
				return true;
			HashCodeObject object=(HashCodeObject) obj;
			return i==object.i;
		}
		
		/**
		 * 
		 * @描述:重写equals时，也重写hashCode()方法
		 * @return
		 * @创建人：Chenliqiao
		 * @创建时间：2017年6月20日下午5:34:59
		 */
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			//return super.hashCode();
			return i;
		}
	}

}
