package youshan.com.utils;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcUtils {
	
 private  static DataSource dataSource=null;
 
 static{
	  dataSource=new ComboPooledDataSource();//��ʼ��
 }
 
public static QueryRunner getQueryRunner(){
	//ʹ��querRunner��ʱ��������������ӳض��� ʹ��query �Ͳ���Ҫ��
	QueryRunner  qr=new QueryRunner(dataSource);
	return  qr;
}



}
