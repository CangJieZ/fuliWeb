package com.fuli.web.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fuli.web.common.Constants;
import com.fuli.web.common.InterfaceCodeMsg;
import com.fuli.web.common.context.CacheContext;
import com.fuli.web.common.exception.BOException;
import com.fuli.web.common.utils.DateTimeUtil;
import com.fuli.web.common.utils.MD5Util;
import com.fuli.web.dao.UserDao;
import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.UserInfo;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public GsonModel register(UserInfo user) {
		UserInfo info = userDao.selectByPhone(user.getPhone());
		GsonModel model = new GsonModel();
		if (info != null) {
			model.setCode(InterfaceCodeMsg.ALREADY_REGISTER);
			model.setMsg("账号已存在");
			return model;
		} else {
			try {
				user.setAddTime(DateTimeUtil.getCurrDate());
				int result = userDao.insert(user);
				if (result < 0) {
					model.setCode(Constants.FAIL_SUCCESS);
				} else {
					List<UserInfo> list = new ArrayList<UserInfo>();
					user.setUserId(result);
					list.add(user);
					model.setContent(list);
				}
			} catch (Exception e) {
				model.setCode(InterfaceCodeMsg.FAIL_INSERT);
			}
		}
		return model;
	}

	@Override
	public GsonModel login(UserInfo user) {
		GsonModel gsonModel = new GsonModel();
		UserInfo userInfo = userDao.selectByPhone(user.getPhone());
		if (null == userInfo) {
			//不存在此用户
			gsonModel.setCode(InterfaceCodeMsg.NO_USER);
			return gsonModel;
		}
		if (!user.getPwd().equals(userInfo.getPwd())) {
			gsonModel.setCode(InterfaceCodeMsg.ERROR_PWD);
			return gsonModel;
		}
		List<UserInfo> list = new ArrayList<UserInfo>();
		list.add(userInfo);
		gsonModel.setContent(list);
		return gsonModel;
	}

}
