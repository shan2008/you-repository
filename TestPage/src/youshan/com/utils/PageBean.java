package youshan.com.utils;

import java.util.List;

/*
 * ���b퓔�
 * 
 */
public class PageBean<T> {
	private int currentPage=1;//��ǰҳ��
	private int pageCount=4;//ÿҳ������
	private int totalCount;//�ܼ�¼
	private int totalPage;//��ҳ��ѯ������
	private List<T> pageData; //��ѯ������
	

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

	//��������߼������ҳ��
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
		//ͬʱ������ҳ��
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
