package com.plateno.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.plateno.pojo.MemberInfo;
import com.plateno.pojo.MemberQueryVo;

@Repository
public interface MemberInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberInfo record);

    int insertSelective(MemberInfo record);

    MemberInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberInfo record);

    int updateByPrimaryKey(MemberInfo record);
    
    List<MemberInfo> selectAll();
    
    List<MemberInfo> selectByCondition(MemberQueryVo condition);
    
    int selectCountByCondition(MemberQueryVo condition);
    
}