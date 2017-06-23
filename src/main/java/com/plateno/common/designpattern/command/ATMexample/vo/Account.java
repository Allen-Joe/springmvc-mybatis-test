package com.plateno.common.designpattern.command.ATMexample.vo;

import java.math.BigDecimal;

/**
 * 
 * @描述：用户账户信息
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午10:22:28
 * @version v1.0
 */
public class Account {

	/**账户卡号**/
	private String accountNo;
	
	/**账户余额**/
	private BigDecimal restMoney;
	
	public Account(String accountNo, BigDecimal restMoney) {
		super();
		this.accountNo = accountNo;
		this.restMoney = restMoney;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getRestMoney() {
		return restMoney;
	}

	public void setRestMoney(BigDecimal restMoney) {
		this.restMoney = restMoney;
	}
	
	
	
}
