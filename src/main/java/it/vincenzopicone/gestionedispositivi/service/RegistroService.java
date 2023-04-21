package it.vincenzopicone.gestionedispositivi.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.vincenzopicone.gestionedispositivi.model.Dipendente;
import it.vincenzopicone.gestionedispositivi.model.Dispositivo;
import it.vincenzopicone.gestionedispositivi.model.Registro;
import it.vincenzopicone.gestionedispositivi.repository.RegistroRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegistroService {
	@Autowired RegistroRepository repo;
	@Autowired DispositivoService dispoRepo;
	
	
	
	@Autowired @Qualifier("NuovaRegistrazione") private ObjectProvider<Registro> nuovaRegistrazioneProvider;
	@Autowired @Qualifier("ParamRegistrazione") private ObjectProvider<Registro> paramRegistrazioneProvider;

	
	public Registro createRegistro(Dipendente ut, Dispositivo dis) {
		
		
		Registro R = paramRegistrazioneProvider.getObject(ut, dis);
//		List<Registro> check = repo.findByIdDispositivo(dis.getId());
//		if(check.size() > 0) {
//			log.info("Il dispositivo è già associato");	
//		} else {
		dis.setAssegnato(true);
		dis.setDisponibile(false);
		dispoRepo.updateDispositivo(dis);
			repo.save(R);
//			}
		return R;
		
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
