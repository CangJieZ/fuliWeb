package com.fuli.web.pojo;

public class BaseInfo {

	Integer startPage;
	
	Integer pageSize;

	public Integer getStartPage() {
		if (null == startPage) {
			return 0;
		}
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getPageSize() {
		if (null == startPage) {
			return 10;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}	
