package com.fuli.web.service.hot;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuli.web.common.InterfaceCodeMsg;
import com.fuli.web.dao.HotDao;
import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.HotInfo;

@Service("hotService")
public class HotServiceImpl implements HotService{
	
	@Autowired
	private HotDao hotDao;
	
	@Override
	public GsonModel hotDate(HotInfo info) {
		GsonModel model = new GsonModel();
		int count = hotDao.selectCount(info);
		if (0 == count) {
			model.setCode(InterfaceCodeMsg.NO_DATA);
			return model;
		}else {
			List<HotInfo> list = hotDao.selectAll(info);
			model.setContent(list);
		}
		return model;
	}

}
