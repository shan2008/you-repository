package youshan.com.service;

import youshan.com.Dao.accountDao;
import youshan.com.ImpDao.ImplaccountDao;
import youshan.com.entity.Account;
import youshan.com.utils.PageBean;
public class ImpService  implements AccountService<Account>{

	 accountDao<Account> account=new ImplaccountDao();
	
	@Override 
	public void getAll(PageBean<Account> pb) {
		account.getAll(pb);

	}

}
