package com.plateno.common.designpattern.strategy.example;

/**
 * 
 * @描述：场景类 -- 赵云执行策略
 * @创建人：Chenliqiao
 * @创建时间：2017年1月23日下午4:27:56
 * @version v1.0
 */
public class Zhaoyun {

	public static void main(String[] args) {
		/**
		 * 
		 *--------------策略模式实现例子-------------
		 */
		Context context;
		System.out.println("--刚刚到吴国时，拆开第一个锦囊");
		context=new Context(new BlackDoor());//拿到妙计
		context.operate();//拆开执行
		
		System.out.println("--刘备乐不思蜀了，拆开第二个锦囊");
		context=new Context(new GivenGreenLight());//拿到妙计
		context.operate();//拆开执行
		
		System.out.println("--追兵在后，拆开第三个锦囊");
		context=new Context(new BlockEnemy());//拿到妙计
		context.operate();//拆开执行
		
	}
}
