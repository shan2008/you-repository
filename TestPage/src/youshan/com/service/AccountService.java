package youshan.com.service;

import youshan.com.utils.PageBean;

/*
 * ҵ���߼���ӿ����
 */

public interface AccountService<T> {
	/*
	 * ��ҳ��ѯ
	 */
	public void getAll(PageBean<T> pb);
	
}
