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

	@Test //Ӳ���뷽ʽ
	public void testDbcp(){
	
		//Dbcp���ӳصĺ�����
		BasicDataSource dataSouce=new BasicDataSource();
		
		//���Ӳ������ã���ʼ���������������������������ַ������������û�����
		dataSouce.setUrl("jdbc:mysql://localhost:3306/student");
		dataSouce.setDriverClassName("com.mysql.jdbc.Driver");
		dataSouce.setUsername("root");
		dataSouce.setPassword("root");
		dataSouce.setInitialSize(3); //��ʼ������
		dataSouce.setMaxActive(6); //������Ӹ���
		dataSouce.setMaxIdle(3000); //������ʱ��,��ʱ�䲻�������Զ��ر�
		
		//��ȡ����
		try {
			Connection connection=dataSouce.getConnection();
			connection.prepareStatement("select *from account where id=2").execute();
			//�ر�����
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}	
	}
	
	//���÷�ʽʵ�����ӳ�
	@Test
	public void testDbcp2() throws Exception{
		//����prop�����ļ�
		Properties prop= new Properties();
		InputStream inputStream=APP_Dbcp.class.getResourceAsStream("/db.properties");
		prop.load(inputStream);
		 
		//��ȡSource
	     DataSource	dataSource= BasicDataSourceFactory.createDataSource(prop);
	      //��ȡ����
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
	
		String str=new String("�й�");
		String str2=new String("�й�");
		System.out.println(str.hashCode());
		System.out.println(str2.hashCode());
		
	}
	
	
	
}
