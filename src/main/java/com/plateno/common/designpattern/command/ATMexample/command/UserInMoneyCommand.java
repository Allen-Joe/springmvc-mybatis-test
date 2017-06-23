package com.plateno.common.designpattern.command.ATMexample.command;

import java.math.BigDecimal;

import com.plateno.common.designpattern.command.ATMexample.receiver.Receiver;
import com.plateno.common.designpattern.command.ATMexample.vo.Account;
import com.plateno.common.designpattern.command.ATMexample.vo.Response;

/**
 * 
 * @描述：用户存钱命令--具体命令角色
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午10:49:56
 * @version v1.0
 */
public class UserInMoneyCommand extends Command{
	
	private BigDecimal inMoney;

	public UserInMoneyCommand(Receiver receiver,BigDecimal inMoney) {
		super(receiver);
		// TODO Auto-generated constructor stub
		this.inMoney=inMoney;
	}

	@Override
	public Response<Account> execute() {
		return super.receiver.inMoney(inMoney);
	}

}
