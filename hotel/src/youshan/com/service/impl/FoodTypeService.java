package youshan.com.service.impl;

import java.util.List;

import youshan.com.Dao.IFoodTypeDao;
import youshan.com.Dao.impl.FoodTypeDao;
import youshan.com.entity.FoodType;
import youshan.com.service.IFoodTypeService;

public class FoodTypeService  implements IFoodTypeService{
	IFoodTypeDao foodTypeDao=new FoodTypeDao();

	@Override
	public FoodType findFoodTypeById(int id) {
	
		return foodTypeDao.findFoodTypeById(id);
	}

	@Override
	public List<FoodType> findAllFoodTypes() {
	
		List<FoodType> list=foodTypeDao.findAllFoodTypes();
		if(list!=null)
		return list;
		
		return null;
	}

	@Override
	public void save(FoodType typeName) {
		foodTypeDao.save(typeName);
		
	}

	@Override
	public void deleteFoodTypeById(int id) {
		foodTypeDao.deleteFoodTypeById(id);
		
	}

	@Override
	public FoodType findFoodTypeByName(FoodType typeName) {
		   
		return  foodTypeDao.findFoodTypeByName(typeName);
	}

	@Override
	public void update(FoodType foodType) {
		foodTypeDao.update(foodType); 
		
	}
	
	

}
