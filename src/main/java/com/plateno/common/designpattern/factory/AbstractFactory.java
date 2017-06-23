package com.plateno.common.designpattern.factory;

public abstract class AbstractFactory {
	
	public abstract <T extends AbstractProduct> T createProduct(Class<T> c);

}
