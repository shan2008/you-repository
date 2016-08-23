package youshan.com.Dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import youshan.com.Dao.IDinnerTableDao;
import youshan.com.entity.DinnerTable;
import youshan.com.jdbcUtil.jdbcUtil;

public class DinnerTableDao  implements IDinnerTableDao{

	@Override
	public void addTable(DinnerTable dinnerTable) {
		  String sql="insert into dinnerTable( tableName,tableStatus,orderDate ) values(?,?,?)";
		  try {
			jdbcUtil.getQueryRunner().update(sql,
					  dinnerTable.getTableName(),dinnerTable.getTableStatus(),dinnerTable.getOrderDate());
		} catch (Exception e) {
	      e.printStackTrace();
		}
		 
		
	}

	@Override
	public void deleteTable(int id) {
		String sql="delete from dinnerTable where id=?";
		try {
			jdbcUtil.getQueryRunner().update(sql, id);
		} catch (Exception e) {		
		    e.printStackTrace();
		}
		
	}

	@Override
	public void BookTable(DinnerTable dinnerTable) {
		  String sql="update dinnerTable set tableStatus=?,orderDate=? where id=?";
		  try {
			jdbcUtil.getQueryRunner().update(sql,dinnerTable.getTableStatus(),dinnerTable.getOrderDate(),dinnerTable.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		
		
	}

	@Override
	public DinnerTable findTablById(int id) {
	
		String sql="select * from dinnerTable where id=?";
		try {
			return jdbcUtil.getQueryRunner().query(sql, new BeanHandler<DinnerTable>(DinnerTable.class),id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}

	@Override
	public List<DinnerTable> findAllDinnerTables() {

	   String sql="select * from dinnerTable";
	   List<DinnerTable> list=new ArrayList<DinnerTable>();
	   try {
		   list=jdbcUtil.getQueryRunner().query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class));
		   if(list!=null)	   
			 return list;
		   
		     return null;
	
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException();
	}
	   
	 
	}

	@Override
	public List<DinnerTable> findAvailableTables() {
		
		String sql="select * from dinnerTable where tableStatus=0";
		List<DinnerTable> list=new ArrayList<DinnerTable>();
		try {
			list=jdbcUtil.getQueryRunner().query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list!=null)
		 return list;
		
		return null;
		
	}
	

}
