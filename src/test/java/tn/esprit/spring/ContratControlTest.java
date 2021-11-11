package tn.esprit.spring;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratControlTest {
	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	ContratRepository contratRepoistory;
	private static final Logger LOGGER = LogManager.getLogger( ContratControlTest.class);
	@Test
	public void testajouterContrat() throws ParseException
	{
		try
		{
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date d=dateFormat.parse("2021-10-10");
		int c= iemployeservice.ajouterContrat(new Contrat(d,"cdi",1000));
		LOGGER.info("Added successfully");
		assertThat(c).isGreaterThan(0);
		iemployeservice.deleteContratById(c);

	}
	catch (Exception e) { LOGGER.error("Problem encountred : " + e); }
		
	}
	@Test
	public void testaffecterContratAEmploye() throws ParseException
	{
	
		Employe e,eee;
		int a;
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		try
		{
		Date d=dateFormat.parse("2021-10-10");
		Contrat c=new Contrat(d,"cdi",1000);
		int cc= iemployeservice.ajouterContrat(c);
		e=new Employe("nom","prenom","nom.prenom@esprit.tn",true,Role.INGENIEUR);
		int ee=iemployeservice.ajouterEmploye(e);
		int ccc=iemployeservice.affecterContratAEmploye(cc, ee);
		LOGGER.info("affected successfully");
		assertThat(ccc).isEqualTo(ee);
		iemployeservice.deleteContratById(cc);
		}
		catch (Exception e1) { LOGGER.error("Problem encountred : " + e1); }
		
	}
	@Test
	public void testdeleteContratById()
	{
		try
		{
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date d=dateFormat.parse("2021-10-10");
		int c= iemployeservice.ajouterContrat(new Contrat(d,"cdi",1000));
		iemployeservice.deleteContratById(c);
		LOGGER.info("deleted successfully");
		assertThat(contratRepoistory.findById(c).orElse(null)).isEqualTo(null);
	}
	catch (Exception e) { LOGGER.error("Problem encountred : " + e); 
	}
	}
	@Test
	public void testdeleteAllContratJPQL()
	{
		
		try
		{
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date d=dateFormat.parse("2021-10-10");
		iemployeservice.ajouterContrat(new Contrat(d,"cdi",1000));
		iemployeservice.deleteAllContratJPQL();
		LOGGER.info("deleted successfully");
		assertThat(contratRepoistory.findAll()).isEqualTo(new ArrayList());
	}
	catch (Exception e) { LOGGER.error("Problem encountred : " + e); 
	}
	}

}
