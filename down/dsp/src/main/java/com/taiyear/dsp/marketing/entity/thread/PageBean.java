package com.taiyear.dsp.marketing.entity.thread;
/**
 * 
 * @author nwang
 *
 */
public class PageBean {
	private int currentPage;
	private int totalPage;
	private final int pageSize = 10;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

}
