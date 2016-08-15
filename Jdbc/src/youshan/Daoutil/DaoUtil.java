package youshan.Daoutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import youshan.util.jdbcUtil;

public class DaoUtil {
	private static Connection connection=null; 
	private static PreparedStatement  p_state=null;
	
	//不论哪个方法都要用到创建连接 所以写子啊静态代码块中
	static{
		connection=jdbcUtil.getConnection();	
	}
	
	
	//插入删除修改
	public  void update(String sql,Object[] paraValue)
	{ 
		 
		try {
			 p_state=(PreparedStatement) connection.prepareStatement(sql);
			//设置sql语句的值
			if (paraValue!=null) {
				//通过参数元数据能到参数个数
				int count=p_state.getParameterMetaData().getParameterCount();
				for(int i=0;i<count;i++)
				{
					p_state.setObject(i+1, paraValue[i]);
					
				}							
			}
			
			//为空就直接执行
			p_state.executeUpdate();
			jdbcUtil.close(connection,p_state, null);
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
				
	}
	
	//查询 
	
	public <T> List<T> findAll(String sql,Object[] paraValue,Class<T>clazz){
		
		//List 用于保存t对象
		List<T> list=new ArrayList<>();
		T t=null;
	  ResultSet set=null;
		
		
		try {
			//获取p_state
			p_state=(PreparedStatement) connection.prepareStatement(sql);
			
			//获取占位符的个数
			if(paraValue!=null)
			{
			    int count=p_state.getParameterMetaData().getParameterCount();
			    for(int i=0;i<count;i++)
			    {
			    	p_state.setObject(i+1, paraValue[i]);
			    }
			   
			}
			
   //执行sql并获取结果街;
     set=p_state.executeQuery();
  
  //获取元数据的列的个数
	 ResultSetMetaData re=(ResultSetMetaData) p_state.getMetaData();
    int colum=re.getColumnCount();//获取元数据的个
     while (set.next()) {
	    	// 封装到对象中
			 t=clazz.newInstance();
			for(int i=0;i<colum;i++)
			{
				
				//数据库的各个字段的名字要和对象的属性一样
				String columName=re.getColumnName(i+1);//获取列的值；
				//取出的值，用object
				Object obj=set.getObject(columName);
				//beanUtil 封装数据
				BeanUtils.copyProperty(t, columName, obj);  	
			}
			
			//查询的第一个数据完毕，要添加带List中
			 list.add(t);
     }
     
     }catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			
			jdbcUtil.close(connection, p_state, set);
		}
	  	
		return list;
	}
	

}
