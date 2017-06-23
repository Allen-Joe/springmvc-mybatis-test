package com.plateno.common.designpattern.command.commandexample;

/**
 * 
 * @描述：具体的命令类，代表一条“新增需求”的命令
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午3:23:50
 * @version v1.0
 */
public class AddRequirementCommand extends Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.requirementGroup.find();
		super.requirementGroup.add();
		super.requirementGroup.plan();
	}

}
