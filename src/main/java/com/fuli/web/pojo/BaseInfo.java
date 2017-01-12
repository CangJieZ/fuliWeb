package com.fuli.web.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fuli.web.common.Constants;

@JsonIgnoreProperties(value = { "pageSize", "startPage"})
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
			return Constants.PAGE_SIZE;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}	
