package com.plateno.common.designpattern.strategy.define;

/**
 * 
 * @描述：策略模式 -- 封装类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月24日上午10:39:42
 * @version v1.0
 */
public class Context {

	private Strategy stratrgy;
	
	//设置要执行的具体策略
	public Context(Strategy stratrgy){
		this.stratrgy=stratrgy;
	}
	
	//执行策略中的运算法则
	public void opreate(){
		this.stratrgy.operate();
	}
}
