package youshan.com.service;

import youshan.com.utils.PageBean;

/*
 * 业务逻辑层接口设计
 */

public interface AccountService<T> {
	/*
	 * 分页查询
	 */
	public void getAll(PageBean<T> pb);
	
}
