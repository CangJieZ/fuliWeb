package com.fuli.web.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuli.web.common.Constants;
import com.fuli.web.common.InterfaceCodeMsg;
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
				model.setCode(Constants.FAIL_SUCCESS);
			}
		}
		return model;
	}

}
