package tn.esprit.spring;


import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;
 
@SpringBootTest
public class ContratControlTest {
	@Autowired
	IEmployeService iemployeservice;
	
	@Test(expected=NullPointerException.class)
	public void testajouterContrat() throws ParseException
	{
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date d=dateFormat.parse("2021-10-10");
		int c= iemployeservice.ajouterContrat(new Contrat(d,"cdi",1000));
		assertThat(c).isGreaterThan(0);
		Assert.assertTrue(c>0);
		
	}
	@Test(expected=NullPointerException.class)
	public void testaffecterContratAEmploye() throws ParseException
	{

		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date d=dateFormat.parse("2021-10-10");
		Contrat c=new Contrat(d,"cdi",1000);
		int cc= iemployeservice.ajouterContrat(c);
		Employe e=new Employe("nom","prenom","nom.prenom@esprit.tn",true,Role.INGENIEUR);
		int ee=iemployeservice.ajouterEmploye(e);
		iemployeservice.affecterContratAEmploye(cc, ee);
		Assert.assertEquals(c.getEmploye(),e);
	
	}
	@Test
	public void testdeleteContratById()
	{
		
		
	}
	@Test
	public void testdeleteAllContratJPQL()
	{
		
	}

}
