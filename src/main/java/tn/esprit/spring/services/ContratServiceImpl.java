package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

public class ContratServiceImpl implements ContratService {
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	EmployeRepository employeRepository;
	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		
			Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(new Contrat());
		
		Employe employeManagedEntity = employeRepository.findById(employeId).get();

		contratManagedEntity.setEmploye(employeManagedEntity);
		contratRepoistory.save(contratManagedEntity);
		
	}

	@Override
	public int ajouterContrat(Contrat contrat) {
		contratRepoistory.save(contrat);
		return contrat.getReference();
	}

	@Override
	public void deleteContratById(int contratId) {
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).get();
		contratRepoistory.delete(contratManagedEntity);
		
	}

	@Override
	public void deleteAllContratJPQL() {
		
		
	}
	
	

}
