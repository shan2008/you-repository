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
	
	//�����ĸ�������Ҫ�õ��������� ����д�Ӱ���̬�������
	static{
		connection=jdbcUtil.getConnection();	
	}
	
	
	//����ɾ���޸�
	public  void update(String sql,Object[] paraValue)
	{ 
		 
		try {
			 p_state=(PreparedStatement) connection.prepareStatement(sql);
			//����sql����ֵ
			if (paraValue!=null) {
				//ͨ������Ԫ�����ܵ���������
				int count=p_state.getParameterMetaData().getParameterCount();
				for(int i=0;i<count;i++)
				{
					p_state.setObject(i+1, paraValue[i]);
					
				}							
			}
			
			//Ϊ�վ�ֱ��ִ��
			p_state.executeUpdate();
			jdbcUtil.close(connection,p_state, null);
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
				
	}
	
	//��ѯ 
	
	public <T> List<T> findAll(String sql,Object[] paraValue,Class<T>clazz){
		
		//List ���ڱ���t����
		List<T> list=new ArrayList<>();
		T t=null;
	  ResultSet set=null;
		
		
		try {
			//��ȡp_state
			p_state=(PreparedStatement) connection.prepareStatement(sql);
			
			//��ȡռλ���ĸ���
			if(paraValue!=null)
			{
			    int count=p_state.getParameterMetaData().getParameterCount();
			    for(int i=0;i<count;i++)
			    {
			    	p_state.setObject(i+1, paraValue[i]);
			    }
			   
			}
			
   //ִ��sql����ȡ�����;
     set=p_state.executeQuery();
  
  //��ȡԪ���ݵ��еĸ���
	 ResultSetMetaData re=(ResultSetMetaData) p_state.getMetaData();
    int colum=re.getColumnCount();//��ȡԪ���ݵĸ�
     while (set.next()) {
	    	// ��װ��������
			 t=clazz.newInstance();
			for(int i=0;i<colum;i++)
			{
				
				//���ݿ�ĸ����ֶε�����Ҫ�Ͷ��������һ��
				String columName=re.getColumnName(i+1);//��ȡ�е�ֵ��
				//ȡ����ֵ����object
				Object obj=set.getObject(columName);
				//beanUtil ��װ����
				BeanUtils.copyProperty(t, columName, obj);  	
			}
			
			//��ѯ�ĵ�һ��������ϣ�Ҫ��Ӵ�List��
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
