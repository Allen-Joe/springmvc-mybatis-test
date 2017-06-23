package com.plateno.common.designpattern.command.commandexample;

/**
 * 命令模式实现--命令抽象类
 * @描述：
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午3:14:40
 * @version v1.0
 */
public abstract class Command {

	/**需求组**/
	protected Group requirementGroup=new RequirementGroup();
	
	/**页面组**/
	protected Group pageGroup=new PageGroup();
	
	/**代码组**/
	protected Group codeGroup=new CodeGroup();
	
	/**
	 * 
	 * @描述:只有一个方法，指定命令要执行什么
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日下午3:20:38
	 */
	public abstract void execute();
}
