package youshan.com.test;
import youshan.com.entity.Account;
import youshan.com.service.AccountService;
import youshan.com.service.ImpService;
import youshan.com.utils.PageBean;

public class Test {
	
   @org.junit.Test
	public void test(){
	   AccountService accountService=new ImpService();
	   
	      String currPage="2";	   	
		  int page=Integer.parseInt(currPage);
		  //����PageBean ����Ȼ����service������nuiha
		  PageBean<Account> pb=new PageBean<Account>();
		  pb.setCurrentPage(page);
		  
		  //����service 
		  accountService.getAll(pb);
		  System.out.println(pb.getPageData());
	   
		
	}

}
