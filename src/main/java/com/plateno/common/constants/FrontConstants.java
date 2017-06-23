package com.plateno.common.constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrontConstants {
	
	public static final Map<String, String> productTypes=new LinkedHashMap<String, String>();//商品类型集合
	
	static{
		/**
		 * 初始化商品类型集合
		 */
		productTypes.put(EnumConstant.PRODUCT_TYPE_MOBILE.getValue(), "手机类");
		productTypes.put(EnumConstant.PRODUCT_TYPE_BOOK.getValue(), "书籍类");
		productTypes.put(EnumConstant.PRODUCT_TYPE_FRUIT.getValue(), "水果类");
		productTypes.put(EnumConstant.PRODUCT_TYPE_CLOSH.getValue(), "衣服类");
	}

	public Map<String, String> getProducttypes() {
		return productTypes;
	}
}
