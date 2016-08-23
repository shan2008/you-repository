package youshan.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youshan.com.entity.FoodType;
import youshan.com.service.IFoodTypeService;
import youshan.com.service.impl.FoodService;
import youshan.com.service.impl.FoodTypeService;

public class FoodTypeServlet extends HttpServlet {

	private IFoodTypeService foodTypeService=new FoodTypeService();
	private String uri="";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  request.setCharacterEncoding("utf-8");//���÷����������ʽ ֻ��post ��Ч
		  response.setContentType("text/html;charset=utf-8");//ָ�������������ʽ
		  String method=request.getParameter("method");
		  System.out.println(method);
		  if("addFoodType".equals(method))
		  {	   
			  //�����ϸ��ϵ
			  addFoodType(request,response);
			  
		  }
		  
		  if("listFoodType".equals(method)){
			  
			  //��ϵչʾ
			listFoodType(request, response);
		  }
		  
		  
		  if("findById".equals(method)){
			  //����id����
			 findById(request, response); 
		  }
		  
		  if("updateFoodTypeName".equals(method)){
			  //����
			  updateFoodTypeName(request, response);
		  }
		  
		   //ɾ��
		  if("deleteFoodTypeById".equals(method)){
			  	  
			  deleteFoodTypeById(request, response);
		  }
		  
		  //����޸Ĳ˵�ʱ����ز�ϵ
		  if("findAllFoodType".equals(method)){
			  
			 findAllFoodType(request, response);
		  }
		  
		  //��ѯ����ϵ
		  if ("foodtype".equals(method)) {
			  foodtype(request, response);		
		}
		  
		  if("findFoodTypeByName".equals(method)){
			findFoodTypeByName(request, response);
		  }
		  
	}

	  //��Ӳ�ϵ
	  public void addFoodType(HttpServletRequest request,HttpServletResponse response){
		  
		     try {
				String typeName=request.getParameter("typeName");
				System.out.println(typeName);
				
				 FoodType foodType=new FoodType();
				 foodType.setTypeName(typeName);
				 foodTypeService.save(foodType);
				 //����ִ��
				  uri=request.getContextPath()+"/FoodTypeServlet?method=listFoodType";
				 
			} catch (Exception e) {
				  e.printStackTrace();
				  uri=request.getContextPath()+"/commom/error.jsp";
				
			}finally{
				
				  //��ת��listfoodType���ض���ȽϺ�URL ��ַ��������û�����	     
			     try {
					response.sendRedirect(uri);
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
				
			}
		     
		     
	  }
	  
	  //��ϵ�б�
	  public void listFoodType(HttpServletRequest request,HttpServletResponse response){
		  
		    try {
				List<FoodType> list=foodTypeService.findAllFoodTypes();
				System.out.println(list);
				request.setAttribute("list_foodType", list);
				uri="sys/cuisineList.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				uri="/commom/error.jsp";
			}finally{
				
				 //��ת��
			    try {
					 request.getRequestDispatcher(uri).forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			    
			}
		    
		   
		    
		  
		  
	  }
	
	  
	  //����ҳ��
	   public void updateFoodTypeName(HttpServletRequest request,HttpServletResponse response){
		       // ��ȡ�������
		   int id=Integer.parseInt(request.getParameter("id"));
		   String typeName=request.getParameter("typeName");
		   try {
			   FoodType foodType=new FoodType();
			   foodType.setId(id);
			   foodType.setTypeName(typeName);	   
			   foodTypeService.update(foodType);
			   //��ת
			   uri=request.getContextPath()+"/FoodTypeServlet?method=listFoodType";
		   } catch (Exception e){
			   e.printStackTrace();
			   uri=request.getContextPath()+"sys/cuisineList.jsp";
		  }finally{
			  	  
					  try {
						response.sendRedirect(uri);
					} catch (Exception e) {
					     e.printStackTrace();
					}
			  		  
		  }	   
	   }
	   
	   
	   //ͨ��id ����   
	   public void findById(HttpServletRequest request,HttpServletResponse response){
		        int id=Integer.parseInt(request.getParameter("id"));
				FoodType foodType=foodTypeService.findFoodTypeById(id);
				System.out.println(foodType.getTypeName());
				
				request.setAttribute("foodType", foodType);
				try {
					request.getRequestDispatcher("/sys/updateCuisine.jsp").forward(request, response);
				}  catch (Exception e) {
					e.printStackTrace();
				}
			   	   
	   }
	   
	   
	   //ɾ����ϵ
	   public void deleteFoodTypeById(HttpServletRequest request,HttpServletResponse response){
		   
			    int id=Integer.parseInt(request.getParameter("id"));
			    System.out.println(id);
			    foodTypeService.deleteFoodTypeById(id);		    
			    //�ض���list
                listFoodType(request, response);
			    	   
	   }
	  
	   public  void findAllFoodType(HttpServletRequest request,HttpServletResponse response){
		  String id=request.getParameter("id");
		  
		  String uri="sys/saveFood.jsp";
		   //������Ӳ˵�ʱ����ز�ϵ
		  List<FoodType> list=foodTypeService.findAllFoodTypes();
		  request.setAttribute("foodType", list);
		  if(id!=null) //������Ϊ��ת����foodServlet
		  uri="FoodServlet?method=findFoodById&id="+id;
			
		  try {
			request.getRequestDispatcher(uri).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		  
	   }
	   	   
	   public void foodtype(HttpServletRequest request,HttpServletResponse response){
		    //������ʾ����Ϊ���dao �����������ѯ��װ������
		   List<FoodType> list=foodTypeService.findAllFoodTypes();
		   request.setAttribute("foodType", list); 	   
		   try {
			request.getRequestDispatcher("FoodServlet?method=findAllFood").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();		
		}
	   }
	   
	   
	   public void findFoodTypeByName(HttpServletRequest request,HttpServletResponse response){
		   String typeName=request.getParameter("typeName");
		   System.out.println(typeName);
		   
		   FoodType foodType=new FoodType();
		   foodType.setTypeName(typeName);
		   foodType=foodTypeService.findFoodTypeByName(foodType); //�õ�id;
		   request.setAttribute("foodType", foodType);
		   try {
			request.getRequestDispatcher("FoodServlet?method=findByTypeId").forward(request, response);
		}  catch (Exception e) {
			e.printStackTrace();
			
		}
		   
		   
	   }
	   
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  this.doPost(request, response);
	}


}
