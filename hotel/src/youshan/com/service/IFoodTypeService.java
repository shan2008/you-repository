package youshan.com.service;

import java.util.List;

import youshan.com.entity.FoodType;

public interface IFoodTypeService {
	
	public FoodType findFoodTypeById(int id); //根据ID查找

	public List<FoodType> findAllFoodTypes(); //查找所有
	
	public void save(FoodType typeName);  //保存菜系
	
	public void deleteFoodTypeById(int id); //根据ID 删除
	
	public FoodType findFoodTypeByName(FoodType typeName); //根据名词查询
	
	public void update(FoodType foodType);//更新
	
	

}
