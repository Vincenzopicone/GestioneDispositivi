package it.vincenzopicone.gestionedispositivi.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.vincenzopicone.gestionedispositivi.model.Dipendente;
import it.vincenzopicone.gestionedispositivi.model.Registro;
import it.vincenzopicone.gestionedispositivi.repository.RegistroRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class RegistroService {
	@Autowired RegistroRepository repo;
	
	
	
	@Autowired @Qualifier("NuovaRegistrazione") private ObjectProvider<Registro> nuovaRegistrazioneProvider;
	@Autowired @Qualifier("ParamRegistrazione") private ObjectProvider<Registro> paramRegistrazioneProvider;

	
	public Registro createRegistro(Registro reg) {
	////da sistemare da associare al'id del dispositivo
//		if(repo.existsByEmail(reg.getEmail())) {
//			throw new EntityExistsException("Il dispositivo è già associato");
//		} else {
		repo.save(reg);
//		}
		return reg;
		
	}
	
	public List<Registro> getAllElement () {
		return (List<Registro>) repo.findAll();	
	}
	

//	public Page<Registro> getAllElementiPageable (Pageable pag) {
//		return (Page<Registro>) repoPage.findAll(pag);	
//	}
	
	
	public Registro getElement(Long id) {
		if(!repo.existsById(id)){
			throw new EntityNotFoundException("La registrazione non esiste");
		} 
		return repo.findById(id).get();
	}
	
	public String updateRegistrazione(Registro reg) {
		if(!repo.existsById(reg.getId())){
			throw new EntityExistsException("La registrazione non esiste");
		} 
		repo.save(reg);
		return "Registrazione aggiornata";
	}
	
	public String removeRegistrazione(Long id) {
		if(!repo.existsById(id)){
			throw new EntityExistsException("La registrazione non esiste");
		} 
		repo.deleteById(id);
		return "Registrazione eliminata";
	}
}
