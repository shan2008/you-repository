package youshan.test;

import java.util.List;

import org.junit.Test;

import youshan.AccountDao.accountDao;
import youshan.entity.Account;

public class TestDao {

	@Test
	public void test(){
		accountDao dao=new accountDao();
		List<Account> list=dao.find();
		
		//���
		for (Account account: list) {
			System.out.println(account);
		}
		
	}
	
	
}
