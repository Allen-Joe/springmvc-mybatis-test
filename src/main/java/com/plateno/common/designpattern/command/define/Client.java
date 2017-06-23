package com.plateno.common.designpattern.command.define;

public class Client {
	
	public static void main(String[] args) {
		/**
		 * =====================命令模式实现===============================
		 */
		//定义命令调用者对象
		Invoker invoker=new Invoker();
		
//		//定义命令具体接受者对象
//		Receiver receiver1=new ConcreteReceiver1();
//		Receiver receiver2=new ConcreteReceiver2();
//		
//		//定义具体命令对象
//		Command command1=new ConcreteCommand1(receiver1);
//		Command command2=new ConcreteCommand2(receiver2);
		
		//定义具体命令对象
		Command command1=new ConcreteCommand1();
		Command command2=new ConcreteCommand2();
		
		//调用者接收和调用命令
		System.out.println("------------command1命令-----------");
		invoker.setCommand(command1);
		invoker.action();
		
		System.out.println("------------command2命令-----------");
		invoker.setCommand(command2);
		invoker.action();
	}

}
