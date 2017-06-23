package com.plateno.common.designpattern.command.example;
/**
 * 
 * @描述：抽象组
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午2:24:02
 * @version v1.0
 */
public abstract class Group {

	/**
	 * 
	 * @描述:甲乙双方分开办公，如果你要和某个组讨论，你首先要找到这个组
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午2:27:22
	 */
	public abstract void find();
	
	/**
	 * 
	 * @描述:被要求增加功能
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午2:28:20
	 */
	public abstract void add();
	
	/**
	 * 
	 * @描述:被要求删除功能
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午2:28:48
	 */
	public abstract void delete();
	
	/**
	 * 
	 * @描述:被要求修改功能
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午2:29:13
	 */
	public abstract void change();
	
	/**
	 * 
	 * @描述:被要求给出所有的变更计划
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午2:29:32
	 */
	public abstract void plan();
}
