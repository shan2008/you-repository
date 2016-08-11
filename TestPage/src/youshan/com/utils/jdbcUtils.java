package youshan.com.utils;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcUtils {
	
 private  static DataSource dataSource=null;
 
 static{
	  dataSource=new ComboPooledDataSource();//初始化
 }
 
public static QueryRunner getQueryRunner(){
	//使用querRunner的时候如果传入了连接池对象 使用query 就不需要了
	QueryRunner  qr=new QueryRunner(dataSource);
	return  qr;
}



}
