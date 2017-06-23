package com.plateno.common.designpattern.command.commandexample;

/**
 * 
 * @描述：具体命令类，代表一条“删除页面”的命令
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午3:42:42
 * @version v1.0
 */
public class DeletePageCommand extends Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.pageGroup.find();
		super.pageGroup.delete();
		super.pageGroup.plan();
	}

}
