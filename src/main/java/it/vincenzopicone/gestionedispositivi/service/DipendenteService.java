package it.vincenzopicone.gestionedispositivi.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.vincenzopicone.gestionedispositivi.model.Dipendente;
import it.vincenzopicone.gestionedispositivi.repository.DipendenteRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DipendenteService {
	
	@Autowired DipendenteRepository repo;
	
	@Autowired @Qualifier("FakeDipendente") private ObjectProvider<Dipendente> fakeDipendenteProvider;
	@Autowired @Qualifier("CustomDipendente") private ObjectProvider<Dipendente> customDipendenteProvider;
	@Autowired @Qualifier("ParamsDipendente") private ObjectProvider<Dipendente> paramsDipendenteProvider;

	
	
	public Dipendente createDipendente(Dipendente dip) {
		if(repo.existsByEmail(dip.getEmail())) {
			throw new EntityExistsException("L'email esiste");
		} else {
		repo.save(dip);
		}
		return dip;
		
	}
	public Dipendente createDipendenteFake() {
		Dipendente D = fakeDipendenteProvider.getObject();
		if(repo.existsByEmail(D.getEmail())) {
			throw new EntityExistsException("L'email esiste");
		} else {
		repo.save(D);
		}
		return D;
		
	}
	
	public List<Dipendente> getAllDipendenti () {
		return (List<Dipendente>) repo.findAll();	
	}
	

//	public Page<Dipendente> getAllDipendentePageable (Pageable pag) {
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
