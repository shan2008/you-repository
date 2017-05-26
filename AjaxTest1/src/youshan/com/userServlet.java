package youshan.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userServlet extends HttpServlet {

	/**
	 *用户名检查
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  
		   response.setContentType("text/html;charset=utf-8");
		    
		    String userString=request.getParameter("userName");
		    //重新解码
		    userString=new String(userString.getBytes("ISO-8859-1"),"utf-8");
		    String tip="<font color='green'>可以注册</font>";
		    if ("杰克".equals(userString)) {
		    	tip="<font color='red'>用户名已经存在</font>";
				
			}
		    
		  PrintWriter writer=response.getWriter();
		  writer.write(tip);
		  writer.flush();
		  writer.close();		    
		    
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		    request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    
		    String userName=request.getParameter("userName");
		    System.out.print(userName);
		    
		    String image="images/MsgSent.gif";
		    if ("杰克".equals(userName)) {		
		    	image="images/MsgError.gif";
			}
		    
		    //发送
		    PrintWriter writer=response.getWriter();
		    writer.write(image);
		    writer.flush();
		    writer.close();
	    	 			
	}

}
