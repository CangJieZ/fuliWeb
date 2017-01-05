package com.fuli.web.service.gif.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuli.web.common.InterfaceCodeMsg;
import com.fuli.web.dao.gif.SubjectDao;
import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.PageInfo;
import com.fuli.web.pojo.SubjectInfo;
import com.fuli.web.service.gif.GifService;

@Service("gifService")
public class GifServiceImpl implements GifService{

	@Autowired
	private SubjectDao gifDao;
	
	@Override
	public GsonModel queryAll(SubjectInfo gifInfo) {
		Integer total = gifDao.selectCount();
		GsonModel model = new GsonModel();
		if (total <= 0) {
			// 没有数据
			model.setCode(InterfaceCodeMsg.NO_DATA);
			return model;
		}
		List<SubjectInfo> list = gifDao.selectAll(gifInfo);
		if (list != null && list.size() > 0) {
			model.setContent(list);
		} else {
			// 没有数据
			model.setCode(InterfaceCodeMsg.NO_DATA);
			return model;
		}
		return model;
	}

}
