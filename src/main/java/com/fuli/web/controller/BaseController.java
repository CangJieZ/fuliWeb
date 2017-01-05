/**    
 * @author maomy  
 * @Description: 控制器父类   
 * @Package com.chenjh.cz.controller   
 * @Title: BaseController.java   
 * @date 2016-3-3 上午11:46:30   
 * @version V1.0 
 */
package com.fuli.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.fuli.web.common.InterfaceCodeMsg;
import com.fuli.web.common.utils.StringUtil;
import com.fuli.web.pojo.GsonModel;

public class BaseController<T> implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = -8757960194328510249L;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;

	/**
	 * ModelAttribute 的作用 1)放置在方法的形参上：表示引用Model中的数据
	 * 2)放置在方法上面：表示请求该类的每个Action前都会首先执行它， 也可以将一些准备数据的操作放置在该方法里面。
	 * 
	 * */
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/**
	 * 默认成功信息
	 * 
	 * @return
	 */
	public GsonModel getSuccessResultGson() {
		GsonModel gson = new GsonModel();
		gson.setCode(InterfaceCodeMsg.SUCCESS_CODE);
		gson.setMsg(InterfaceCodeMsg.mapCode.get(InterfaceCodeMsg.SUCCESS_CODE));
		// gson.setContent(content);
		return gson;
	}

	/**
	 * 自定义成功信息
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public GsonModel getSuccessResultGson(String code, String msg) {
		GsonModel gson = new GsonModel();
		gson.setCode(code);
		gson.setMsg(msg);
		// gson.setContent(content);
		return gson;
	}

	/**
	 * 成功返回数据
	 * 
	 * @param list
	 * @return
	 */
	public GsonModel getSuccessResultGson(List<T> list) {
		List<T> listBase = new ArrayList<T>();
		listBase.addAll(list);
		GsonModel gson = new GsonModel();
		gson.setCode(InterfaceCodeMsg.SUCCESS_CODE);
		gson.setMsg(InterfaceCodeMsg.mapCode.get(InterfaceCodeMsg.SUCCESS_CODE));
		gson.setContent(listBase);
		return gson;
	}

	public GsonModel getSuccessResultGson(GsonModel gson) {
		if (StringUtil.isEmpty(gson.getCode())) {
			gson.setCode(InterfaceCodeMsg.SUCCESS_CODE);
		}
		gson.setMsg(InterfaceCodeMsg.mapCode.get(gson.getCode()));
		return gson;
	}

	/**
	 * 成功返回数据
	 * 
	 * @param list
	 * @return
	 */
	public GsonModel getSuccessResultGson(T t) {
		List<T> listBase = new ArrayList<T>();
		listBase.add(t);
		GsonModel gson = new GsonModel();
		gson.setCode(InterfaceCodeMsg.SUCCESS_CODE);
		gson.setMsg(InterfaceCodeMsg.mapCode.get(InterfaceCodeMsg.SUCCESS_CODE));
		gson.setContent(listBase);
		return gson;
	}

	/**
	 * 失败返回信息
	 * 
	 * @return
	 */
	public GsonModel getFaildResultGson() {
		GsonModel gson = new GsonModel();
		gson.setCode(InterfaceCodeMsg.FAILD_CODE);
		gson.setMsg(InterfaceCodeMsg.mapCode.get(InterfaceCodeMsg.FAILD_CODE));
		// gson.setContent(content);
		return gson;
	}

	/**
	 * 失败返回信息
	 * 
	 * @return
	 */
	public GsonModel getFaildResultGson(String code, String msg) {
		GsonModel gson = new GsonModel();
		gson.setCode(code);
		gson.setMsg(msg);
		// gson.setContent(content);
		return gson;
	}

}
