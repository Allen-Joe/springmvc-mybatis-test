package com.plateno.common.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObserver  implements Observer{

	private static List<String> messages=new ArrayList<String>();

	//更新方法
	public void update(String message) {
		// TODO Auto-generated method stub
		messages.add(message);
	}
	
	/**
	 * 
	 * @描述:获取更新信息
	 * @return
	 * @返回类型 List<String>
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月16日上午11:39:30
	 */
	public static List<String> getMessage(){
		return messages;
	}
}
