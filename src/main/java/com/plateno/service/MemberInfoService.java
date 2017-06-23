package com.plateno.service;

import java.util.List;

import com.plateno.common.pager.Pager;
import com.plateno.pojo.MemberInfo;
import com.plateno.pojo.MemberQueryVo;

public interface MemberInfoService {
	
 /**
  * 根据会员id获取会员信息
  * @param memberId
  * @return
  */
 public MemberInfo getMemberById(int memberId);
 
 /**
  * 根据会员id删除会员信息
  * @param memberId
  */
 public void deleteMemberById(int memberId);
 
 /**
  * 新增会员信息
  * @param memberInfo
  */
 public void addMember(MemberInfo memberInfo);
 
 /**
  * 修改会员信息
  * @param memberInfo
  */
 public void updateMember(MemberInfo memberInfo);
 
 /**
  * 查询所有会员信息列表
  * @return
  */
 public List<MemberInfo> findAllMembers();
 
 /**
  * 分页条件查询
  * @param condition
  * @return
  */
 public Pager findByCondition(MemberQueryVo condition);
 
}
