package com.plateno.common.designpattern.command.ATMexample.command;

import java.math.BigDecimal;
import java.util.Vector;

import com.plateno.common.designpattern.command.ATMexample.receiver.Receiver;
import com.plateno.common.designpattern.command.ATMexample.vo.Account;
import com.plateno.common.designpattern.command.ATMexample.vo.Response;
import com.plateno.common.designpattern.command.ATMexample.vo.UserTradeRecord;

/**
 * 
 * @描述：用户查询交易流水命令--具体命令角色
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午10:50:39
 * @version v1.0
 */
public class UserTradeRecordsCommand extends Command{
	
	private String accountNo;

	public UserTradeRecordsCommand(Receiver receiver,String accountNo) {
		super(receiver);
		// TODO Auto-generated constructor stub
		this.accountNo=accountNo;
	}

	@Override
	public Response<Vector<UserTradeRecord>> execute() {
		return super.receiver.getTradeRecordsByAccountNo(accountNo);
	}

}
