package com.fuli.web.controller.banner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuli.web.controller.BaseController;
import com.fuli.web.pojo.BannerInfo;
import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.UserInfo;
import com.fuli.web.service.banner.BannerService;

@Controller
@RequestMapping("/banner")
@Scope("prototype")
public class BannerController extends BaseController<BannerInfo>{

	/**  
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	 */
	private static final long serialVersionUID = 5299144476606072940L;
	
	@Autowired
	private BannerService bannerService;
	
	@RequestMapping(value = "/banner")
	public @ResponseBody GsonModel banner(HttpServletRequest request,
			UserInfo userInfo) {
		return getSuccessResultGson(bannerService.banner());
	}


}
