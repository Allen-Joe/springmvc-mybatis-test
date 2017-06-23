package com.plateno.common.designpattern.command.commandexample;

/**
 * 
 * @描述：美工组
 * @创建人：Chenliqiao
 * @创建时间：2017年1月19日下午2:37:15
 * @version v1.0
 */
public class PageGroup extends Group{

	/**
	 * 
	 * @描述:客户要求美工组过去跟他们谈
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:39:05
	 */
	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("找到美工组....");
	}

	/**
	 * 客户要求增加一个页面
	 * @描述:
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:39:43
	 */
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("客户要求增加一个页面");
	}

	/**
	 * 客户要求删除一个页面
	 * @描述:
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:40:06
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("客户要求删除一个页面");
	}

	/**
	 * 
	 * @描述:客户要求修改一个页面
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:40:22
	 */
	@Override
	public void change() {
		// TODO Auto-generated method stub
		System.out.println("客户要求修改一个页面");
	}

	/**
	 * 
	 * @描述:客户要求给出变更的计划
	 * @创建人：Chenliqiao
	 * @创建时间：2017年1月19日下午2:40:46
	 */
	@Override
	public void plan() {
		// TODO Auto-generated method stub
		System.out.println("客户要求给出变更的计划");
	}

}
