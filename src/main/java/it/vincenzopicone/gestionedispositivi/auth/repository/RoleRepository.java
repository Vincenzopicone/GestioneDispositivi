package it.vincenzopicone.gestionedispositivi.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.vincenzopicone.gestionedispositivi.auth.entity.ERole;
import it.vincenzopicone.gestionedispositivi.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
