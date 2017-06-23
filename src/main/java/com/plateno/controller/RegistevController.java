package com.plateno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plateno.common.designpattern.handler.service.CommonRegistev;
import com.plateno.common.designpattern.handler.service.VipResgistev;
import com.plateno.common.designpattern.handler.vo.Response;
import com.plateno.common.designpattern.handler.vo.UserInfo;


/**
 * 
 * @描述：用户注册Http接口
 * @创建人：Chenliqiao
 * @创建时间：2017年1月18日下午3:35:17
 * @version v1.0
 */
@Controller
@RequestMapping("/registev")
public class RegistevController {
	
	private CommonRegistev commomHandler;

	public RegistevController(){
		//设置责任链节点执行顺序
		this.commomHandler=new CommonRegistev();
		VipResgistev vipHandler=new VipResgistev();
		commomHandler.setNextHandler(vipHandler);
	}
	
	/**
	 * 
	 * @描述:用户注册接口（普通用户和vip用户统一注册接口）
	 * @param param
	 * @return
	 * @throws Exception
	 * @返回类型 Response
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月18日下午3:50:07
	 */
	@RequestMapping(value="/regUserinfo",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody
	public Response regUserinfo(@RequestBody UserInfo userInfo) throws Exception{
		Response response=new Response();
		response=commomHandler.handlerRequest(userInfo);
		return response;
	}
	
	
}
