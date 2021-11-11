package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@RestController
public class RestControlContrat {
	
	@Autowired
	IEmployeService iemployeservice;
	
	
	
	@PostMapping("/ajouterContrat1")
	@ResponseBody
	public int ajouterContrat(@RequestBody Contrat contrat) {
		iemployeservice.ajouterContrat(contrat);
		return contrat.getReference();
	}
	
	@PutMapping(value = "/affecterContratAEmploye1/{idcontrat}/{idemp}") 
	public void affecterContratAEmploye(@PathVariable("idcontrat")int contratId, @PathVariable("idemp")int employeId)
	{
		iemployeservice.affecterContratAEmploye(contratId, employeId);
	}
	
	@DeleteMapping("/deleteContratById1/{idcontrat}") 
	@ResponseBody
	public void deleteContratById(@PathVariable("idcontrat")int contratId) {
		iemployeservice.deleteContratById(contratId);
	}
	
	   @DeleteMapping("/deleteAllContratJPQL1") 
		@ResponseBody
		public void deleteAllContratJPQL() {
		   iemployeservice.deleteAllContratJPQL();
			
		}
}
