package com.fuli.web.pojo;

public class JsonUser extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6928172193537089543L;
	private Integer jId;
	 // @JsonIgnore
	private String jName;
	public Integer getjId() {
		return jId;
	}
	public void setjId(Integer jId) {
		this.jId = jId;
	}
	public String getjName() {
		return jName;
	}
	public void setjName(String jName) {
		this.jName = jName;
	}
	
	

}
