package youshan.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class provinceCity extends HttpServlet {

	/**
	 城市连动框
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		String city=request.getParameter("province");
		System.out.println(city);
		
		PrintWriter writer=response.getWriter();
		writer.write("<?xml version='1.0' encoding='UTF-8'?>");
		writer.write("<root>");
		
		if ("湖北".equals(city)) {
			writer.write("<city>武汉</city>");
			writer.write("<city>襄阳</city>");
			writer.write("<city>宜昌</city>");
			writer.write("<city>荆州</city>");
		}else if ("广东".equals(city)) {
			writer.write("<city>广州</city>");
			writer.write("<city>深圳</city>");
			writer.write("<city>东莞</city>");
			writer.write("<city>汕头</city>");		
		}
	
		writer.write("</root>");
		writer.flush();
		writer.close();
		
		
	}

}
