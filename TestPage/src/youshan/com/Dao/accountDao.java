package youshan.com.Dao;
import youshan.com.utils.PageBean;

/*
 * 
 * 数据访问层的设计接口
 */

public interface accountDao<T> {
	
		/*
		 * 分页查询的数据
		 */
		public void getAll(PageBean<T> pb);
		
		/*
		 * 查询送记录
		 */
		public int getTotalCount();

}
