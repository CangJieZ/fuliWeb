package com.fuli.web.service.gif;

import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.SubjectInfo;

public interface GifService {
	
	GsonModel queryAll(SubjectInfo gifInfo);
}
