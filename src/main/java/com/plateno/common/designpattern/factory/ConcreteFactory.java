package com.plateno.common.designpattern.factory;

public class ConcreteFactory extends AbstractFactory{

	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractProduct> T createProduct(Class<T> c) {
		// TODO Auto-generated method stub
		AbstractProduct product=null;
		try {
			product=(AbstractProduct) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return (T) product;
	}
	
	/**
	 * 
	 * @描述:重载
	 * @param className
	 * @return
	 * @返回类型 T
	 * @创建人 Chenliqiao
	 * @创建时间 2017年4月21日上午9:14:12
	 */
	@SuppressWarnings("unchecked")
	public <T extends AbstractProduct> T createProduct(String className) {
		// TODO Auto-generated method stub
		AbstractProduct product=null;
		try {
			product=(AbstractProduct) Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return (T) product;
	}
	
	/**
	 * 
	 * @描述:静态方法
	 * @param className
	 * @return
	 * @返回类型 T
	 * @创建人 Chenliqiao
	 * @创建时间 2017年4月21日上午9:14:30
	 */
	@SuppressWarnings("unchecked")
	public static <T extends AbstractProduct> T getProductInstance(String className) {
		// TODO Auto-generated method stub
		AbstractProduct product=null;
		try {
			product=(AbstractProduct) Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return (T) product;
	}

}
