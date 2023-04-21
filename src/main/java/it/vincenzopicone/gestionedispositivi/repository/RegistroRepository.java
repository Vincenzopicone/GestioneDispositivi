package it.vincenzopicone.gestionedispositivi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.vincenzopicone.gestionedispositivi.model.Registro;


public interface RegistroRepository extends CrudRepository<Registro, Long> {

//	@Query(value = "SELECT * FROM Registro r WHERE r.id_dispositivo = :id")
//	public List<Registro> findByIdDispositivo(Long id);
//	
}
