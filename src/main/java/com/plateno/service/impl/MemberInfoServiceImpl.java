package com.plateno.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateno.common.observer.Subject;
import com.plateno.common.pager.Pager;
import com.plateno.dao.MemberInfoDao;
import com.plateno.pojo.MemberInfo;
import com.plateno.pojo.MemberQueryVo;
import com.plateno.service.MemberInfoService;

@Service("memberInfoService")
public class MemberInfoServiceImpl extends Subject implements MemberInfoService{
	
	@Autowired
	private MemberInfoDao memberInfoDao;

	public MemberInfo getMemberById(int memberId) {
		// TODO Auto-generated method stub
		return this.memberInfoDao.selectByPrimaryKey(memberId);
	}

	public void deleteMemberById(int memberId) {
		// TODO Auto-generated method stub
		this.memberInfoDao.deleteByPrimaryKey(memberId);
		
	}

	public void addMember(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		this.memberInfoDao.insert(memberInfo);
	}

	public void updateMember(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		this.memberInfoDao.updateByPrimaryKey(memberInfo);
	}

	public List<MemberInfo> findAllMembers() {
		// TODO Auto-generated method stub
		return this.memberInfoDao.selectAll();
	}

	public Pager findByCondition(MemberQueryVo condition) {
		// TODO Auto-generated method stub
		//分页条件查询集合
		List resultList=this.memberInfoDao.selectByCondition(condition);
		//条件查询总记录数（不分页）
		int recordCount=this.memberInfoDao.selectCountByCondition(condition);
		return new Pager(condition.getPageNo(),condition.getPageSize(),recordCount,resultList);
	}

//	public void setObserver(ConcreteObserver observer) {
//		// TODO Auto-generated method stub
//		super.addObserver(observer);
//	}

}
