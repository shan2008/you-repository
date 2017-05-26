package youshan.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class timeServlet2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//web1.0 Í¬²½
        response.setContentType("html/text;charset=utf-8");		
		SimpleDateFormat spf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	    String str=spf.format(new Date());
	    request.setAttribute("time", str);
	    
	    request.getRequestDispatcher("/index1.jsp").forward(request, response);
		
		
	}

}
