package com.fuli.web.dao;

import java.util.List;

import com.fuli.web.pojo.PictureInfo;

public interface PictureDao {
    int deleteByPrimaryKey(Integer pictureId);

    int insert(PictureInfo record);

    int insertSelective(PictureInfo record);

    PictureInfo selectByPrimaryKey(Integer pictureId);

    int updateByPrimaryKeySelective(PictureInfo record);

    int updateByPrimaryKey(PictureInfo record);
    
    List<PictureInfo> selectAll(PictureInfo record);
    
    Integer selectCount(PictureInfo record);
}