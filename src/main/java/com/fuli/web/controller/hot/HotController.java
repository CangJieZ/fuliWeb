package com.fuli.web.controller.hot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuli.web.controller.BaseController;
import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.HotInfo;
import com.fuli.web.service.hot.HotService;

@Controller
@RequestMapping("/hot")
@Scope("prototype")
public class HotController extends BaseController<HotInfo> {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -2283240018071562991L;

	@Autowired
	private HotService hotService;

	@RequestMapping(value = "/hotDate")
	public @ResponseBody GsonModel hotDate(HttpServletRequest request,
			HotInfo hotInfo) {
		return getSuccessResultGson(hotService.hotDate(hotInfo));
	}

}
