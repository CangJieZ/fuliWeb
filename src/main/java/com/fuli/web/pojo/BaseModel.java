package com.fuli.web.pojo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "pageSize", "startRow", "totalPage"})
public class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3934577454724851374L;

	/**
	 * 每页大小 默认10条
	 */
	public Integer pageSize = 10;

	/**
	 * 起始页
	 */
	public Integer startRow;

	/**
	 * 总页数
	 */
	public Integer totalPage;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStartRow() {
		return this.startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow * pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

}
