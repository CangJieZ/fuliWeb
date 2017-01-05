/**    
 * @author chenjh  
 * @Description: 接口全局参数信息
 * @Package com.weip.law.pojo   
 * @Title: InterPojo.java   
 * @date 2016年8月25日 下午4:32:59   
 * @version V1.0 
 * @说明  代码版权归 杭州艮山网络科技有限公司 所有
 */ 
package com.fuli.web.pojo;

import java.io.Serializable;




public class InterPojo implements Serializable{

	
	private static final long serialVersionUID = 6824587812595844258L;
	
	
	private Integer userId;
	
	/**
	 * 接口令牌
	 */
	private String accessKey;
	
	
	private String t;
	
	/**
	 * 签名串
	 */
	
	private String weip;


	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getAccessKey() {
		return getT();
	}


	public String getWeip() {
		return weip;
	}

	public void setWeip(String weip) {
		this.weip = weip;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	
	
	
	
	
	
}
