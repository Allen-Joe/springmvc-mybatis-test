package com.plateno.dao.mongo.model;

import java.util.Date;

public class HotelInfo {

	private String hotelId;    //酒店编号
	private String name;       //酒店名称
	private String brief;      //简介
	private String address;    //地址
	private Date addTime;    //新增时间
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	
	

}
