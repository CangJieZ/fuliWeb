package com.fuli.web.pojo;

import java.util.Date;

public class InterfaceInfo {

	private Integer weipId;

	private String accessKey;

	private String account;

	private String pwd;

	private Date addTime;

	private Date modifyTime;

	private String weipName;

	public Integer getWeipId() {
		return weipId;
	}

	public void setWeipId(Integer weipId) {
		this.weipId = weipId;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey == null ? null : accessKey.trim();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd == null ? null : pwd.trim();
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getWeipName() {
		return weipName;
	}

	public void setWeipName(String weipName) {
		this.weipName = weipName == null ? null : weipName.trim();
	}
}