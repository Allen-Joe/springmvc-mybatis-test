package com.plateno.common.constants;

/**
 * 
 * @描述：枚举常量类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月10日下午3:14:54
 * @version v1.0
 */
public enum EnumConstant {

	/**商品类型：手机**/
	PRODUCT_TYPE_MOBILE("1"), 
	
	/**商品类型：书籍**/
	PRODUCT_TYPE_BOOK("2"),
	
	/**商品类型：水果**/
	PRODUCT_TYPE_FRUIT("3"),
	
	/**商品类型：衣服**/
	PRODUCT_TYPE_CLOSH("4");
	
	private String value;

	private EnumConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
