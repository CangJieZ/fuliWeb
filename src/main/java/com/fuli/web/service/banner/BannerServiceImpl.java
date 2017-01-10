package com.fuli.web.service.banner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuli.web.common.InterfaceCodeMsg;
import com.fuli.web.dao.BannerDao;
import com.fuli.web.pojo.BannerInfo;
import com.fuli.web.pojo.GsonModel;

@Service("bannerService")
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerDao bannerDao;

	@Override
	public GsonModel banner() {
		GsonModel gsonModel = new GsonModel();
		List<BannerInfo> list = bannerDao.selectAll();
		if (null != list) {
			gsonModel.setContent(bannerDao.selectAll());
		} else {
			// 没有数据
			gsonModel.setCode(InterfaceCodeMsg.NO_DATA);
			return gsonModel;
		}
		return gsonModel;
	}

}
