package com.fuli.web.pojo;

public class PageInfo {

	// 總條數
	private Integer pageTotal;
	// 頁大小
	private Integer pageSize;
	// 當前頁
	private Integer currPage;
	//总条数
	private Integer total;

	public PageInfo() {
	}

	public PageInfo(Integer total, Integer pageSize, Integer currPage) {
		super();
		this.total = total;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.pageTotal = getPageTotal();
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageTotal() {
		this.pageTotal = this.total % this.pageSize == 0 ? this.total
				/ this.pageSize : this.total / this.pageSize + 1;
		return this.pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

}
