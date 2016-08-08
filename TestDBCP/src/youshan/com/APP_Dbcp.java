package youshan.com;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;


public class APP_Dbcp {

	@Test //硬编码方式
	public void testDbcp(){
	
		//Dbcp连接池的核心类
		BasicDataSource dataSouce=new BasicDataSource();
		
		//连接参数配置：初始化连接数，做到连接数，连接字符串，驱动，用户密码
		dataSouce.setUrl("jdbc:mysql://localhost:3306/student");
		dataSouce.setDriverClassName("com.mysql.jdbc.Driver");
		dataSouce.setUsername("root");
		dataSouce.setPassword("root");
		dataSouce.setInitialSize(3); //初始化连接
		dataSouce.setMaxActive(6); //最大连接个数
		dataSouce.setMaxIdle(3000); //最大空闲时间,长时间不用连接自动关闭
		
		//获取连接
		try {
			Connection connection=dataSouce.getConnection();
			connection.prepareStatement("select *from account where id=2").execute();
			//关闭连接
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}	
	}
	
	//配置方式实现连接池
	@Test
	public void testDbcp2() throws Exception{
		//根据prop配置文件
		Properties prop= new Properties();
		InputStream inputStream=APP_Dbcp.class.getResourceAsStream("/db.properties");
		prop.load(inputStream);
		 
		//获取Source
	     DataSource	dataSource= BasicDataSourceFactory.createDataSource(prop);
	      //获取连接
	     Connection connection=dataSource.getConnection();
	     PreparedStatement pr=null;
	     
	    
	     for(int i=0;i<20;i++)
		 {
	    	 String sql="insert into account(id,sname,money) values(?,?,?)";
		 	 pr=connection.prepareStatement(sql);
		 	 
		     pr.setInt(1, i);
		     pr.setString(2, "you"+i);
		     pr.setDouble(3, i+1000);
		     
		     pr.executeUpdate();
	     }
	     
	     pr.close();
	     connection.close();
	 	
	} 
	
	@Test
	public void test2(){
	
		String str=new String("中国");
		String str2=new String("中国");
		System.out.println(str.hashCode());
		System.out.println(str2.hashCode());
		
	}
	
	
	
}
