package com.plateno.pojo;

import com.plateno.common.pager.Pager;

public class ProductInfoQueryVo extends Pager{
	
	private String productName; //根据商品名称查询
	
	private String productType; //根据商品类型查询

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}	
	

}
