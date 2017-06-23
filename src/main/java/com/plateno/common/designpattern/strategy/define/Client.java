package com.plateno.common.designpattern.strategy.define;

public class Client {
	
	public static void main(String[] args) {
		
		/**
		 * 
		 * -----------策略模式实现场景类---------------
		 * 
		 */
		//声明封装类
		Context context;
		
		//执行策略
		context=new Context(new ConcreteStrategy1());
		
		context.opreate();
		//执行策略
		context=new Context(new ConcreteStrategy2());
		context.opreate();
	}

}
