package com.fuli.web.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuli.web.controller.BaseController;
import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.UserInfo;
import com.fuli.web.service.user.UserService;

@Controller
@RequestMapping("/user")
@Scope("prototype")
public class UserController extends BaseController<UserInfo>{

	/**  
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	 */
	private static final long serialVersionUID = 863448476331026649L;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register")
	public @ResponseBody GsonModel register(HttpServletRequest request,
			UserInfo userInfo) {
		return getSuccessResultGson(userService.register(userInfo));
	}

}
