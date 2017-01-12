package com.fuli.web.service.picture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuli.web.common.Constants;
import com.fuli.web.common.InterfaceCodeMsg;
import com.fuli.web.dao.PictureDao;
import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.PictureInfo;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {

	@Autowired
	PictureDao pictureDao;

	@Override
	public GsonModel pictureData(PictureInfo info) {
		GsonModel model = new GsonModel();
		Integer count = pictureDao.selectCount(info);
		if (count == 0) {
			model.setCode(InterfaceCodeMsg.NO_DATA);
			return model;
		}
		Integer size = info.getStartPage() * Constants.PAGE_SIZE;
		if (size >= count) {
			info.setStartPage(count / Constants.PAGE_SIZE);
		}
		List<PictureInfo> list = pictureDao.selectAll(info);
		model.setContent(list);
		return model;
	}

}
