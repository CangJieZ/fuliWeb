package com.fuli.web.dao.main;

import java.util.List;

import com.fuli.web.pojo.InterfaceInfo;

public interface InterfaceDao {

	int deleteByPrimaryKey(Integer weipId);

	int insert(InterfaceInfo record);

	int insertSelective(InterfaceInfo record);

	InterfaceInfo selectByPrimaryKey(Integer weipId);

	InterfaceInfo queryByAccessKey(String accessKey);

	List<InterfaceInfo> selectAll();

	int updateByPrimaryKeySelective(InterfaceInfo record);

	int updateByPrimaryKey(InterfaceInfo record);
}
