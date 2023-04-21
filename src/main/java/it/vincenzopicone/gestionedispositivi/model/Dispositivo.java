package it.vincenzopicone.gestionedispositivi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="dispositivi")
public class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private TipoDispositivo tipodispositivo;
	@Column
	private Dipendente dipendente;
	@Column
	private Boolean disponibile;
	@Column
	private Boolean assegnato;
	@Column
	private Boolean inmanutenzione;
	@Column
	private Boolean dismesso;

}
