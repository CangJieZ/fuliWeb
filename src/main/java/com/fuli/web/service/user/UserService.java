package com.fuli.web.service.user;

import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.UserInfo;

public interface UserService {
	
	/**
	 * @Auther: zhuwt  
	 * @Description: 注册
	 * @Date:2017年1月11日上午10:23:39
	 * @param user
	 * @return  
	 * @return GsonModel 
	 * @说明  代码版权归 杭州山网络科技有限公司 所有
	 */
	GsonModel register(UserInfo user);
	
	/**
	 * @Auther: zhuwt  
	 * @Description: 登录
	 * @Date:2017年1月11日上午10:23:49
	 * @param user
	 * @return  
	 * @return GsonModel 
	 * @说明  代码版权归 杭州山网络科技有限公司 所有
	 */
	GsonModel login(UserInfo user);
}
