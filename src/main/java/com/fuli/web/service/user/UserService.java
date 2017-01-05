package com.fuli.web.service.user;

import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.UserInfo;

public interface UserService {
	
	GsonModel register(UserInfo user);
}
