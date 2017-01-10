package com.fuli.web.dao;


import java.util.List;

import com.fuli.web.pojo.HotInfo;

public interface HotDao {
    int deleteByPrimaryKey(Integer hotId);

    int insert(HotInfo record);

    int insertSelective(HotInfo record);

    HotInfo selectByPrimaryKey(Integer hotId);

    int updateByPrimaryKeySelective(HotInfo record);

    int updateByPrimaryKey(HotInfo record);
    
    int selectCount(HotInfo info);
    
    List<HotInfo> selectAll(HotInfo info);
}