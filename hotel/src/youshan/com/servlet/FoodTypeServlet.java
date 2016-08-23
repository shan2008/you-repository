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
		
		  request.setCharacterEncoding("utf-8");//设置服务器解码格式 只对post 有效
		  response.setContentType("text/html;charset=utf-8");//指定浏览器解析格式
		  String method=request.getParameter("method");
		  System.out.println(method);
		  if("addFoodType".equals(method))
		  {	   
			  //添加详细菜系
			  addFoodType(request,response);
			  
		  }
		  
		  if("listFoodType".equals(method)){
			  
			  //菜系展示
			listFoodType(request, response);
		  }
		  
		  
		  if("findById".equals(method)){
			  //根据id查找
			 findById(request, response); 
		  }
		  
		  if("updateFoodTypeName".equals(method)){
			  //更新
			  updateFoodTypeName(request, response);
		  }
		  
		   //删除
		  if("deleteFoodTypeById".equals(method)){
			  	  
			  deleteFoodTypeById(request, response);
		  }
		  
		  //添加修改菜的时候加载菜系
		  if("findAllFoodType".equals(method)){
			  
			 findAllFoodType(request, response);
		  }
		  
		  //查询到菜系
		  if ("foodtype".equals(method)) {
			  foodtype(request, response);		
		}
		  
		  if("findFoodTypeByName".equals(method)){
			findFoodTypeByName(request, response);
		  }
		  
	}

	  //添加菜系
	  public void addFoodType(HttpServletRequest request,HttpServletResponse response){
		  
		     try {
				String typeName=request.getParameter("typeName");
				System.out.println(typeName);
				
				 FoodType foodType=new FoodType();
				 foodType.setTypeName(typeName);
				 foodTypeService.save(foodType);
				 //正常执行
				  uri=request.getContextPath()+"/FoodTypeServlet?method=listFoodType";
				 
			} catch (Exception e) {
				  e.printStackTrace();
				  uri=request.getContextPath()+"/commom/error.jsp";
				
			}finally{
				
				  //跳转到listfoodType用重定向比较好URL 地址栏给变给用户提醒	     
			     try {
					response.sendRedirect(uri);
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
				
			}
		     
		     
	  }
	  
	  //菜系列表
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
				
				 //用转发
			    try {
					 request.getRequestDispatcher(uri).forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			    
			}
		    
		   
		    
		  
		  
	  }
	
	  
	  //更新页面
	   public void updateFoodTypeName(HttpServletRequest request,HttpServletResponse response){
		       // 获取请求参数
		   int id=Integer.parseInt(request.getParameter("id"));
		   String typeName=request.getParameter("typeName");
		   try {
			   FoodType foodType=new FoodType();
			   foodType.setId(id);
			   foodType.setTypeName(typeName);	   
			   foodTypeService.update(foodType);
			   //跳转
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
	   
	   
	   //通过id 查找   
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
	   
	   
	   //删除菜系
	   public void deleteFoodTypeById(HttpServletRequest request,HttpServletResponse response){
		   
			    int id=Integer.parseInt(request.getParameter("id"));
			    System.out.println(id);
			    foodTypeService.deleteFoodTypeById(id);		    
			    //重定向到list
                listFoodType(request, response);
			    	   
	   }
	  
	   public  void findAllFoodType(HttpServletRequest request,HttpServletResponse response){
		  String id=request.getParameter("id");
		  
		  String uri="sys/saveFood.jsp";
		   //用于添加菜的时候加载菜系
		  List<FoodType> list=foodTypeService.findAllFoodTypes();
		  request.setAttribute("foodType", list);
		  if(id!=null) //参数不为空转发到foodServlet
		  uri="FoodServlet?method=findFoodById&id="+id;
			
		  try {
			request.getRequestDispatcher(uri).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		  
	   }
	   	   
	   public void foodtype(HttpServletRequest request,HttpServletResponse response){
		    //用于显示，因为这个dao 不可以外键查询封装的数据
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
		   foodType=foodTypeService.findFoodTypeByName(foodType); //得到id;
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
