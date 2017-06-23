package com.plateno.common.designpattern.adapter.example;

import java.util.Map;

/**
 * 
 * @描述：中转角色
 * @创建人：Chenliqiao
 * @创建时间：2017年1月25日下午4:35:05
 * @version v1.0
 */
public class OuterUserInfo extends OuterUser implements IUserInfo{
	
	private Map<String,String> baseInfoMap=super.getUserBaseInfo();
	private Map<String,String> officeInfoMap=super.getUserOfficeInfo();
	private Map<String,String> homeInfoMap=super.getUserHomeInfo();

	public String getUserName() {
		// TODO Auto-generated method stub
		String userName=this.baseInfoMap.get("userName");
		System.out.println(userName);
		return userName;
	}

	public String getHomeAddress() {
		// TODO Auto-generated method stub
		String homeAddress=this.homeInfoMap.get("homeAddress");
		System.out.println(homeAddress);
		return homeAddress;
	}

	public String getMoblieNumber() {
		// TODO Auto-generated method stub
		String mobileNumber=this.baseInfoMap.get("moblieNumber");
		System.out.println(mobileNumber);
		return mobileNumber;
	}

	public String getOfficeTelNumber() {
		// TODO Auto-generated method stub
		String officeTelNumber=this.officeInfoMap.get("officeNumber");
		System.out.println(officeTelNumber);
		return officeTelNumber;
	}

	public String getJobPosition() {
		// TODO Auto-generated method stub
		String jobPosition=this.officeInfoMap.get("jobPositon");
		System.out.println(jobPosition);
		return jobPosition;
	}

	public String getHomeTelNumber() {
		// TODO Auto-generated method stub
		String homeTelNumber=this.homeInfoMap.get("homeTelNumber");
		System.out.println(homeTelNumber);
		return homeTelNumber;
	}

}
