package it.vincenzopicone.gestionedispositivi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.vincenzopicone.gestionedispositivi.repository.DispositivoRepository;

@Service
public class DispositivoService {
	
	@Autowired DispositivoRepository repo;

}
