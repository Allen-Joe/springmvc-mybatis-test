package com.plateno.common.designpattern.command.ATMexample.vo;

/**
 * 
 * @描述：用户登陆参数封装Vo
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日下午3:16:43
 * @version v1.0
 */
public class UserLoginVo {
	
	private String accountNo;
	private String userMobile;
	private String passWord;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	
}
