package youshan.com.Dao;

import java.util.List;

import youshan.com.entity.DinnerTable;

public interface IDinnerTableDao {
	
	public void addTable(DinnerTable dinnerTable); //��Ӳ���
	public void deleteTable(int id);//ɾ������
	
	public void BookTable(DinnerTable dinnerTable);//Ԥ��
	
	public DinnerTable findTablById(int id); //����id����
	public List<DinnerTable> findAllDinnerTables(); //����ȫ��table
	
	public List<DinnerTable> findAvailableTables();//���ҿ����õĲ���
	
}
