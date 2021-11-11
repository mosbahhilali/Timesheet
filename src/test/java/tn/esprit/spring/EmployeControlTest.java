package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeControlTest {
	@Autowired
	EmployeServiceImpl es;
	

	private static final Logger LOGGER = LogManager.getLogger( EntrepriseTest.class);
	
	@Test
	public void testajouterEmploye() throws ParseException
	{
		
		Employe e=new Employe("aymen","melki","aymen.melk@esprit.tn",true,Role.ADMINISTRATEUR);
		int c= es.ajouterEmploye(e);
		assertThat(c).isGreaterThan(0);
		LOGGER.info("Added successfully Employee");
		Assert.assertTrue(c>0);
		
	}
	
	@Test
	public void testListEmploye() {
	//List<Employe> e = (List<Employe>) es.findAll();
		List<Employe> e=es.getAllEmployes();
		int n=e.size();
	assertThat(n>0);
	}
	
	
	
	
	
}