package com.plateno.common.designpattern.strategy.example;

/**
 * 
 * @描述：context封装类 -- 锦囊
 * @创建人：Chenliqiao
 * @创建时间：2017年1月23日下午4:22:19
 * @version v1.0
 */
public class Context {

	private IStrategy strategy;
	
	//构造函数，设置要使用哪个策略
	public Context(IStrategy strategy){
		this.strategy=strategy;
	}
	
	//执行策略方法
	public void operate(){
		this.strategy.operate();
	}
	
}
