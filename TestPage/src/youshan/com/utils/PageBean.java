package youshan.com.utils;

import java.util.List;

/*
 * 封裝頁數
 * 
 */
public class PageBean<T> {
	private int currentPage=1;//当前页书
	private int pageCount=4;//每页的行数
	private int totalCount;//总记录
	private int totalPage;//分页查询的数据
	private List<T> pageData; //查询的数据
	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	//并且在里边计算出了页数
	public int getTotalCount() {
			
		return totalCount;
		
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalCount) {
		//同时设置了页数
				if(totalCount%pageCount==0)
				{
				 totalPage=totalCount/pageCount;
				}else{
					
					 totalPage=totalCount/pageCount+1;	
				}
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
	

}
