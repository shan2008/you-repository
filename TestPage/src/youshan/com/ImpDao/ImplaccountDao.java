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
	//1.获取当前页，计算查询的其实行，返回行
	int currentPage=pb.getCurrentPage();
	int startPage=(currentPage-1)*pb.getPageCount();
	
	int count=pb.getPageCount(); //4行
	
	//2.查询总记
	int totalCount=this.getTotalCount();//求出了总记录
	pb.setTotalPage(totalCount); //设置总页数
	
	//3分页查询数据，数据放在pb
	String sql="select * from account limit ?,?";
	//得到quer 对象
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
			return count.intValue();//转换成整型
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		

	}
	
	

}
