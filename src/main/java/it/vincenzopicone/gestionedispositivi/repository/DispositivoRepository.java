package it.vincenzopicone.gestionedispositivi.repository;

import org.springframework.data.repository.CrudRepository;

import it.vincenzopicone.gestionedispositivi.model.Dispositivo;

public interface DispositivoRepository extends CrudRepository<Dispositivo, Long> {

}
