package com.plateno.common.designpattern.command.ATMexample.observer;

import com.plateno.common.designpattern.command.ATMexample.vo.UserTradeRecord;

/**
 * 
 * @描述：观察者接口--用于监控用户的交易行为
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日下午5:40:06
 * @version v1.0
 */
public interface Observer {

	public void update(UserTradeRecord tradeRecord);
}
