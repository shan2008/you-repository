package youshan.com.Dao;

import java.util.List;

import youshan.com.entity.DinnerTable;

public interface IDinnerTableDao {
	
	public void addTable(DinnerTable dinnerTable); //添加餐桌
	public void deleteTable(int id);//删除餐桌
	
	public void BookTable(DinnerTable dinnerTable);//预定
	
	public DinnerTable findTablById(int id); //根据id查找
	public List<DinnerTable> findAllDinnerTables(); //查找全部table
	
	public List<DinnerTable> findAvailableTables();//查找可利用的餐桌
	
}
