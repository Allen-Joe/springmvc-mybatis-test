package com.plateno.common.designpattern.command.ATMexample.vo;

import java.math.BigDecimal;
import java.util.Date;

public class UserTradeRecord {
	
	private Integer id;
	private String tradeNo;
	private String tradeName;
	private BigDecimal tradeMoney;
	private String accountNo;
	private Date tradeTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public BigDecimal getTradeMoney() {
		return tradeMoney;
	}
	public void setTradeMoney(BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	
	
}
