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
public class UserController extends BaseController<UserInfo> {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 863448476331026649L;

	@Autowired
	private UserService userService;
	
	/**
	 * @Auther: zhuwt  
	 * @Description: 注册
	 * @Date:2017年1月11日上午10:34:39
	 * @param request
	 * @param userInfo
	 * @return  
	 * @return GsonModel 
	 * @说明  代码版权归 杭州山网络科技有限公司 所有
	 */
	@RequestMapping(value = "/register")
	public @ResponseBody GsonModel register(HttpServletRequest request,
			UserInfo userInfo) {
		return getSuccessResultGson(userService.register(userInfo));
	}
	
	/**
	 * @Auther: zhuwt  
	 * @Description: 登录
	 * @Date:2017年1月11日上午10:34:49
	 * @param request
	 * @param userInfo
	 * @return  
	 * @return GsonModel 
	 * @说明  代码版权归 杭州山网络科技有限公司 所有
	 */
	@RequestMapping(value = "/login")
	public @ResponseBody GsonModel login(HttpServletRequest request,
			UserInfo userInfo) {
		return getSuccessResultGson(userService.login(userInfo));
	}

}
