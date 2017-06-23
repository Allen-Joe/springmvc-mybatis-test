package com.plateno.common.designpattern.command.ATMexample.receiver;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Vector;

import org.apache.commons.collections.CollectionUtils;

import com.plateno.common.designpattern.command.ATMexample.observer.UserTradeRecordObserver;
import com.plateno.common.designpattern.command.ATMexample.vo.Account;
import com.plateno.common.designpattern.command.ATMexample.vo.Response;
import com.plateno.common.designpattern.command.ATMexample.vo.UserTradeRecord;

/**
 * 
 * @描述：银行系统中心--具体接受者角色
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午10:32:23
 * @version v1.0
 */
public class BankSystemCenter extends Receiver{

	public BankSystemCenter(Account account) {
		super(account);
		// TODO Auto-generated constructor stub
		super.addObserver(new UserTradeRecordObserver());
	}

	@Override
	public Response<Account> inMoney(BigDecimal inMoney) {
		// TODO Auto-generated method stub
		BigDecimal restMoney=super.account.getRestMoney();
		restMoney=restMoney.add(inMoney);
		super.account.setRestMoney(restMoney);
		//返回结果
		Response<Account> response=new Response<Account>();
		response.setResultCode(0);
		response.setResultMsg("存款成功");
		response.setData(super.account);
		//生成交易流水
		UserTradeRecord tradeRecord=new UserTradeRecord();
		tradeRecord.setAccountNo(super.account.getAccountNo());
		tradeRecord.setTradeNo(Calendar.getInstance().getTime()+"");
		tradeRecord.setTradeName("存款");
		tradeRecord.setTradeMoney(inMoney);
		tradeRecord.setTradeTime(Calendar.getInstance().getTime());
		//通知观察者
		super.notifyObservers(tradeRecord);
		return response;		
	}

	@Override
	public Response<Account> outMoney(BigDecimal outMoney) {
		// TODO Auto-generated method stub
		Response<Account> response=new Response<Account>();
		BigDecimal restMoney=super.account.getRestMoney();
		if(restMoney.compareTo(outMoney)==-1){
			response.setResultCode(-1);
			response.setResultMsg("余额不足");
			response.setData(super.account);
			return response;
		}
		restMoney=restMoney.subtract(outMoney);
		super.account.setRestMoney(restMoney);
		response.setResultCode(0);
		response.setResultMsg("取款成功");
		response.setData(super.account);
		//生成交易流水
		UserTradeRecord tradeRecord=new UserTradeRecord();
		tradeRecord.setAccountNo(super.account.getAccountNo());
		tradeRecord.setTradeNo(Calendar.getInstance().getTime()+"");
		tradeRecord.setTradeName("取款");
		tradeRecord.setTradeMoney(outMoney);
		tradeRecord.setTradeTime(Calendar.getInstance().getTime());
		//通知观察者
		super.notifyObservers(tradeRecord);
		return response;
	}

	@Override
	public Response<Vector<UserTradeRecord>> getTradeRecordsByAccountNo(
			String accountNo) {
		// TODO Auto-generated method stub
		Response<Vector<UserTradeRecord>> response=new Response<Vector<UserTradeRecord>>();
		if(CollectionUtils.isEmpty(UserTradeRecordObserver.getRecords())){
			response.setResultCode(0);
			response.setResultMsg("当前账号没有交易流水~");
			return response;
		}
		Vector<UserTradeRecord> records=new Vector<UserTradeRecord>();
		for (UserTradeRecord userTradeRecord : UserTradeRecordObserver.getRecords()) {
			if(accountNo.equals(userTradeRecord.getAccountNo())){
				records.add(userTradeRecord);
			}
		}
		response.setResultCode(0);
		response.setResultMsg("success");
		response.setData(records);
		return response;
	}

}
