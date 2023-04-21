package it.vincenzopicone.gestionedispositivi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.vincenzopicone.gestionedispositivi.model.Dipendente;
import it.vincenzopicone.gestionedispositivi.repository.DipendenteRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

public class DipendenteService {
	
	@Autowired DipendenteRepository repo;

	
	
	public Dipendente createDipendente(Dipendente dip) {
		if(repo.existsByEmail(dip.getEmail())) {
			throw new EntityExistsException("L'email esiste");
		} else {
		repo.save(dip);
		}
		return dip;
		
	}
	
	public List<Dipendente> getAllDipendenti () {
		return (List<Dipendente>) repo.findAll();	
	}
	

//	public Page<Dipendente> getAllUtentiPageable (Pageable pag) {
//		return (Page<Dipendente>) repoPage.findAll(pag);	
//	}
	
	
	public Dipendente getDipendente(Long id) {
		if(!repo.existsById(id)){
			throw new EntityNotFoundException("Il dipendente non esiste");
		} 
		return repo.findById(id).get();
	}
	
	public String updateDipendente(Dipendente dip) {
		if(!repo.existsById(dip.getId())){
			throw new EntityExistsException("Il dipendente non esiste");
		} 
		repo.save(dip);
		return "Dipendente aggiornato";
	}
	
	public String removeDipendente(Long id) {
		if(!repo.existsById(id)){
			throw new EntityExistsException("Il dipendente non esiste");
		} 
		repo.deleteById(id);
		return "Dipendente eliminato";
	}

}
