package youshan.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class provinceCity extends HttpServlet {

	/**
	 ����������
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
		
		if ("����".equals(city)) {
			writer.write("<city>�人</city>");
			writer.write("<city>����</city>");
			writer.write("<city>�˲�</city>");
			writer.write("<city>����</city>");
		}else if ("�㶫".equals(city)) {
			writer.write("<city>����</city>");
			writer.write("<city>����</city>");
			writer.write("<city>��ݸ</city>");
			writer.write("<city>��ͷ</city>");		
		}
	
		writer.write("</root>");
		writer.flush();
		writer.close();
		
		
	}

}
