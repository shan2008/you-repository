package youshan.com.service.impl;

import java.util.List;

import youshan.com.Dao.IFoodDao;
import youshan.com.Dao.impl.FoodDao;
import youshan.com.entity.Food;
import youshan.com.service.IFoodService;

public class FoodService implements IFoodService{

	 IFoodDao foodDao=new FoodDao();
	@Override
	public List<Food> findAllFood() {
		
		return foodDao.findAllFood();
	}

	@Override
	public Food findFoodById(int id) {
	
		return foodDao.findFoodById(id);
	}

	@Override
	public void addFood(Food food) {
	   foodDao.addFood(food);	
	}

	@Override
	public void updateFood(Food food) {
	
	   foodDao.updateFood(food);	
	}

	@Override
	public void deleteFood(int id) {
		foodDao.deleteFood(id);
	}

	@Override
	public List<Food> findByTypeId(int foodType_id) {
		
		return foodDao.findByTypeId(foodType_id);
	}
	

}
