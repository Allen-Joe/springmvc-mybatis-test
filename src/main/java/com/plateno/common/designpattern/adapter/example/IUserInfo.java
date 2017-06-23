package com.plateno.common.designpattern.adapter.example;

/**
 * 
 * @描述：员工信息接口
 * @创建人：Chenliqiao
 * @创建时间：2017年1月25日下午3:43:13
 * @version v1.0
 */
public interface IUserInfo {

	/**
	 * 
	 * @描述:获取用户姓名
	 * @return
	 * @返回类型 String
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月25日下午3:46:07
	 */
	public String getUserName();
	
	/**
	 * 
	 * @描述:获取家庭地址
	 * @return
	 * @返回类型 String
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月25日下午3:46:38
	 */
	public String getHomeAddress();
	
	/**
	 * 
	 * @描述:获取用户手机号码
	 * @return
	 * @返回类型 String
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月25日下午3:47:08
	 */
	public String getMoblieNumber();
	
	/**
	 * 
	 * @描述:获取办公电话，一般是座机
	 * @return
	 * @返回类型 String
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月25日下午3:47:47
	 */
	public String getOfficeTelNumber();
	
	/**
	 * 
	 * @描述:获取用户的职位
	 * @return
	 * @返回类型 String
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月25日下午3:48:44
	 */
	public String getJobPosition();
	
	/**
	 * 
	 * @描述:获取家庭电话
	 * @return
	 * @返回类型 String
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月25日下午3:49:27
	 */
	public String getHomeTelNumber();
}
