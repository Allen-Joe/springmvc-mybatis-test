package com.plateno.common.designpattern.command.example;

public class Client {
	
	public static void main(String[] args) {
		System.out.println("-----------客户要求增加一项需求-----------");
		Group reGroup=new RequirementGroup();
		reGroup.find();
		reGroup.add();
		reGroup.plan();
		
		System.out.println("-----------客户要求删除一个页面-----------");
		Group pageGroup=new PageGroup();
		pageGroup.find();
		pageGroup.delete();
		pageGroup.plan();
		
		System.out.println("-----------客户要求修改一个功能-----------");
		Group codeGroup=new CodeGroup();
		codeGroup.find();
		codeGroup.change();
		codeGroup.plan();
	}

}
