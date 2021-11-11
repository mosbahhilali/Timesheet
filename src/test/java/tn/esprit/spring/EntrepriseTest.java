package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	@Autowired
	EntrepriseServiceImpl ei;
	private static final Logger LOGGER = LogManager.getLogger( EntrepriseTest.class);
	@Test
	public void testajouterEntreprise() throws ParseException
	{
		
		Entreprise ent=new Entreprise("Esprit","Esprit");
		int c= ei.ajouterEntreprise(ent);
		assertThat(c).isGreaterThan(0);
		LOGGER.info("Added successfully with");
		Assert.assertTrue(c>0);
		
	}
	@Test
	public void testListEntreprise() {
		Entreprise en=ei.getEntrepriseById(1);
		
	assertThat(en.getId()>0);
	}
}