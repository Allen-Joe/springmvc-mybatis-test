package hashmap.linkedhashmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @描述：顾名思义，LRUCache就是基于LRU算法的Cache（缓存），这个类继承自LinkedHashMap，而类中看到没有什么特别的方法，这说明LRUCache实现缓存LRU功能都是源自LinkedHashMap的。LinkedHashMap可以实现LRU算法的缓存基于两点：

        1、LinkedList首先它是一个Map，Map是基于K-V的，和缓存一致

        2、LinkedList提供了一个boolean值可以让用户指定是否实现LRU

                        那么，首先我们了解一下什么是LRU：LRU即Least Recently Used，最近最少使用，也就是说，当缓存满了，会优先淘汰那些最近最不常访问的数据。比方说数据a，1天前访问了；数据b，2天前访问了，缓存满了，优先会淘汰数据b。
 * @创建人：Chenliqiao
 * @创建时间：2017年6月19日下午4:11:04
 * @version v1.0
 */
public class LinkHashMapWithLRU {
	
	public static void main(String[] args) {
		LinkedHashMap<String, String> linkedHashMap=new LinkedHashMap<String, String>(16,0.75f,true);
		linkedHashMap.put("111", "111");
		linkedHashMap.put("222", "222");
		linkedHashMap.put("333", "333");
		linkedHashMap.put("444", "444");
		loopLinkedHashMap(linkedHashMap);
		
		linkedHashMap.get("111");
		loopLinkedHashMap(linkedHashMap);
		
		linkedHashMap.put("333", "333");
		loopLinkedHashMap(linkedHashMap);
		
	}
	
	private static void loopLinkedHashMap(LinkedHashMap<String, String> linkedHashMap){
		Set<Map.Entry<String, String>> set=linkedHashMap.entrySet();
		Iterator<Map.Entry<String, String>> iterator=set.iterator();
		
		while(iterator.hasNext()){
			System.out.print(iterator.next()+"\t");
		}
		System.out.println();
	}

}
