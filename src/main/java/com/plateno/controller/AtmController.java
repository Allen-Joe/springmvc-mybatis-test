package com.plateno.controller;

import java.math.BigDecimal;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plateno.common.designpattern.command.ATMexample.basedatas.BaseDatas;
import com.plateno.common.designpattern.command.ATMexample.command.Command;
import com.plateno.common.designpattern.command.ATMexample.command.UserInMoneyCommand;
import com.plateno.common.designpattern.command.ATMexample.command.UserOutMoneyCommand;
import com.plateno.common.designpattern.command.ATMexample.command.UserTradeRecordsCommand;
import com.plateno.common.designpattern.command.ATMexample.invoker.Invoker;
import com.plateno.common.designpattern.command.ATMexample.observer.UserTradeRecordObserver;
import com.plateno.common.designpattern.command.ATMexample.receiver.BankSystemCenter;
import com.plateno.common.designpattern.command.ATMexample.receiver.Receiver;
import com.plateno.common.designpattern.command.ATMexample.vo.Account;
import com.plateno.common.designpattern.command.ATMexample.vo.Response;
import com.plateno.common.designpattern.command.ATMexample.vo.UserInfo;
import com.plateno.common.designpattern.command.ATMexample.vo.UserLoginVo;
import com.plateno.common.designpattern.command.ATMexample.vo.UserTradeRecord;

@Controller
@RequestMapping("/atm")
public class AtmController {
	
	/**
	 * 
	 * @描述:用户登录接口
	 * @param user
	 * @param session
	 * @return
	 * @返回类型 Response<UserInfo>
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月20日下午12:15:19
	 */
	@RequestMapping(value="/userLogin",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody
	public Response<UserInfo> userLogin(@RequestBody UserLoginVo loginvo,HttpSession session){
		Response<UserInfo> response=this.validateUserLogin(loginvo);
		if(response.getResultCode()==0){
			session.setAttribute("currentUser", response.getData());
		}
		return response;
	}
	
	/**
	 * 
	 * @描述:校验用户登录
	 * @param user
	 * @return
	 * @返回类型 Response
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月20日上午11:58:46
	 */
	public Response<UserInfo> validateUserLogin(UserLoginVo loginvo){
		Response<UserInfo> response=new Response<UserInfo>();
		if(StringUtils.isNotBlank(loginvo.getUserMobile())){
			if(StringUtils.isNotBlank(loginvo.getPassWord())){//手机号登录
				for (UserInfo vo: BaseDatas.userDatas) {
					if(vo.getUserMobile().equals(loginvo.getUserMobile())&&vo.getPassWord().equals(loginvo.getPassWord())){
						response.setResultCode(0);
						response.setResultMsg("登录成功");
						response.setData(vo);
						return response;
					}
				}
			}else{
				response.setResultCode(-1);
				response.setResultMsg("登录失败【密码不能为空】");
				return response;
			}
		}else if(StringUtils.isNotBlank(loginvo.getAccountNo())){//卡号登录
            if(StringUtils.isNotBlank(loginvo.getPassWord())){
            	for (UserInfo vo: BaseDatas.userDatas) {
					if(vo.getUserAccount().getAccountNo().equals(loginvo.getAccountNo())&&vo.getPassWord().equals(loginvo.getPassWord())){
						response.setResultCode(0);
						response.setResultMsg("登录成功");
						response.setData(vo);
						return response;
					}
				}
			}else{
				response.setResultCode(-1);
				response.setResultMsg("登录失败【密码不能为空】");
				return response;
			}
		}else{
			response.setResultCode(-1);
			response.setResultMsg("登录失败【账号不能为空】");
			return response;
		}
		response.setResultCode(-1);
		response.setResultMsg("登录失败【账号或者密码错误】");
		return response;
	}
	
	/**
	 * 
	 * @描述:用户存款接口
	 * @param inMoney
	 * @param session
	 * @return
	 * @返回类型 Response<String>
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月20日下午3:27:04
	 */
	@RequestMapping(value="/inMoney",method=RequestMethod.POST)
	@ResponseBody
	public Response<Account> inMoney(BigDecimal inMoney,HttpSession session){
		Response<Account> response=new Response<Account>();
		UserInfo currentUser=(UserInfo) session.getAttribute("currentUser");
		if(currentUser==null){
			response.setResultCode(-1);
			response.setResultMsg("请先登录【获取不到用户信息】");
			return response;
		}
		//创建调用者
		Invoker invoker=new Invoker();
		//创建接受者
		Receiver receiver=new BankSystemCenter(currentUser.getUserAccount());
		//创建用户存款命令
		Command command=new UserInMoneyCommand(receiver, inMoney);
		//接受和调用用户存款命令
		invoker.setCommand(command);
		response=(Response<Account>) invoker.action();
		return response;
	}
	
	/**
	 * 
	 * @描述:用户取款接口
	 * @param outMoney
	 * @param session
	 * @return
	 * @返回类型 Response<UserInfo>
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月20日下午4:39:00
	 */
	@RequestMapping(value="/outMoney",method=RequestMethod.POST)
	@ResponseBody
	public Response<Account> outMoney(BigDecimal outMoney,HttpSession session){
		Response<Account> response=new Response<Account>();
		UserInfo currentUser=(UserInfo) session.getAttribute("currentUser");
		if(currentUser==null){
			response.setResultCode(-1);
			response.setResultMsg("请先登录【获取不到用户信息】");
			return response;
		}
		//创建调用者
		Invoker invoker=new Invoker();
		//创建接受者
		Receiver receiver=new BankSystemCenter(currentUser.getUserAccount());
		//创建用户取款命令
		Command command=new UserOutMoneyCommand(receiver, outMoney);
		//接受和调用用户取款命令
		invoker.setCommand(command);
		response=(Response<Account>) invoker.action();
		return response;
	}
	
	/**
	 * 
	 * @描述:根据用户账户号获取交易流水
	 * @param session
	 * @return
	 * @返回类型 Response<Vector<UserTradeRecord>>
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月22日上午10:29:59
	 */
	@RequestMapping(value="/getTradeRecords",method=RequestMethod.POST)
	@ResponseBody
	public Response<Vector<UserTradeRecord>> getTradeRecords(String accountNo,HttpSession session){
		Response<Vector<UserTradeRecord>> response=new Response<Vector<UserTradeRecord>>();
		UserInfo currentUser=(UserInfo) session.getAttribute("currentUser");
		if(currentUser==null){
			response.setResultCode(-1);
			response.setResultMsg("请先登录【获取不到用户信息】");
			return response;
		}
		//创建调用者
		Invoker invoker=new Invoker();
		//创建接受者
		Receiver receiver=new BankSystemCenter(currentUser.getUserAccount());
		//创建用户取款命令
		Command command=new UserTradeRecordsCommand(receiver, accountNo);
		//接受和调用用户取款命令
		invoker.setCommand(command);
		response=(Response<Vector<UserTradeRecord>>) invoker.action();
		return response;
	}
}
