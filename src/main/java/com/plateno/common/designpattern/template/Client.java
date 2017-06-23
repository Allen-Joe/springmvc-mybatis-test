package com.plateno.common.designpattern.template;

public class Client {
	
	public static void main(String[] args) {
		AbstactClass abstactClass=new ConcreteClass1();
		abstactClass.templateMethod1();
		abstactClass.baseMethod2();
	}

}
