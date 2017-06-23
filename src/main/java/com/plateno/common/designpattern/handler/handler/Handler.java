package com.plateno.common.designpattern.handler.handler;

import com.plateno.common.designpattern.handler.vo.Response;
import com.plateno.common.designpattern.handler.vo.UserInfo;


/****
 * 
 * @描述：责任链模式--抽象类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月18日下午2:52:34
 * @version v1.0
 */
public abstract class Handler {
	
	private Handler nextHandler;

	/**
	 * 
	 * @描述:节点轮询方法
	 * @param request
	 * @return
	 * @返回类型 Response
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日上午9:22:41
	 */
	public Response handlerRequest(UserInfo request){
		Response response=null;
		if(request!=null){
			if(this.isGoingRegistev(request)){
				response=this.echo(request);
			}else{
			    if(this.nextHandler==null){
			    	response=new Response();
			    	response.setResultCode(-3);
			    	response.setResultMsg("没有可用的注册节点~~");
			    	return response;
			    }			    	
				response=this.nextHandler.handlerRequest(request);
			}
		}else{
			response=new Response();
			response.setResultCode(-2);
			response.setResultMsg("提交参数有误，请检查~");
		}
		return response;
	}

	/**
	 * 
	 * @描述:设置下一个节点
	 * @param nextHandler
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日上午9:23:00
	 */
	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	/**
	 * 
	 * @描述:返回节点处理结果
	 * @param request
	 * @return
	 * @返回类型 Response
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日上午9:23:15
	 */
	public abstract Response echo(UserInfo request);
	
	/**
	 * 
	 * @描述:判断当前请求是否符合当前节点的处理条件，是，则调用该节点的业务方法，否，则轮询到下一个节点
	 * @param request
	 * @return
	 * @返回类型 boolean
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月19日上午9:23:33
	 */
	public abstract boolean isGoingRegistev(UserInfo request);
}
