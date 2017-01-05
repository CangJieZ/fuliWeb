package com.fuli.web.common.exception;

public class ColumCheckException extends RuntimeException {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 4330048511180682283L;

	@Deprecated
	public ColumCheckException() {
		super();
	}

	/**
	 * 
	 * 构造函数
	 * 
	 * @param errorCode
	 *            错误码
	 * @param errorMsg
	 *            错误信息
	 * 
	 */
	public ColumCheckException(String errorMsg) {
		super(errorMsg);
	}

}
