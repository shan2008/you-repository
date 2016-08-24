package youshan.com.Dao;

import java.util.List;

import youshan.com.entity.Food;

public interface IFoodDao {
	
      public List<Food> findAllFood(); 
      public Food findFoodById(int id);//���id ����
      public void addFood(Food food);//��Ӳ�
      public void updateFood(Food food);//����
      public void deleteFood(int id);//ɾ���
      public List<Food> findByTypeId(int foodType_id);
 
}
