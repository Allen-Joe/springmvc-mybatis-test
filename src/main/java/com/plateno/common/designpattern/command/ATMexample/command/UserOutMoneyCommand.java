package com.plateno.common.designpattern.command.ATMexample.command;

import java.math.BigDecimal;

import com.plateno.common.designpattern.command.ATMexample.receiver.Receiver;
import com.plateno.common.designpattern.command.ATMexample.vo.Account;
import com.plateno.common.designpattern.command.ATMexample.vo.Response;

/**
 * 
 * @描述：用户取钱命令--具体命令角色
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午10:50:39
 * @version v1.0
 */
public class UserOutMoneyCommand extends Command{
	
	private BigDecimal inMoney;

	public UserOutMoneyCommand(Receiver receiver,BigDecimal inMoney) {
		super(receiver);
		// TODO Auto-generated constructor stub
		this.inMoney=inMoney;
	}

	@Override
	public Response<Account> execute() {
		return super.receiver.outMoney(inMoney);
	}

}
