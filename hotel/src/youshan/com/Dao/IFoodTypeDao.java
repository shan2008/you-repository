package youshan.com.Dao;

import java.util.List;

import youshan.com.entity.FoodType;

public interface IFoodTypeDao {
	
	
	public FoodType findFoodTypeById(int id); //����ID����

	public List<FoodType> findAllFoodTypes(); //��������
	
	public void save(FoodType typeName);  //�����ϵ
	
	public void deleteFoodTypeById(int id); //����ID ɾ��
	
	public FoodType findFoodTypeByName(FoodType typeName); //�������ʲ�ѯ
	
	public void update(FoodType foodType);//����
	

}