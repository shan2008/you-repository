package youshan.com.service.impl;

import java.util.List;

import youshan.com.Dao.IDinnerTableDao;
import youshan.com.Dao.impl.DinnerTableDao;
import youshan.com.entity.DinnerTable;
import youshan.com.service.IDinnerTableService;

public class DinnerTableService  implements IDinnerTableService{
     IDinnerTableDao dinnerTableDao=new DinnerTableDao();
	
	@Override
	public void addTable(DinnerTable dinnerTable) {
		 dinnerTableDao.addTable(dinnerTable);
		
	}

	@Override
	public void deleteTable(int id) {
		dinnerTableDao.deleteTable(id);
		
	}

	@Override
	public void BookTable(DinnerTable dinnerTable) {
		dinnerTableDao.BookTable(dinnerTable);	
		
	}

	@Override
	public DinnerTable findTablById(int id) {
	
		return dinnerTableDao.findTablById(id);
	}

	@Override
	public List<DinnerTable> findAllDinnerTables() {
		
		return dinnerTableDao.findAllDinnerTables();
	}

	@Override
	public List<DinnerTable> findAvailableTables() {
	
		return dinnerTableDao.findAvailableTables();
	}

	
	
}
