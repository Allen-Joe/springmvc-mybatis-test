package com.plateno.common.designpattern.strategy.enumexample;



public class Client {
	
	public static void main(String[] args) {
		
		System.out.println(Calculator.ADD.exec(1, 2));
		System.out.println(Calculator.SUB.exec(2, 1));
	}

}
