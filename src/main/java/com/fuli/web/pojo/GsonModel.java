package com.fuli.web.pojo;

import java.io.Serializable;
import java.util.List;
/**
 * json 返回模型
 * @author chenjh
 *
 */
public class GsonModel implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -1819081826606955120L;

	/**
     * 返回码
     */
    private String code;

    /**
     * 返回码说明内容
     */
    private String msg;

    /**
     * 数据内容
     */
    private List<? extends Object> content;
    
	@Override
    public String toString() {
        return "GsonModel{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
	public List<? extends Object> getContent() {
		return content;
	}

	public void setContent(List<? extends Object> content) {
		this.content = content;
	}

	public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
