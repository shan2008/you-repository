package youshan.com.Dao;

import java.util.List;

import youshan.com.entity.Food;

public interface IFoodDao {
	
      public List<Food> findAllFood(); //查找所有
      public Food findFoodById(int id);//根据id 查找
      public void addFood(Food food);//添加菜
      public void updateFood(Food food);//更新
      public void deleteFood(int id);//删除菜
      public List<Food> findByTypeId(int foodType_id);
 
}
