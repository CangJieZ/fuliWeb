/**    
 * @author chenjh  
 * @Description: 签名处理  
 * @Package com.weip.law.common.utils   
 * @Title: SignUtil.java   
 * @date 2016年8月26日 上午9:16:50   
 * @version V1.0 
 * @说明  代码版权归 杭州艮山网络科技有限公司 所有
 */ 
package com.fuli.web.common.utils;

import java.util.Map;

import com.fuli.web.common.InterfaceCodeMsg;
import com.fuli.web.common.exception.BOException;


public class SignUtil {
	
	
	/**
	 * @Auther: chenjh  
	 * @Description: 核验签名
	 * @Date:2016年8月26日上午9:17:53
	 * @param map
	 * @return  
	 * @return boolean 
	 * @说明  代码版权归 杭州艮山网络科技有限公司 所有
	 */
	public  static boolean checkSign(Map<String, String[]> map,String excludeParams){
		boolean result = false;
		try {
			String paramStr = MapParameterUtil.getParametStringArray(map,excludeParams);
			String oldSign = map.get("fuli")[0];
			String newSign = MD5Util.Md5(paramStr, "utf-8");
			result = oldSign.equals(newSign);
		} catch (Exception e) {
			throw new BOException(InterfaceCodeMsg.INTER_SIGN_ERROR_CODE);
		}
		return result;
	}

}
