package com.fuli.web.service.main;

import java.util.List;

import com.fuli.web.pojo.InterfaceInfo;

public interface InterfaceService {

	public void createAccessKey(InterfaceInfo weip);

	public InterfaceInfo queryByAccessKey(String token);

	public List<InterfaceInfo> queryAll();

}
