package com.platform.web.common.util;

public class PageAndOrder {
	private String fieldName;
	private boolean isAsc;	
	
	private String order; //"asc" or "desc"
	private String orderBy; //sort by which filed

	private static final int MAX_ROW_COUNT = 9999999;
	private int maxRowCount = MAX_ROW_COUNT;
	private int startRow;
	private int endRow;
	private int pageSize = 10;
	private int currPage = 1;
	private int totalPages;
	private int totalRecords;

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartRow() {
		return pageSize * (currPage - 1);
	}

	public int getEndRow() {
		return pageSize * currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize >= 50) {
			this.pageSize = 50;
		} else if (pageSize < 50 && pageSize >= 25){
			this.pageSize = 25;
		}else if(pageSize==5){
			this.pageSize = 5;	
		}else{
			this.pageSize = 10;			
		}
		
		if (currPage * pageSize > maxRowCount) {
			setCurrPage(maxRowCount / pageSize);
		}
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		if (currPage > 0) {
			if (currPage * pageSize > maxRowCount)
				this.currPage = maxRowCount / pageSize;
			else
				this.currPage = currPage;
		} else {
			this.currPage = 1;
		}
	}

	public void setOrder(String fieldName, boolean isAsc) {
		this.fieldName = fieldName;
		this.isAsc = isAsc;
	}

	public String getFieldName() {
		return fieldName;
	}

	public boolean isAsc() {
		return isAsc;
	}
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getMaxRowCount() {
		return maxRowCount;
	}
}