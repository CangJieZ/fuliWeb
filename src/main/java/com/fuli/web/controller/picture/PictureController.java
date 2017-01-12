package com.fuli.web.controller.picture;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuli.web.controller.BaseController;
import com.fuli.web.pojo.GsonModel;
import com.fuli.web.pojo.PictureInfo;
import com.fuli.web.service.picture.PictureService;

@Controller
@RequestMapping("/picture")
@Scope("prototype")
public class PictureController extends BaseController<PictureInfo>{

	/**  
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	 */
	private static final long serialVersionUID = 6635998108515195816L;
	
	@Autowired
	private PictureService pictureService;

	@RequestMapping(value = "/pictureData")
	public @ResponseBody GsonModel pictureData(HttpServletRequest request,
			PictureInfo hotInfo) {
		return getSuccessResultGson(pictureService.pictureData(hotInfo));
	}

}
