package youshan.com.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youshan.com.entity.DinnerTable;
import youshan.com.service.IDinnerTableService;
import youshan.com.service.impl.DinnerTableService;

public class DinnerTableServlet extends HttpServlet {
	
	  IDinnerTableService dinnerTableService=new DinnerTableService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		   request.setCharacterEncoding("utf-8");//设置服务器解码格式 只对post 有效
		   response.setContentType("text/html;charset=utf-8");//指定浏览器解析格式
		   String method=request.getParameter("method");
		   System.out.println(method);
		   if ("addTable".equals(method)) {
			  addTable(request, response);   
			
		   }
		   
		   if("deleteTable".equals(method)){
			   deleteTable(request, response);
		   }
		   
		   if("BookTable".equals(method)){
               
			   BookTable(request, response);
		   }
		   
		   if("findTableById".equals(method)){
			    
			   findTableById(request, response);
		   }
		   
		   if("findAllDinnerTables".equals(method)){
			   findAllDinnerTables(request, response);
			   
		   }
		   
		   if("findAvailableTables".equals(method)){
			   findAvailableTables(request, response);
		   }
		

	}
	
	 //添加
	 public void addTable(HttpServletRequest request,HttpServletResponse response){
		    String tableName=request.getParameter("tableName"); //别的默认为空
		    System.out.println(tableName);
		    DinnerTable dinnerTable=new DinnerTable();
		    dinnerTable.setTableName(tableName);
		    dinnerTableService.addTable(dinnerTable);	    
		    //添加成功跳转到findll;
		    findAllDinnerTables(request, response);
					 
	 }
	  
	 //删除
	 public void deleteTable(HttpServletRequest request,HttpServletResponse response){
		 int id=Integer.parseInt(request.getParameter("id"));
		 dinnerTableService.deleteTable(id);
		 findAllDinnerTables(request, response);
		 
	 }
	 
	 //预定退桌
	 
	 public void BookTable(HttpServletRequest request,HttpServletResponse response){
		 
		   int id =Integer.parseInt(request.getParameter("id"));
	        DinnerTable dinnerTable=dinnerTableService.findTablById(id);
	        if(dinnerTable.getTableStatus()==1)//退桌
		      {    
		        	dinnerTable.setTableStatus(0); //状态清零
		        	dinnerTable.setOrderDate(null);//时间清零
		      }else{  //状态为零就是预定
		 		
		    	  dinnerTable.setTableStatus(1); //状态设置为1
		    	  Date date=new Date();
		    	  dinnerTable.setOrderDate(date);//时间清零
			    }
	        
	        //修改数据库
	        dinnerTableService.BookTable(dinnerTable);
	        //跳转到List方法
	        findAllDinnerTables(request, response);
	        
		 
	 }
	 
	 //根据id查找
    public void findTableById(HttpServletRequest request,HttpServletResponse response){
    	
    	
     } 
    
    public void findAllDinnerTables(HttpServletRequest request,HttpServletResponse response){
    	    
    	  List<DinnerTable> dinnerTables=dinnerTableService.findAllDinnerTables();
    	  System.out.println(dinnerTables.size());
    	  request.setAttribute("dinnerTables", dinnerTables);
    	  
    	  //重定向
    	  try {
			request.getRequestDispatcher("/sys/boardList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }
	 
	 
	 public void findAvailableTables(HttpServletRequest request,HttpServletResponse response){
		 
		  List<DinnerTable>list=dinnerTableService.findAvailableTables();
		  System.out.println(list.size());
		  request.setAttribute("tables", list); 
		  try {
			request.getRequestDispatcher("/app/detail/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	 }
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		   this.doPost(request, response);
	}


}
