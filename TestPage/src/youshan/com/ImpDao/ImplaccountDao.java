package youshan.com.ImpDao;

import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import youshan.com.Dao.accountDao;
import youshan.com.entity.Account;
import youshan.com.utils.PageBean;
import youshan.com.utils.jdbcUtils;

public class ImplaccountDao implements accountDao<Account> {
	
	@Override
	public void getAll(PageBean<Account> pb) {
	//1.��ȡ��ǰҳ�������ѯ����ʵ�У�������
	int currentPage=pb.getCurrentPage();
	int startPage=(currentPage-1)*pb.getPageCount();
	
	int count=pb.getPageCount(); //4��
	
	//2.��ѯ�ܼ�
	int totalCount=this.getTotalCount();//������ܼ�¼
	pb.setTotalPage(totalCount); //������ҳ��
	
	//3��ҳ��ѯ���ݣ����ݷ���pb
	String sql="select * from account limit ?,?";
	//�õ�quer ����
	QueryRunner qr=jdbcUtils.getQueryRunner();
    List<Account> list;
	try {
		 list = qr.query(sql, new BeanListHandler<Account>(Account.class), startPage,count);
		 pb.setPageData(list);
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException();
	}
   
			
	}

	@Override
	public int getTotalCount() {
		String sql="select count(*) from account";
		try {
			QueryRunner qr=jdbcUtils.getQueryRunner();
			Long count=qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();//ת��������
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		

	}
	
	

}
