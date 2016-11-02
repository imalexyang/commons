package com.platform.web.common.util;
/**
 *page 分页对象
 *
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version  2013-03-19 11:08:15
 * @see com.benmu.basic.utils.Page
 */
public class Page implements java.io.Serializable{
	public static final int DEFAULT_PAGE_SIZE = 10;
	/** 页码,从1开始 */
	private int pageIndex;
	/** 每页多少行 */
	private int pageSize;
	/** 数据总行数 */
	private int totalCount = 0;
	/** 总共可以分多少页 */
	private int pageCount;
	/**排序方式 desc asc*/
	private String sort;
	/**排序字段*/
	private String order;
	/**第一页 */
	private boolean firstPage=false;
	/**上一页 */
	private boolean hasPrev=false;
	/**下一页 */
	private boolean hasNext=false;
	/**最末页 */
	private boolean lastPage=false;
	

	/**
	 * 分页信息,默认每页20行数据
	 * 
	 * @param pageIndex
	 *            页码,从1开始
	 */
	public Page(int pageIndex) {
		this(pageIndex, DEFAULT_PAGE_SIZE);
	}

	public Page() {

	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * 分页信息
	 * 
	 * @param pageIndex
	 *            页码,从1开始
	 * @param pageSize
	 *            每页多少行,默认为 20
	 */
	public Page(int pageIndex, int pageSize) {
		if (pageIndex < 1)
			pageIndex = 1;
		if (pageSize < 1)
			pageSize = DEFAULT_PAGE_SIZE;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	/**
	 * 获取当前页页码
	 * 
	 * @return
	 */
	public int getPageIndex() {
		if (pageIndex < 1)
		pageIndex = 1;
		if (pageSize < 1)
			pageSize = DEFAULT_PAGE_SIZE;
		return pageIndex;
	}

	/**
	 * 获取每页多少行
	 * 
	 * @return
	 */
	public int getPageSize() {
		if (pageSize == 0)
			pageSize = DEFAULT_PAGE_SIZE;
		return pageSize;
	}

	/**
	 * 获取总共有多少页
	 * 
	 * @return
	 */
	public int getPageCount() {
		
		return pageCount;
	}

	/**
	 * 获取起始行数
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (pageIndex - 1) * pageSize;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 设置总记录数
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		pageCount = totalCount / pageSize
				+ (totalCount % pageSize == 0 ? 0 : 1);
		// 调整页码信息,防止出界
		if (totalCount == 0) {
			if (pageIndex != 1)
				pageIndex = 1;
		} else {
			if (pageIndex > pageCount)
				pageIndex = pageCount;
		}
	}

	
	/**
	 * 是否有数据
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return totalCount == 0;
	}

	/**
	 * 设置页面大小
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 排序方式 desc asc
	 * @return String
	 */
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * 排序字段  例如 id
	 * @return String
	 */
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
/**
 * 是否是第一页
 * @return boolean
 */
	public boolean getFirstPage() {
		if(pageCount>0&&getPageIndex()!=1){
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * 是否有上一页
	 * @return boolean
	 */
	public boolean getHasPrev() {
		if(getPageIndex()>1)
			return true;
		
		return hasPrev;
	}
	/**
	 * 是否是最后一页
	 * @return boolean
	 */
	public boolean getLastPage() {
		if(pageIndex>=pageCount)
			return false;
		return true;
	}

	/**
	 * 是否有下一页
	 * @return boolean
	 */
	public boolean getHasNext() {
		if(pageIndex>(pageCount-1)){
			return false;
		}
		return true;
	}


	
}
