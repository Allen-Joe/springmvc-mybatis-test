package com.plateno.common.designpattern.adapter.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @描述：劳务公司的人员信息接口实现类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月25日下午4:00:10
 * @version v1.0
 */
public class OuterUser implements IOuterUser{

	public Map<String,String> getUserBaseInfo() {
		// TODO Auto-generated method stub
		HashMap<String, String> baseInfoMap=new HashMap<String, String>();
		baseInfoMap.put("userName", "【劳务公司】员工的姓名是......");
		baseInfoMap.put("moblieNumber", "【劳务公司】员工的手机号码是......");
		return baseInfoMap;
	}

	public Map<String,String> getUserOfficeInfo() {
		// TODO Auto-generated method stub
		HashMap<String, String> officeInfoMap=new HashMap<String, String>();
		officeInfoMap.put("jobPositon", "【劳务公司】员工的职位是......");
		officeInfoMap.put("officeNumber", "【劳务公司】员工的办公电话是......");
		return officeInfoMap;
	}

	public Map<String,String> getUserHomeInfo() {
		// TODO Auto-generated method stub
		HashMap<String, String> homeInfoMap=new HashMap<String, String>();
		homeInfoMap.put("homeTelNumber", "【劳务公司】员工的家庭电话是......");
		homeInfoMap.put("homeAddress", "【劳务公司】员工的家庭地址是......");
		return homeInfoMap;
	}

}
