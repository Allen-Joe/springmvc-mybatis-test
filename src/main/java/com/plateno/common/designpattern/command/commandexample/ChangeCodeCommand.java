package com.plateno.common.designpattern.command.commandexample;

/**
 * 
 * @描述：具体命令类，代表一条“修改功能”的命令
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午3:46:42
 * @version v1.0
 */
public class ChangeCodeCommand extends Command{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.codeGroup.find();
		super.codeGroup.change();
		super.codeGroup.plan();
	}

}
