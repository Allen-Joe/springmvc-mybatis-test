package com.plateno.common.designpattern.command.ATMexample.vo;

/**
 * 
 * @描述：银行用户信息
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午10:16:23
 * @version v1.0
 */
public class UserInfo {
	
	private Integer id;
	private String userCode;
	private String userName;
	private String userSex;
	private Account userAccount;
	private String userMobile;
	private String passWord;
	
	public UserInfo(Integer id, String userCode, String userName,
			String userSex, Account userAccount, String userMobile,
			String passWord) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userSex = userSex;
		this.userAccount = userAccount;
		this.userMobile = userMobile;
		this.passWord = passWord;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public Account getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(Account userAccount) {
		this.userAccount = userAccount;
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
