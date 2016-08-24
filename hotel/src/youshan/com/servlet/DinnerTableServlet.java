package youshan.com.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
		 
		   request.setCharacterEncoding("utf-8");//���÷����������ʽ ֻ��post ��Ч
		   response.setContentType("text/html;charset=utf-8");//ָ�������������ʽ
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
	
	 //���
	 public void addTable(HttpServletRequest request,HttpServletResponse response){
		    String tableName=request.getParameter("tableName"); //���Ĭ��Ϊ��
		    System.out.println(tableName);
		    DinnerTable dinnerTable=new DinnerTable();
		    dinnerTable.setTableName(tableName);
		    dinnerTableService.addTable(dinnerTable);	    
		    //��ӳɹ���ת��findll;
		    findAllDinnerTables(request, response);
					 
	 }
	  
	 //ɾ��
	 public void deleteTable(HttpServletRequest request,HttpServletResponse response){
		 int id=Integer.parseInt(request.getParameter("id"));
		 dinnerTableService.deleteTable(id);
		 findAllDinnerTables(request, response);
		 
	 }
	 
	 //Ԥ������
	 
	 public void BookTable(HttpServletRequest request,HttpServletResponse response){
		 
		   int id =Integer.parseInt(request.getParameter("id"));
	        DinnerTable dinnerTable=dinnerTableService.findTablById(id);
	        if(dinnerTable.getTableStatus()==1)//����
		      {    
		        	dinnerTable.setTableStatus(0); //״̬����
		        	dinnerTable.setOrderDate(null);//ʱ������
		      }else{  //״̬Ϊ�����Ԥ��
		 		
		    	  dinnerTable.setTableStatus(1); //״̬����Ϊ1
		    	  Date date=new Date();
		    	  dinnerTable.setOrderDate(date);//ʱ������
			    }
	        
	        //�޸���ݿ�
	        dinnerTableService.BookTable(dinnerTable);
	        //��ת��List����
	        findAllDinnerTables(request, response);
	        
		 
	 }
	 
	 //���id����
    public void findTableById(HttpServletRequest request,HttpServletResponse response){
    	
    	
     } 
    
    public void findAllDinnerTables(HttpServletRequest request,HttpServletResponse response){
    	    
    	  List<DinnerTable> dinnerTables=dinnerTableService.findAllDinnerTables();
    	  System.out.println(dinnerTables.size());
    	  request.setAttribute("dinnerTables", dinnerTables);
    	  
    	  //�ض���
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
