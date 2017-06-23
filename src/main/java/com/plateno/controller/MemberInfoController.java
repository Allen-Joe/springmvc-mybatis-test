package com.plateno.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plateno.common.observer.ConcreteObserver;
import com.plateno.common.observer.Subject;
import com.plateno.common.pager.Pager;
import com.plateno.pojo.MemberInfo;
import com.plateno.pojo.MemberQueryVo;
import com.plateno.service.MemberInfoService;

@Controller
@RequestMapping("/member")
public class MemberInfoController extends Subject{
	
	@Autowired
	private MemberInfoService memberInfoService;
	
	private static final Logger logger=LoggerFactory.getLogger(MemberInfoController.class);
	
	public MemberInfoController(){
		System.out.println("我在spring容器中初始化啦~~~~~");
		setObserver();//设置观察者对象
	}
	
	/**
	 * 分页条件查询
	 * @return
	 */
	@RequestMapping(value="/search")
	public String pageSearch(Model model,MemberQueryVo condition){
	     try {
	    	 if(null==condition){
	    		 condition=new MemberQueryVo();
	    	 }
	    	 condition.setStartIndex(condition.getPageSize()*(condition.getPageNo()-1));
	    	 Pager pager=this.memberInfoService.findByCondition(condition);
	    	 model.addAttribute("pager", pager);
			 model.addAttribute("condition", condition);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("分页查询会员信息出错啦，请检查："+e.getMessage(),e);
		}		
		return "/member/member";
	}
	
	/**
	 * 会员信息预添加
	 * @return
	 */
	@RequestMapping(value="/preAddMember",method=RequestMethod.GET)
	public String preAddMember(){
		return "/member/memberAdd";
	}
	
	/**
	 * 会员信息添加
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addMember(HttpServletRequest request,Model model){
		String name=request.getParameter("memberName");
		String sex=request.getParameter("memberSex");
		Integer age=Integer.valueOf(request.getParameter("memberAge"));
		if(StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(sex)&&age!=null){
			MemberInfo member=new MemberInfo();
			member.setName(name);
			member.setSex(sex);
			member.setAge(age);
			
			memberInfoService.addMember(member);
			//新增成功后，通知观察者（日志类）
			super.noitifyObserver("日志logger：新增会员信息~");
		}
		return pageSearch(model,null);
	}
	
	/**
	 * 会员信息删除
	 * @param memberId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteMember(String memberId,Model model){
		if(StringUtils.isNotBlank(memberId)){
			memberInfoService.deleteMemberById(Integer.valueOf(memberId));
			//删除成功后，通知观察者
			super.noitifyObserver("日志logger：删除了会员id为（"+memberId+"）的会员信息~");
		}
		return pageSearch(model,null);
	}
	

	/**
	 * 会员预修改
	 * @param memberId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/preUpdate",method=RequestMethod.GET)
	public String preUpdateMember(String memberId,Model model){
		if(StringUtils.isNotBlank(memberId)){
			MemberInfo member=memberInfoService.getMemberById(Integer.valueOf(memberId));
			model.addAttribute("member",member);
		}
		return "/member/memberUpdate";
	}
	
	/**
	 * 会员信息修改
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateMember(HttpServletRequest request,Model model){
		String memberId=request.getParameter("memberId");
		MemberInfo member=null;
		if(StringUtils.isNotBlank(memberId)){
			member=memberInfoService.getMemberById(Integer.valueOf(memberId));
			if(member!=null){
				String name=request.getParameter("memberName");
				String sex=request.getParameter("memberSex");
				Integer age=Integer.valueOf(request.getParameter("memberAge"));
				member.setName(name);
				member.setSex(sex);
				member.setAge(age);
				memberInfoService.updateMember(member);
				//model.addAttribute("member", member);
				//修改成功后，通知观察者（日志类）
				super.noitifyObserver("日志logger：修改了会员（"+member.getName()+"）的信息~");
			}
		}
		return pageSearch(model,null);
	}
	
	/**
	 * 
	 * @描述:设置观察者对象
	 * @param memberInfoService
	 * @返回类型 void
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月16日上午11:44:04
	 */
	public void setObserver(){
		ConcreteObserver observer=new ConcreteObserver();
		super.addObserver(observer);
	}
	
}
