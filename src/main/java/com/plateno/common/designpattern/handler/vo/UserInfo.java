package com.plateno.common.designpattern.handler.vo;

public class UserInfo {

	private Integer id;
	
	/**用户编码**/
	private String userCode;
	
	/**用户姓名**/
	private String userName;
	
	/**用户性别**/
	private String sex;
	
	/**用户年龄**/
	private Integer age;
	
	/**用户手机号码**/
	private String  userMobile;
	
	/**Vip序列号**/
	private String vipSerialNo;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getVipSerialNo() {
		return vipSerialNo;
	}

	public void setVipSerialNo(String vipSerialNo) {
		this.vipSerialNo = vipSerialNo;
	}

	
	
	
}
