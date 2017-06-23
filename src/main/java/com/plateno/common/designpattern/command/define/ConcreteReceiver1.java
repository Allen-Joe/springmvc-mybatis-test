package com.plateno.common.designpattern.command.define;

/**
 * 
 * @描述：命令模式--具体命令接受者类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午4:51:12
 * @version v1.0
 */
public class ConcreteReceiver1 extends Receiver{

	@Override
	public void serviceMethod() {
		// TODO Auto-generated method stub
		System.out.println("接受者对象 ConcreteReceiver1 执行业务方法啦~~~");
	}

}
