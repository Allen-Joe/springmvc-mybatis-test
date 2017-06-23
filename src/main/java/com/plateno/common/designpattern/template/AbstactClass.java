package com.plateno.common.designpattern.template;

public abstract class AbstactClass {
	
	protected void baseMethod1(){}
	
	protected void baseMethod2(){}
	
	public final void templateMethod1(){
		this.baseMethod1();
	}
	
	public final void templateMethod2(){
		this.baseMethod2();
	}

}
