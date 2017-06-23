package com.plateno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plateno.common.observer.ConcreteObserver;

@Controller
@RequestMapping("/logger")
public class LoggerController{
	
	/**
	 * 
	 * @描述:显示日志信息
	 * @param model
	 * @return
	 * @返回类型 String
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月16日上午10:34:02
	 */
	@RequestMapping(value="/showLogger",method=RequestMethod.GET)
	public String showLoggers(Model model){
		model.addAttribute("loggers", ConcreteObserver.getMessage());
		return "/member/memberLogger";
	}

}
