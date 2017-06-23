package com.plateno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/indexController")
public class IndexController {

	
	@RequestMapping(value="/index")
	public String index(){
		return "/common/index";
	}
}
