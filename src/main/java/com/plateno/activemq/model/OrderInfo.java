package com.plateno.activemq.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo implements Serializable{

	
	/**
	 * @字段：serialVersionUID
	 * @功能描述：
	 * @创建人：Chenliqiao
	 * @创建时间：2017年6月23日下午2:38:39
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String orderCode;
	
	private BigDecimal orderPrice;
	
    private Date orderBookingTime;
    
    private String orderPerson;
    
    private Integer orderStatus;    

	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderInfo(String orderCode, BigDecimal orderPrice,
			Date orderBookingTime, String orderPerson, Integer orderStatus) {
		super();
		this.orderCode = orderCode;
		this.orderPrice = orderPrice;
		this.orderBookingTime = orderBookingTime;
		this.orderPerson = orderPerson;
		this.orderStatus = orderStatus;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getOrderBookingTime() {
		return orderBookingTime;
	}

	public void setOrderBookingTime(Date orderBookingTime) {
		this.orderBookingTime = orderBookingTime;
	}

	public String getOrderPerson() {
		return orderPerson;
	}

	public void setOrderPerson(String orderPerson) {
		this.orderPerson = orderPerson;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "{orderCode:"+orderCode+",orderPrice:"+orderPrice+",orderBookingTime:"+orderBookingTime+",orderPerson:"+orderPerson+",orderStatus："+orderStatus+"}";
    }
	

}
