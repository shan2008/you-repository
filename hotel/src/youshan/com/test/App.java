package youshan.com.test;



import java.util.Date;

import org.junit.Test;

import youshan.com.entity.DinnerTable;
import youshan.com.service.IDinnerTableService;
import youshan.com.service.impl.DinnerTableService;

public class App {
	
	@Test
	public void testApp(){
		
		IDinnerTableService dinnerTableService=new DinnerTableService();  
		
		System.out.println(dinnerTableService.findAllDinnerTables());
		
		
	}

}
