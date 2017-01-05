package com.fuli.web.common.exception;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;



/**
 * 全局系统异常拦截处理类
 * @author chenjh
 *
 */
public class MaomyExceptionResolver implements HandlerExceptionResolver{
	
	
	private Log log = LogFactory.getLog(MaomyExceptionResolver.class);

	
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception ex) {
		 //handler为当前处理器适配器执行的对象
        String message = null;
        String code = "-999";
        //判断是否为系统自定义异常。
        if(ex instanceof BaseRuntimeException) {
            message = ((BaseRuntimeException) ex).getMessage();
            code = ((BaseRuntimeException) ex).getErrorCode();
        }else {
            message = "系统出错啦，稍后再试试！";
        }
        
        //捕获到的异常写入日志
        log.error("code="+code+" ; msg="+message, ex);
        
        ModelAndView mv = new ModelAndView();  
        /*  使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常   */  
       /* FastJsonJsonView view = new FastJsonJsonView();  
        Map<String, Object> attributes = new HashMap<String, Object>();  
        attributes.put("code", code);  
        attributes.put("msg", message);  
        view.setAttributesMap(attributes);  
        mv.setView(view);   
        return  mv;*/
        
        
        ModelAndView modelAndView = new ModelAndView();
        //跳转到相应的处理页面
        modelAndView.addObject("errorMsg", message);//出错的信息
        modelAndView.setViewName("globalerror");//出错的页面
        
        return modelAndView;
		
	}

}
