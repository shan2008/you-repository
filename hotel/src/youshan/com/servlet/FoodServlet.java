package youshan.com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import youshan.com.entity.Food;
import youshan.com.entity.FoodType;
import youshan.com.service.IFoodService;
import youshan.com.service.IFoodTypeService;
import youshan.com.service.impl.FoodService;
import youshan.com.service.impl.FoodTypeService;

public class FoodServlet extends HttpServlet {

	IFoodService foodService=new FoodService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   request.setCharacterEncoding("utf-8");
		   response.setContentType("text/html;charset=utf-8");
		   String method=request.getParameter("method");
		   /*
		    * 
		    *  public List<Food> findAllFood(); //查找所有
      public Food findFoodById(int id);//根据id 查找
      public void addFood(Food food);//添加菜
      public void updateFood(Food food);//更新
      public void deleteFood(int id);//删除菜
		    */
		   
		   if("findAllFood".equals(method)){
			   
			   findAllFood(request,response);
		   }
		   
		   if("findFoodById".equals(method)){
			   findFoodById(request, response);
		   }
		   
		   if ("addFood".equals(method)) {
			   addFood(request, response);
		   }
		   
		   if ("updateFood".equals(method)) {
			  updateFood(request, response);
		   }
		  
		   if("deleteFood".equals(method)){
			  deleteFood(request, response);
		   }
		   
		   if ("findByTypeId".equals(method)) {
			   System.out.println("findByTypeId");
			   findByTypeId(request, response);
			
		}

	
	}
   
	    //查找所有
	    public void findAllFood(HttpServletRequest request,HttpServletResponse response){
	    	
	    	 List<Food> list=foodService.findAllFood();//所有的菜
	    	 System.out.println(list.size());
	    	 request.setAttribute("foodlist", list);
	    	 
	    	 try {
				request.getRequestDispatcher("/sys/foodList.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				
			} 
	    	 
	    }
	    
	    //根据id 查找
	    public void findFoodById(HttpServletRequest request,HttpServletResponse response){
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	//查找
	    	Food food=foodService.findFoodById(id);
	    	//放入域对象
	    	request.setAttribute("food", food);
	    	System.out.println(food.getImg());
	    	//转发到更新页面
	    	try {
				request.getRequestDispatcher("sys/updateFood.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	    
	    //添加菜
	    public void addFood(HttpServletRequest request,HttpServletResponse response){
	    	//创建文件工厂类
	    	FileItemFactory factory=new DiskFileItemFactory();
	    	//servlet核心上传类
	    	ServletFileUpload upload=new ServletFileUpload(factory);
	    	//设置文件上传大小
	    	upload.setFileSizeMax(1024*1024); //1M;
	    	upload.setSizeMax(1024*1024*100); //总共100M
	    	upload.setHeaderEncoding("utf-8"); //设置文件名编码
	    	
	    	
	    	int id=0;//用于判断调用哪个dao
	    	//判断是否为文件上传
	    	if(upload.isMultipartContent(request)){
	    		//是文件上传那么装换为fileItem 集合
	    		try {
					List<FileItem> list=upload.parseRequest(request);
				
					Food food=new Food();
					//单项判断
					String value=null;
					String content=null;
					for (FileItem fileItem : list) {
						if (fileItem.isFormField()) { //不是文件上传 
							 value=fileItem.getFieldName();//菜系
							 content=fileItem.getString("utf-8");
							System.out.println(value);
							System.out.println(content);
							
							if("foodType_id".equals(value)){
								int foodType_id=Integer.parseInt(content);
								food.setFoodType_id(foodType_id);							
							  }
							
							if ("foodName".equals(value)) {
								food.setFoodName(content);			
							}
							
							if("price".equals(value)){
								food.setPrice(Double.parseDouble(content));
							}
							
							if("vipprice".equals(value)){
								food.setVipprice(Double.parseDouble(content));
							}
							
							if("remark".equals(value)){
								food.setRemark(content);
							}
							
							
							//下面的是融合修改的
							if ("image".equals(value)) {							
								food.setImg(content); //先把不更改图片的路径设置
							}
							
							if ("id".equals(value)) {//id 不为空就是修改
								id=Integer.parseInt(content);
								food.setId(id);
							}
							
																		
												
						}else {	
							
							
								String basePath="F:\\hotelpic";							  
								String fileName=fileItem.getName();//得到文件的名字
								System.out.println(fileName);
								if (fileName.isEmpty()) {	
									break; //如果是空的话，那么图片就没有改变，路径就不需要设置，不为空的就设置覆盖
								}
								//String uuid=UUID.randomUUID().toString();//生成一个随机的id;
								//fileName=uuid+"#"+fileName;//区别每一个文件
								File file=new File(basePath, fileName);	
								fileItem.write(file);//写入文件
								fileItem.delete();//删除临时文件work中的								
								 //保存图片到数据库，用相对路径，访问的时候加上${pageContext.request.contentPath}
								basePath=basePath.substring(basePath.lastIndexOf("\\")+1);
								System.out.println(basePath);	
								food.setImg(basePath+"/"+fileName);							
								
							
						}
								
					}
					
			 
					if (id!=0) { //不为零就是修改
					   foodService.updateFood(food);	
					 }else {   //为零就是添加
					    	   foodService.addFood(food); 
						}
			  	  
			request.getRequestDispatcher("FoodTypeServlet?method=foodtype").forward(request, response);;//由菜谱跳转到findAllgFood
			
		
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
	    				
	    	}
	    					    	
	    }
	    
	    //更新菜，首先服务器上的图片宴删除，然后数据库中的路径要删除
	    public void updateFood(HttpServletRequest request,HttpServletResponse response){
	    	   addFood(request, response);
	    	
	    }
	    
	    //删除菜的时候对应的图片叶涛删除
	    public void deleteFood(HttpServletRequest request,HttpServletResponse response){
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	//先查询得到文件路径
	        Food food=foodService.findFoodById(id);
	        
	        //获取文件母路径
	        String imgurl=food.getImg();
	        imgurl="F:/hotelpic/"+imgurl.substring(imgurl.lastIndexOf("/")+1);
	        System.out.println(imgurl);
	       
	     
	        //删除数据库中的数据
	        foodService.deleteFood(id);
	        //删除对应的图片
	         
	        File file=new File(imgurl);
	        System.out.println(file);
	        if (file.exists()) {
				file.delete();//如果存在就删除
			}
	        
	        //返回到菜的列表
	        findAllFood(request, response);
	    	
	    }
	    
	
	    //根据foodType_id 查找
	    public void findByTypeId(HttpServletRequest request,HttpServletResponse response){
	    	FoodType foodType=(FoodType) request.getAttribute("foodType");
	    	List<Food> list=foodService.findByTypeId(foodType.getId());
	    	
	    	request.setAttribute("foodType", foodType);
	    	request.setAttribute("foodlist", list);
            //转发
	    	try {
				request.getRequestDispatcher("sys/searchfoodList.jsp").forward(request,response);
			}  catch (Exception e) {
				e.printStackTrace();
				
			}
	    	 
	    	
	    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
		  this.doPost(request, response);
	}

	
}
