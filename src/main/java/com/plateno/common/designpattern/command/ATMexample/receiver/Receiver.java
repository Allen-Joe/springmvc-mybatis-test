package com.plateno.common.designpattern.command.ATMexample.receiver;

import java.math.BigDecimal;
import java.util.Vector;

import org.apache.commons.collections.CollectionUtils;

import com.plateno.common.designpattern.command.ATMexample.observer.Observer;
import com.plateno.common.designpattern.command.ATMexample.vo.Account;
import com.plateno.common.designpattern.command.ATMexample.vo.Response;
import com.plateno.common.designpattern.command.ATMexample.vo.UserTradeRecord;

/**
 * 
 * @描述：接受者角色类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午10:33:38
 * @version v1.0
 */
public abstract class Receiver {
	
	protected Account account;//用户银行账户
	
	public Receiver(Account account){
		this.account=account;
	}
	
	/**
	 * 
	 * @描述:用户存钱
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月20日上午10:39:18
	 */
	public abstract Response<Account> inMoney(BigDecimal inMoney);
	
	/**
	 * 
	 * @描述:用户取钱
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月20日上午10:39:29
	 */
	public abstract Response<Account> outMoney(BigDecimal inMoney);
	
	/**
	 * 
	 * @描述:根据账户号获取交易流水
	 * @param accountNo
	 * @return
	 * @返回类型 Response<Vector<UserTradeRecord>>
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月22日上午10:34:19
	 */
	public abstract Response<Vector<UserTradeRecord>> getTradeRecordsByAccountNo(String accountNo);
	
	/**
	 * ========================加入观察者模式用于监控用户交易行为=====================
	 * 
	 */
	private Vector<Observer> observers=new Vector<Observer>();
	
	public void addObserver(Observer o){
		observers.add(o);
	}
	
	public void delObserver(Observer o){
		observers.remove(o);
	}
	
	public void notifyObservers(UserTradeRecord tradeRecord){
		if(CollectionUtils.isNotEmpty(observers)){
			for (Observer o : observers) { 
				o.update(tradeRecord);
			}
		}
	}
	
	
}
