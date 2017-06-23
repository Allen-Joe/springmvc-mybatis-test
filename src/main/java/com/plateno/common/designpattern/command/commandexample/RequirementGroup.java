package com.plateno.common.designpattern.command.commandexample;

/**
 * 
 * @描述：需求组
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午2:31:26
 * @version v1.0
 */
public class RequirementGroup extends Group{

	/**
	 * 
	 * @描述:客户要求需求组过去跟他们讨论
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:32:34
	 */
	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("找到需求组...");
	}

	/**
	 * 客户要求增加一项需求
	 * @描述:
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:33:20
	 */
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("客户要求增加一项需求");
	}

	/**
	 * 
	 * @描述:客户要求删除一项需求
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:33:43
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("客户要求删除一项需求");
	}

	/**
	 * 客户要求修改一项需求
	 * @描述:
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:33:56
	 */
	@Override
	public void change() {
		// TODO Auto-generated method stub
		System.out.println("客户要求修改一项需求");
	}

	/**
	 * 
	 * @描述:客户要求给出变更计划
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:34:32
	 */
	@Override
	public void plan() {
		// TODO Auto-generated method stub
		System.out.println("客户要求给出变更计划");
	}

}
