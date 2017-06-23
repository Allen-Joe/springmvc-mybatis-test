package com.plateno.dao.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductInfo implements Serializable{
	
	private Integer id;
	private String pName;     //商品名称
	private String pType;     //商品类型
	private Double pPrice;    //商品单价
	private String pBrief;    //商品简介
	private Integer pStock;   //商品库存
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public Double getpPrice() {
		return pPrice;
	}
	public void setpPrice(Double pPrice) {
		this.pPrice = pPrice;
	}
	public String getpBrief() {
		return pBrief;
	}
	public void setpBrief(String pBrief) {
		this.pBrief = pBrief;
	}
	public Integer getpStock() {
		return pStock;
	}
	public void setpStock(Integer pStock) {
		this.pStock = pStock;
	}
	
	
   
}
