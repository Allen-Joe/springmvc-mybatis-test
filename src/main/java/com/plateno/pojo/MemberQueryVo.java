package com.plateno.pojo;

import com.plateno.common.pager.Pager;

public class MemberQueryVo extends Pager{

	private String memberName;
	private String memberSex;
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}	
	

}
