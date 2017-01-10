package com.fuli.web.dao;


import java.util.List;

import com.fuli.web.pojo.BannerInfo;

public interface BannerDao {
    int deleteByPrimaryKey(Integer bannerId);

    int insert(BannerInfo record);

    int insertSelective(BannerInfo record);

    BannerInfo selectByPrimaryKey(Integer bannerId);

    int updateByPrimaryKeySelective(BannerInfo record);

    int updateByPrimaryKey(BannerInfo record);
    
    List<BannerInfo> selectAll();
}