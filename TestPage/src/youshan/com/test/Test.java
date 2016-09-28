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
		  //创建PageBean 对象，然后传入service方法中nuiha
		  PageBean<Account> pb=new PageBean<Account>();
		  pb.setCurrentPage(page);
		  
		  //调用service 
		  accountService.getAll(pb);
		  System.out.println(pb.getPageData());
	   
		
	}

}
