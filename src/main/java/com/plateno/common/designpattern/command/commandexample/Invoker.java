package com.plateno.common.designpattern.command.commandexample;

/**
 * 
 * @描述：负责人类，类似于项目经理，负责传达客户的命令
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午3:51:21
 * @version v1.0
 */
public class Invoker {

	/**客户的命令**/
	private Command command;
	
	/**
	 * 
	 * @描述:设置客户的命令
	 * @param command
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午3:53:43
	 */
	public void setCommand(Command command){
		this.command=command;
	}
	
	/**
	 * 
	 * @描述:传达客户的命令
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午3:54:06
	 */
	public void action(){
		this.command.execute();
	}
}
