package com.plateno.common.designpattern.strategy.enumexample;

/**
 * 
 * @描述：策略枚举
 * @创建人：Chenliqiao
 * @创建时间：2017年1月25日上午11:44:25
 * @version v1.0
 */
public enum Calculator {
	
	ADD("+") {
		@Override
		public int exec(int a, int b) {
			// TODO Auto-generated method stub
			return a+b;
		}
	},
	SUB("-") {
		@Override
		public int exec(int a, int b) {
			// TODO Auto-generated method stub
			return a-b;
		}
	};
	
	private String value;
	
	private Calculator(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public abstract int exec(int a,int b);

}
