package com.plateno.common.designpattern.factory;

public class Client {
	
	public static void main(String[] args) {
		AbstractFactory factory=new ConcreteFactory();
		AbstractProduct product1=factory.createProduct(ConcreteProduct1.class);
		AbstractProduct product2=factory.createProduct(ConcreteProduct2.class);
		product1.serviceMethod();
		product2.serviceMethod();
		
		/**
		 * 静态工厂创建对象
		 */
		AbstractProduct product3=ConcreteFactory.getProductInstance("ConcreteProduct1");
		AbstractProduct product4=ConcreteFactory.getProductInstance("ConcreteProduct2");
		product3.serviceMethod();
		product4.serviceMethod();
		
	}

}
