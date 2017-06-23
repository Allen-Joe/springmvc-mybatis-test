package com.plateno.common.designpattern.command.ATMexample.basedatas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.plateno.common.designpattern.command.ATMexample.vo.Account;
import com.plateno.common.designpattern.command.ATMexample.vo.UserInfo;
import com.plateno.common.util.JsonUtil;

public class BaseDatas {
	
	public static final List<UserInfo> userDatas;
	
	static{
		/**
		 * 初始化用户信息
		 */
		userDatas=new ArrayList<UserInfo>();
		userDatas.add(new UserInfo(1, "001", "小A", "男", new Account("600123456", new BigDecimal(100)), "15820251234", "1234"));
		userDatas.add(new UserInfo(2, "002", "小B", "女", new Account("600234567", new BigDecimal(200)), "15820252345", "2345"));
		userDatas.add(new UserInfo(3, "003", "小C", "男", new Account("600345678", new BigDecimal(300)), "15820253456", "3456"));
		userDatas.add(new UserInfo(4, "004", "小D", "女", new Account("600456789", new BigDecimal(400)), "15820254567", "4567"));
		userDatas.add(new UserInfo(5, "005", "小E", "男", new Account("600567890", new BigDecimal(500)), "15820255678", "5678"));
		
	}
	
	public static void main(String[] args) {
		System.out.println(JsonUtil.beanToJson(userDatas));
	}

}
