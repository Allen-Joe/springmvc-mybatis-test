package com.plateno.common.designpattern.command.ATMexample.invoker;

import com.plateno.common.designpattern.command.ATMexample.command.Command;
import com.plateno.common.designpattern.command.ATMexample.vo.Account;
import com.plateno.common.designpattern.command.ATMexample.vo.Response;

/**
 * 
 * @描述：调用者角色
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午11:20:50
 * @version v1.0
 */
public class Invoker {
	
	private Command command;
	
	/**
	 * 
	 * @描述:接受命令
	 * @param command
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月20日上午11:22:32
	 */
	public void setCommand(Command command){
		this.command=command;
	}
	
	/**
	 * 
	 * @描述:调用命令
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月20日上午11:23:36
	 */
	public Response<?> action(){
		return this.command.execute();
	}

}
