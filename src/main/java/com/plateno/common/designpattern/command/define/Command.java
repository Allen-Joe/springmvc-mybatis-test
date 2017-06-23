package com.plateno.common.designpattern.command.define;

/**
 * 
 * @描述：命令模式--抽象的命令角色类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午4:29:59
 * @version v1.0
 */
public abstract class Command {
	
	//定义一个子类的全局共享变量
	protected final Receiver receiver;
	
	//实现类必须定义一个接受者
	public Command(Receiver receiver){
		this.receiver=receiver;
	}

	/**
	 * 
	 * @描述:所有具体命令角色对象必须执行的方法
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午4:31:17
	 */
	public abstract void execute();
}
