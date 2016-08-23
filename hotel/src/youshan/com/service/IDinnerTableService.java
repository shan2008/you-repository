package youshan.com.service;

import java.util.List;

import youshan.com.entity.DinnerTable;
import youshan.com.entity.FoodType;

public interface IDinnerTableService {

	public void addTable(DinnerTable dinnerTable); //��Ӳ���
	public void deleteTable(int id);//ɾ������
	
	public void BookTable(DinnerTable dinnerTable);//Ԥ��
	public DinnerTable findTablById(int id); //����id����
	public List<DinnerTable> findAllDinnerTables(); //����ȫ��table
	public List<DinnerTable> findAvailableTables();//���ҿ����õĲ���
}
