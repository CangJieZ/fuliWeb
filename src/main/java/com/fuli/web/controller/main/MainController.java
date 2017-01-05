package com.fuli.web.controller.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuli.web.controller.BaseController;
import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.SubjectInfo;
import com.fuli.web.service.gif.GifService;

@Controller
@RequestMapping("/gif")
@Scope("prototype")
public class MainController extends BaseController<SubjectInfo> {

	private static final long serialVersionUID = 1363180356539642335L;

	@Autowired
	private GifService gifService;

	@RequestMapping(value = "/findGif")
	public @ResponseBody GsonModel findCompany(HttpServletRequest request,
			SubjectInfo gifInfo) {
		return getSuccessResultGson(gifService.queryAll(gifInfo));
	}

}
