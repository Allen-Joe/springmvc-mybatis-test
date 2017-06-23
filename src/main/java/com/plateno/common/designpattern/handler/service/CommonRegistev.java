package com.plateno.common.designpattern.handler.service;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

import com.plateno.common.designpattern.handler.handler.Handler;
import com.plateno.common.designpattern.handler.vo.Response;
import com.plateno.common.designpattern.handler.vo.UserInfo;


/**
 * 
 * @描述：普通用户注册
 * @创建人：Chenliqiao
 * @创建时间：2017年1月18日下午3:24:08
 * @version v1.0
 */
public class CommonRegistev extends Handler{

	@Override
	public Response echo(UserInfo request) {
		// TODO Auto-generated method stub
		Response response=new Response();
		//保存用户信息
		String userCode=Calendar.getInstance().getTimeInMillis()+"";
		int cnt=1;//调用注册方法，此处缺省
		if(cnt>0){
			response.setResultCode(0);
			response.setResultMsg("普通用户注册成功，向用户发送激活短信，请查收~");
			response.setUserCode(userCode);
		}else{
			response.setResultCode(-1);
			response.setResultMsg("普通用户注册失败");
		}	
		return response;
	}

	@Override
	public boolean isGoingRegistev(UserInfo request) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(request.getVipSerialNo())){
			return true;
		}
		return false;
	}

}
