package it.vincenzopicone.gestionedispositivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vincenzopicone.gestionedispositivi.model.Registro;
import it.vincenzopicone.gestionedispositivi.service.RegistroService;

@RestController
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired RegistroService service;
	
	@GetMapping
	public ResponseEntity<List<Registro>> getAll () {
		return new ResponseEntity<List<Registro>>(service.getAllElement(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDipendenti(@PathVariable Long id) {
		return new ResponseEntity<Registro>(service.getElement(id), HttpStatus.CREATED);
	}
	
	
//	@PostMapping
//	public ResponseEntity<?> createDipendenti(@RequestBody Registro reg){
//		return new ResponseEntity<>(service.createRegistro(reg), HttpStatus.CREATED);
//	
//	}
//	@PostMapping
//	public ResponseEntity<?> createDipendenti(@RequestBody Registro reg){
//		return new ResponseEntity<>(service.createParamRegistro(reg), HttpStatus.CREATED);
//	
//	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDipendenti(@PathVariable Long id) {
		return new ResponseEntity<String>(service.removeRegistrazione(id), HttpStatus.OK);

	}
	
	@PutMapping
	public ResponseEntity<?> updateUtente(@RequestBody Registro reg){
		return new ResponseEntity<>(service.updateRegistrazione(reg), HttpStatus.CREATED);
		
	}

}
