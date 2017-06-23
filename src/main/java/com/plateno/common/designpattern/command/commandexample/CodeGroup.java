package com.plateno.common.designpattern.command.commandexample;

/**
 * 
 * @描述：代码组
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午2:43:03
 * @version v1.0
 */
public class CodeGroup extends Group{

	/**
	 * 
	 * @描述:客户要求代码组过去沟通
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:43:37
	 */
	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("找到代码组...");
	}

	/**
	 * 
	 * @描述:客户要求增加一项功能
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:44:00
	 */
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("客户要求增加一项功能");
	}

	/**
	 * 
	 * @描述:客户要求删除一项功能
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:44:54
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("客户要求删除一项功能");
	}

	/**
	 * 
	 * @描述:客户要求修改一项功能
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:45:09
	 */
	@Override
	public void change() {
		// TODO Auto-generated method stub
		System.out.println("客户要求修改一项功能");
	}

	/**
	 * 
	 * @描述:客户要求给出变更的计划
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:45:25
	 */
	@Override
	public void plan() {
		// TODO Auto-generated method stub
		System.out.println("客户要求给出变更的计划");
	}

}
