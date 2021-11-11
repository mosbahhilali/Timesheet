package tn.esprit.spring;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeSheetTest {
	
	@Autowired
	ITimesheetService it;
	@Autowired
	EmployeServiceImpl iEmployeService;
	
	private static final Logger LOGGER = LogManager.getLogger(TimeSheetTest.class);
	
	@Test
	public void testAjouterTimesheet()
	{
		
		
	}
	
	@Test
	public void testValiderTimesheet()
	{
		
	}

}
