package youshan.com.Dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import youshan.com.Dao.IFoodDao;
import youshan.com.entity.Food;
import youshan.com.jdbcUtil.jdbcUtil;

public class FoodDao implements IFoodDao {

	@Override
	public List<Food> findAllFood() {
		String sql="select * from food";
		List<Food> list=new ArrayList<Food>();
				try {
					list=jdbcUtil.getQueryRunner().query(sql, new BeanListHandler<Food>(Food.class));
					if(list!=null)
					return list;
					return null;
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			
	}

	@Override
	public Food findFoodById(int id) {
		
		String sql="select * from food where id=?";
		try {
			return jdbcUtil.getQueryRunner().query(sql, new BeanHandler<Food>(Food.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void addFood(Food food) {
		
		String sql="insert into food(foodName,foodType_id,price,vipprice,remark,img) values(?,?,?,?,?,?)";
		Object[] params={food.getFoodName(),food.getFoodType_id(),food.getPrice(),
				food.getVipprice(),food.getRemark(),food.getImg()};
		try {
			jdbcUtil.getQueryRunner().update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public void updateFood(Food food) {
				  
		String sql="update food set foodName=?,foodType_id=?,price=?,vipprice=?,remark=?,img=? where id=?";
		Object[] params={food.getFoodName(),food.getFoodType_id(),food.getPrice(),
				food.getVipprice(),food.getRemark(),food.getImg(),food.getId()};
		try {
			jdbcUtil.getQueryRunner().update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public void deleteFood(int id) {
	
		String sql="delete from food where id=?";
		try {
			jdbcUtil.getQueryRunner().update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public List<Food> findByTypeId(int foodType_id) {
		String sql="select * from food where foodType_id=?";
		try {
		return 	jdbcUtil.getQueryRunner().query(sql,new BeanListHandler<Food>(Food.class),foodType_id);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}
	

}
