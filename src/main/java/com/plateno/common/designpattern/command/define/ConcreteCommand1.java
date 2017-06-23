package com.plateno.common.designpattern.command.define;

/**
 * 
 * @描述：命令模式--具体的命令角色类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午4:43:23
 * @version v1.0
 */
public class ConcreteCommand1 extends Command{
	
//	//命令接受者
//	private Receiver receiver;
	
	//默认的命令接受者
	public ConcreteCommand1(){
		super(new ConcreteReceiver1());
	}
	
	//构造函数中初始化命令接受者
	public ConcreteCommand1(Receiver receiver){
		super(receiver);
	}

	/**
	 * 
	 * @描述:根据执行的命令，调用接受者的业务方法
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午4:48:56
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.receiver.serviceMethod();
	}

}
