package com.plateno.common.designpattern.command.ATMexample.vo;

/**
 * 
 * @描述：结果类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月20日上午11:27:47
 * @version v1.0
 */
public class Response<T> {

	private int resultCode;
	
	private String resultMsg;
	
	private T data;
	
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
