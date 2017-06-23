package com.plateno.common.designpattern.adapter.example;

import java.util.Map;

/**
 * 
 * @描述：劳务公司的人员信息接口
 * @创建人：Chenliqiao
 * @创建时间：2017年1月25日下午3:54:56
 * @version v1.0
 */
public interface IOuterUser {

	/**
	 * 
	 * @描述:获取用户的基本信息，如姓名，手机，性别等
	 * @return
	 * @返回类型 Map
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月25日下午3:56:43
	 */
	public Map<String,String> getUserBaseInfo();
	
	/**
	 * 
	 * @描述:获取用户的办公区域信息
	 * @return
	 * @返回类型 Map
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月25日下午3:57:30
	 */
	public Map<String,String> getUserOfficeInfo();
	
	/**
	 * 
	 * @描述:获取用户家庭信息
	 * @return
	 * @返回类型 Map
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月25日下午3:57:59
	 */
	public Map<String,String> getUserHomeInfo();
	
}
