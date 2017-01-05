package com.fuli.web.common.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.fuli.web.common.InterfaceCodeMsg;

/**
 * 
 * @author chenjh
 * @Description: 全局异常处理类
 * @ClassName: WeIpHandlerExceptionResolver.java
 * @date 2016年8月23日 上午11:11:18
 * @说明 代码版权归 杭州山网络科技有限公司 所有
 */
public class WeIpHandlerExceptionResolver extends
		DefaultHandlerExceptionResolver {

	private Log log = LogFactory.getLog(WeIpHandlerExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// 异常编码
		String code = InterfaceCodeMsg.FAILD_CODE;
		// 提示内容
		String message = "";
		// 判断是否为系统自定义异常。
		if (ex instanceof BaseRuntimeException) {
			// 全部抛出来的异常只有异常代码(除了系统异常)
			code = ((BaseRuntimeException) ex).getMessage();
			message = InterfaceCodeMsg.mapCode.get(code);
		} else if (ex instanceof MissingServletRequestParameterException) {// 字段校验异常（系统异常）
			String exmsg = ((MissingServletRequestParameterException) ex)
					.getMessage();
			String param = exmsg.substring(exmsg.indexOf(" '") + 2,
					exmsg.lastIndexOf("' "));
			message = param + " 参数不能为空!";
		} else if (ex instanceof ColumCheckException) {
			message = ((ColumCheckException) ex).getMessage();
			code = InterfaceCodeMsg.FAILD_CODE;
		} else {
			message = "系统出错啦，稍后再试试！";
		}

		// 捕获到的异常写入日志
		log.error("code= " + code + " ; msg=" + message, ex);

		ModelAndView mv = new ModelAndView();
		/* 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常 */
		FastJsonJsonView view = new FastJsonJsonView();
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("code", code);
		attributes.put("msg", message);
		attributes.put("content", "");
		view.setAttributesMap(attributes);
		mv.setView(view);
		return mv;
	}

}
