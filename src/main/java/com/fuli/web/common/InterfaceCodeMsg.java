/**    
 * @author chenjh  
 * @Description: 接口编码
 * @Package com.weip.law.common   
 * @Title: Constants.java   
 * @date 2016年8月23日 上午9:32:56   
 * @version V1.0 
 * @说明  代码版权归 杭州艮山网络科技有限公司 所有
 */
package com.fuli.web.common;

import java.util.HashMap;

public class InterfaceCodeMsg {

	public static HashMap<String, String> mapCode = new HashMap<String, String>();

	/**
	 * 操作成功
	 */
	public static String SUCCESS_CODE = "100000";

	/**
	 * 操作失败
	 */
	public static String FAILD_CODE = "-100000";
	
	/**
	 * 接口信息不存在
	 */
	public static String INTERFACE_ERROR_CODE = "-100001";
	
	/**
	 * 接口令牌有误
	 */
	public static String INTER_TOKEN_ERROR_CODE = "-100002";
	
	/**
	 * 签名不正确
	 */
	public static String INTER_SIGN_ERROR_CODE = "-100003";
	/**
	 * 没有权限 
	 */
	public static String NOT_RIGHTS_ERROR_CODE = "-100004";
	
	/**
	 * 查询不到数据
	 */
	public static final String NO_DATA = "-9999";

	/**
	 * 用户不存在或密码错误
	 */
	public static String USER_LOGIN_ERROR_CODE = "-1001";

	/**
	 * 插入失败
	 */
	public static final String FAIL_INSERT = "-9998";

	/**
	 * 更新失败
	 */
	public static final String FAIL_UPDATE = "-9997";

	/**
	 * 没有此用户
	 */
	public static final String NO_USER = "-9996";

	/**
	 * 密码错误
	 */
	public static final String ERROR_PWD = "-9995";

	/**
	 * 登录超时
	 */
	public static final String LOGIN_OUT = "-9994";

	/**
	 * 企业ID 不能为空
	 */
	public static final String COMPANY_ID_IS_NULL = "-8996";

	/**
	 * 用户ID 不能为空
	 */
	public static final String USER_ID_IS_NULL = "-8995";

	/**
	 * 律师ID 不能为空
	 */
	public static final String LAWER_ID_IS_NULL = "-8994";

	/**
	 * 平台方ID 不能为空
	 */
	public static final String PLATFORM_USER_ID_IS_NULL = "-8993";
	
	
	/**
	 * 案件分类不能为空
	 */
	public static final String CASE_CATEGORY_IS_NULL = "-8992";
	
	
	/**
	 * 案件编号不能为空
	 */
	public static final String CASE_NO_IS_NULL = "-8991";
	
	static {

		mapCode.put(SUCCESS_CODE, "操作成功");
		mapCode.put(FAILD_CODE, "操作失败");
		mapCode.put(INTERFACE_ERROR_CODE, "接口信息不存在");
		mapCode.put(NO_DATA, "暂无数据");
		mapCode.put(FAIL_INSERT, "添加数据失败");
		mapCode.put(FAIL_UPDATE, "更新失败");
		mapCode.put(USER_LOGIN_ERROR_CODE, "用户不存在或密码错误 ");
		mapCode.put(INTER_TOKEN_ERROR_CODE, "接口令牌有误 ");
		mapCode.put(INTER_SIGN_ERROR_CODE, "签名不正确 ");
		mapCode.put(NOT_RIGHTS_ERROR_CODE, "没有操作权限，请联系管理员 ");
		
		mapCode.put(NO_USER, "用户账号不存在");
		mapCode.put(ERROR_PWD, "密码错误");
		mapCode.put(LOGIN_OUT, "登录超时");

		mapCode.put(COMPANY_ID_IS_NULL, "管理员企业Id不能为空 ");
		mapCode.put(USER_ID_IS_NULL, "userId 不能为空 ");
		mapCode.put(LAWER_ID_IS_NULL, "lawerId 不能为空 ");
		mapCode.put(PLATFORM_USER_ID_IS_NULL, "platformUserId 不能为空 ");
		mapCode.put(CASE_CATEGORY_IS_NULL, "案件分类caseCategory 不能为空 ");
		mapCode.put(CASE_NO_IS_NULL, "案件caseNo 不能为空 ");
	}

}
