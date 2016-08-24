package youshan.com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;


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
		    *  public List<Food> findAllFood(); //��������
      public Food findFoodById(int id);//���id ����
      public void addFood(Food food);//��Ӳ�
      public void updateFood(Food food);//����
      public void deleteFood(int id);//ɾ���
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
   
	    //�������е�ʳ��
	    public void findAllFood(HttpServletRequest request,HttpServletResponse response){
	    	
	    	 List<Food> list=foodService.findAllFood();//���еĲ�
	    	 System.out.println(list.size());
	    	 request.setAttribute("foodlist", list);
	    	 
	    	 try {
				request.getRequestDispatcher("/sys/foodList.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				
			} 
	    	 
	    }
	    
	    //���id ����
	    public void findFoodById(HttpServletRequest request,HttpServletResponse response){
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	//����
	    	Food food=foodService.findFoodById(id);
	    	//���������
	    	request.setAttribute("food", food);
	    	System.out.println(food.getImg());
	    	//ת��������ҳ��
	    	try {
				request.getRequestDispatcher("sys/updateFood.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	    
	    //��Ӳ�
	    public void addFood(HttpServletRequest request,HttpServletResponse response){
	    	//�����ļ�������
	    	FileItemFactory factory=new DiskFileItemFactory();
	    	//servlet�����ϴ���
	    	ServletFileUpload upload=new ServletFileUpload(factory);
	    	//�����ļ��ϴ���С
	    	upload.setFileSizeMax(1024*1024); //1M;
	    	upload.setSizeMax(1024*1024*100); //�ܹ�100M
	    	upload.setHeaderEncoding("utf-8"); //�����ļ������
	    	
	    	
	    	int id=0;//�����жϵ����ĸ�dao
	    	//�ж��Ƿ�Ϊ�ļ��ϴ�
	    	if(upload.isMultipartContent(request)){
	    		//���ļ��ϴ���ôװ��ΪfileItem ����
	    		try {
					List<FileItem> list=upload.parseRequest(request);
				
					Food food=new Food();
					//�����ж�
					String value=null;
					String content=null;
					for (FileItem fileItem : list) {
						if (fileItem.isFormField()) { //�����ļ��ϴ� 
							 value=fileItem.getFieldName();//��ϵ
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
							
							
							//��������ں��޸ĵ�
							if ("image".equals(value)) {							
								food.setImg(content); //�ȰѲ����ͼƬ��·������
							}
							
							if ("id".equals(value)) {//id ��Ϊ�վ����޸�
								id=Integer.parseInt(content);
								food.setId(id);
							}
							
																		
												
						}else {	
							
							
								String basePath="F:\\hotelpic";							  
								String fileName=fileItem.getName();//�õ��ļ�������
								System.out.println(fileName);
								if (fileName.isEmpty()) {	
									break; //����ǿյĻ�����ôͼƬ��û�иı䣬·���Ͳ���Ҫ���ã���Ϊ�յľ����ø���
								}
								//String uuid=UUID.randomUUID().toString();//���һ������id;
								//fileName=uuid+"#"+fileName;//���ÿһ���ļ�
								File file=new File(basePath, fileName);	
								fileItem.write(file);//д���ļ�
								fileItem.delete();//ɾ����ʱ�ļ�work�е�								
								 //����ͼƬ����ݿ⣬�����·�������ʵ�ʱ�����${pageContext.request.contentPath}
								basePath=basePath.substring(basePath.lastIndexOf("\\")+1);
								System.out.println(basePath);	
								food.setImg(basePath+"/"+fileName);							
								
							
						}
								
					}
					
			 
					if (id!=0) { //��Ϊ������޸�
					   foodService.updateFood(food);	
					 }else {   //Ϊ��������
					    	   foodService.addFood(food); 
						}
			  	  
			request.getRequestDispatcher("FoodTypeServlet?method=foodtype").forward(request, response);;//�ɲ�����ת��findAllgFood
			
		
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
	    				
	    	}
	    					    	
	    }
	    
	    //���²ˣ����ȷ������ϵ�ͼƬ��ɾ��Ȼ����ݿ��е�·��Ҫɾ��
	    public void updateFood(HttpServletRequest request,HttpServletResponse response){
	    	   addFood(request, response);
	    	
	    }
	    
	    //ɾ��˵�ʱ���Ӧ��ͼƬҶ��ɾ��
	    public void deleteFood(HttpServletRequest request,HttpServletResponse response){
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	//�Ȳ�ѯ�õ��ļ�·��
	        Food food=foodService.findFoodById(id);
	        
	        //��ȡ�ļ�ĸ·��
	        String imgurl=food.getImg();
	        imgurl="F:/hotelpic/"+imgurl.substring(imgurl.lastIndexOf("/")+1);
	        System.out.println(imgurl);
	       
	     
	        //ɾ����ݿ��е����
	        foodService.deleteFood(id);
	        //ɾ���Ӧ��ͼƬ
	         
	        File file=new File(imgurl);
	        System.out.println(file);
	        if (file.exists()) {
				file.delete();//�����ھ�ɾ��
			}
	        
	        //���ص��˵��б�
	        findAllFood(request, response);
	    	
	    }
	    
	
	    //���foodType_id ����
	    public void findByTypeId(HttpServletRequest request,HttpServletResponse response){
	    	FoodType foodType=(FoodType) request.getAttribute("foodType");
	    	List<Food> list=foodService.findByTypeId(foodType.getId());
	    	
	    	request.setAttribute("foodType", foodType);
	    	request.setAttribute("foodlist", list);
            //ת��
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
