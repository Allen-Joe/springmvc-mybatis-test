package com.plateno.common.designpattern.command.ATMexample.command;

import com.plateno.common.designpattern.command.ATMexample.receiver.Receiver;
import com.plateno.common.designpattern.command.ATMexample.vo.Account;
import com.plateno.common.designpattern.command.ATMexample.vo.Response;

/**
 * 
 * @描述：命令角色
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午10:47:02
 * @version v1.0
 */
public abstract class Command {
	
	protected Receiver receiver;
	
	public Command(Receiver receiver){
		this.receiver=receiver;
	}

	/**
	 * 
	 * @描述:所有具体命令角色必须执行的一个方法
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月20日上午10:48:08
	 */
	public abstract Response<?> execute();
}
