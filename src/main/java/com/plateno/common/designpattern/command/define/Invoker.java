package com.plateno.common.designpattern.command.define;

/**
 * 
 * @描述：命令模式--命令调用者类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午4:35:57
 * @version v1.0
 */
public class Invoker {

	/**接收到的命令**/
	private Command command;
	
	/**
	 * 
	 * @描述:设置接收到的命令
	 * @param command
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午4:37:32
	 */
	public void setCommand(Command command){
		this.command=command;
	}
	
	/**
	 * 
	 * @描述:调用命令，即传达命令给接收者
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午4:38:10
	 */
	public void action(){
		this.command.execute();//执行命令
	}
	
}
