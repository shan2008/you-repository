package youshan.com.Dao;
import youshan.com.utils.PageBean;

/*
 * 
 * ���ݷ��ʲ����ƽӿ�
 */

public interface accountDao<T> {
	
		/*
		 * ��ҳ��ѯ������
		 */
		public void getAll(PageBean<T> pb);
		
		/*
		 * ��ѯ�ͼ�¼
		 */
		public int getTotalCount();

}
