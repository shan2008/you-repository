package youshan.com.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import youshan.com.Dao.IFoodTypeDao;
import youshan.com.entity.FoodType;
import youshan.com.jdbcUtil.jdbcUtil;

public class FoodTypeDao implements IFoodTypeDao {

	@Override
	public FoodType findFoodTypeById(int id) {
		String sql="select *from foodType where id=?";
		QueryRunner qr=jdbcUtil.getQueryRunner();
	     try {
	    	 
		return qr.query(sql, new BeanHandler<FoodType>(FoodType.class),id);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}

	@Override
	public List<FoodType> findAllFoodTypes() {
		
		String sql="select * from foodType";
		QueryRunner qr=jdbcUtil.getQueryRunner();
		try {
		return	qr.query(sql, new BeanListHandler<FoodType>(FoodType.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void save(FoodType typeName) {
		
		String sql="insert into foodType(typeName) values(?)";
		QueryRunner qr=jdbcUtil.getQueryRunner();
		try {
			qr.update(sql, typeName.getTypeName());
		} catch (Exception e) {			
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public void deleteFoodTypeById(int id) {
		String sql="delete from foodType where id=?";
		QueryRunner qr=jdbcUtil.getQueryRunner();
		try {
			qr.update(sql,id);
		
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}

	@Override
	public FoodType findFoodTypeByName(FoodType typeName) {
		String sql="select * from foodType where typeName like ?";
		QueryRunner qr=jdbcUtil.getQueryRunner();
		try {
		 return	qr.query(sql, new BeanHandler<FoodType>(FoodType.class), "%"+typeName.getTypeName()+"%");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public void update(FoodType foodType) {
		String sql="update foodType set typeName=? where id=?";
		QueryRunner qr=jdbcUtil.getQueryRunner();
		try {
		 qr.update(sql, foodType.getTypeName(),foodType.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}
	

}
