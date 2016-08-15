package youshan.util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class jdbcUtil {
	private static String url=null;
	private static String userName=null;
	private static String passWord=null;
	private static String driverClass=null;
	
	//��̬��������֮��ͼ���
	static{
	Properties prop=new Properties();
	InputStream in=jdbcUtil.class.getResourceAsStream("/db.properties");
	
		try {
			prop.load(in);
			driverClass=prop.getProperty("driverClass");	
			url=prop.getProperty("url");
			userName=prop.getProperty("userName");
			passWord=prop.getProperty("passWord");
			//���������ṹ������ע��
			Class.forName(driverClass);
			
		} catch (Exception e) {		
			e.printStackTrace();
			throw new RuntimeException();
		} 
	}
	
	public static  Connection getConnection(){
		//ע������
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url,userName, passWord);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return connection;
		
	}
	
	public static void close(Connection connection, Statement statement,ResultSet set)
	{
		
				try {
					if(set!=null)
					  set.close();
					
					if (statement!=null) {
						
						statement.close();
					}
					
					if (connection!=null)
					{		
						connection.close();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException();
				}
					
	}
	
}
