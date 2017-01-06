package com.fuli.web.common.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fuli.web.common.InterfaceCodeMsg;
import com.fuli.web.common.context.CacheContext;
import com.fuli.web.common.exception.BaseRuntimeException;
import com.fuli.web.common.utils.SignUtil;
import com.fuli.web.common.utils.StringUtil;
import com.fuli.web.dao.InterDao;
import com.fuli.web.pojo.InterInfo;

/**
 * @author chenjh
 * @Description: 统一接口拦截器
 * @ClassName: InterfaceInterceptor.java
 * @date 2016年8月22日 下午1:49:24
 * @说明 代码版权归 杭州山网络科技有限公司 所有
 */
public class InterfaceInterceptor implements HandlerInterceptor {
	private Log log = LogFactory.getLog(InterfaceInterceptor.class);
	
	@Autowired
	private InterDao interDao;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		// request 里可以获取参数
		String url = request.getRequestURI();
		boolean isLogin = false;
		
		if (url.indexOf("login") > 0) {
			isLogin = true;
		}
		System.out.println(" InterfaceInterceptor 拦截到的url = " + url);
		//写日志
		log.error(" InterfaceInterceptor 拦截到的url = " + url);
		//参数检查
		checkGlobalParames(request.getParameterMap(),isLogin);
		return true;
	}


	/**
	 * @Auther: chenjh  
	 * @Description: 校验全局参数
	 * @Date:2016年8月25日下午4:43:41
	 * @param map  
	 * @param isLogin  
	 * @return void 
	 * @说明  代码版权归 杭州艮山网络科技有限公司 所有
	 */
	private void checkGlobalParames(Map<String, String[]> map,boolean isLogin) {
		if (null == map || map.size() <= 0 )
			throw new BaseRuntimeException(InterfaceCodeMsg.INTERFACE_ERROR_CODE);
		//获取token对象
		String token = map.get("token")[0];
		//令牌
		if(!checkAccessKey(token))
			throw new BaseRuntimeException(InterfaceCodeMsg.INTER_TOKEN_ERROR_CODE);
		//签名
		if(!isLogin && null == token || !SignUtil.checkSign(map, "fuli"))
			throw new BaseRuntimeException(InterfaceCodeMsg.INTER_SIGN_ERROR_CODE);
		
	}

	
	/**
	 * @Auther: chenjh  
	 * @Description: accessKey 校验
	 * @Date:2016年8月29日下午1:44:25
	 * @param accessKey
	 * @return  
	 * @return boolean 
	 * @说明  代码版权归 杭州艮山网络科技有限公司 所有
	 */
	private boolean checkAccessKey(String token){
		String key = (String)CacheContext.get(token);
		if(StringUtil.isEmpty(key)){
			InterInfo w = interDao.selectByToken(token);
			if(null != w)
				CacheContext.set(token, w.getProject());
			else
				return false;
		}else 
			return true;
		return true;
	}


	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
