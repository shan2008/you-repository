package youshan.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.commons.dbutils.ResultSetHandler;

import youshan.com.entity.Account;
import youshan.com.service.AccountService;
import youshan.com.service.ImpService;
import youshan.com.utils.PageBean;


public class DisplayServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			response.setContentType("text/html;charset=utf-8");	
			  
			AccountService accountService=new ImpService();
			  //����ǵ�һ�η��ʣ���ǰҳΪ��
			  String currPage=request.getParameter("currPage");	   
			  if(currPage==null){
				  currPage="1"; 
			  }
			  int page=Integer.parseInt(currPage);
			 
			  //����PageBean ����Ȼ����service������
			  PageBean<Account> pb=new PageBean<Account>();
			  
			  if(page<1)
			  {
				  pb.setCurrentPage(1);
			  }else if (page>5) 
			  {	  
				  pb.setCurrentPage(5);
			      
			  }else {
				  pb.setCurrentPage(page);  	
			} 
			  accountService.getAll(pb);	 
			  //�������ݵ������
			  request.setAttribute("pageBean", pb);
			 
			  request.getRequestDispatcher("/list.jsp").forward(request, response);
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doGet(request, response);
	}

}
