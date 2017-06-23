package com.plateno.common.designpattern.command.define;

/**
 * 
 * @描述：命令模式--接受者角色抽象类型
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午4:32:37
 * @version v1.0
 */
public abstract class Receiver {
	
	/**
	 * 
	 * @描述:所有具体接受者对象要执行的业务方法
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午4:34:39
	 */
	public abstract void serviceMethod();

}
