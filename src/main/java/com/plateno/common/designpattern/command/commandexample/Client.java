package com.plateno.common.designpattern.command.commandexample;

public class Client {

	public static void main(String[] args) {
		/**
		 * 
		 * =======================命令模式实现场景========================
		 * 
		 */
		//定义负责人，也就是接班人
		Invoker invoker=new Invoker();
		
		//客户要求新增加一项需求
		System.out.println("-------客户要求新增加一项需求------");
		//客户发出新增需求的命令
		Command addRequirementCommand=new AddRequirementCommand();
		//负责人接收客户的命令
		invoker.setCommand(addRequirementCommand);
		//负责人传达命令
		invoker.action();
		
		//客户要求删除一个页面
		System.out.println("-----客户要求删除一个页面------");
		Command deletePageCommand=new DeletePageCommand();
		invoker.setCommand(deletePageCommand);
		invoker.action();
		
		//客户要求修改一项功能
		System.out.println("-----客户要求修改一项功能------");
		Command changeCodeCommand=new ChangeCodeCommand();
		invoker.setCommand(changeCodeCommand);
		invoker.action();
	}
}
