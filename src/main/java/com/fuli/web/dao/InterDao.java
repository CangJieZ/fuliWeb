package com.fuli.web.dao;

import com.fuli.web.pojo.InterInfo;

public interface InterDao {
    int deleteByPrimaryKey(Integer interId);

    int insert(InterInfo record);

    int insertSelective(InterInfo record);

    InterInfo selectByPrimaryKey(Integer interId);
    
    InterInfo selectByToken(String token);

    int updateByPrimaryKeySelective(InterInfo record);

    int updateByPrimaryKey(InterInfo record);
}