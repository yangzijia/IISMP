package com.rms.page;

/***
 * 方法说明:
 * @author IBird
 * @date 2016/6/3
 */
public class Page {

	//当前第几页
	private int pageNow;
	
	//每页显示多少条记录
	private int pageSize;
	
	//共有多少条记录
	private long totalItemNumber;
	
	


	//需要校验一下
	public int getPageNow() {
		if(pageNow <= 0)
			pageNow = 1;
		
		if(pageNow > getpageCount(totalItemNumber)){
			pageNow = getpageCount(totalItemNumber);
		}
		
		return pageNow;
	}
	
	
	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public long getTotalItemNumber() {
		return totalItemNumber;
	}


	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}


	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}


	//获取总页数
	public int getpageCount(long totalItemNumber){
		
		int totalPageNumber = (int)totalItemNumber / pageSize;
		
		if(totalItemNumber % pageSize != 0){
			totalPageNumber++;
		}
		if(totalPageNumber==0){
			totalPageNumber = 1;
		}
		return totalPageNumber;
	}
	
	
	public boolean isHasNext(){
		if(getPageNow() < getpageCount(totalItemNumber)){
			return true;
		}
		
		return false;
	}
	
	public boolean isHasPrev(){
		if(getPageNow() > 1){
			return true;
		}
		
		return false;
	}
	
	public int getPrevPage(){
		if(isHasPrev()){
			return getPageNow() - 1;
		}
		
		return getPageNow();
	}
	
	public int getNextPage(){
		if(isHasNext()){
			return getPageNow() + 1;
		}
		
		return getPageNow();
	}
}
