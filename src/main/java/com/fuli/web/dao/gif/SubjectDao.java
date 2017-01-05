package com.fuli.web.dao.gif;

import java.util.List;

import com.fuli.web.pojo.SubjectInfo;

public interface SubjectDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectInfo record);

    int insertSelective(SubjectInfo record);

    SubjectInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectInfo record);

    int updateByPrimaryKey(SubjectInfo record);
    
    List<SubjectInfo> selectAll(SubjectInfo record);
    
    Integer selectCount();
}