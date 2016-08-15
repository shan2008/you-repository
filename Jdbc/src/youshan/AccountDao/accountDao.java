package youshan.AccountDao;


import java.util.List;

import youshan.Daoutil.DaoUtil;
import youshan.entity.Account;

public class accountDao extends DaoUtil {
	
	public void delete(int id){
		String sql="delete from account where id=?";
	    Object[] paraValue={id};
	    super.update(sql, paraValue);
	    
	}
	
	
	//修改要传入id,以及需要修改的东西
	public void update(int id){
		String sql="update account set sname=?where id=?";
	    Object[] paraValue={"you",id};
		super.update(sql, paraValue);	
	}
	
    public void insertData(){
    	String sql="insert into account(id,sname,money) values(?,?,?)";
    	Object[] value={2,"shan",3030.0};
    	super.update(sql, value);	
    	
    }
    
    public List<Account> find(){
    	
    	String sql="select * from account";
    	Object[] value={};
        List<Account> list=super.findAll(sql, value, Account.class);
        return list;
    	
    }
	

}
