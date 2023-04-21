package it.vincenzopicone.gestionedispositivi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Enumerated(EnumType.STRING)
	private TipoDispositivo tipodispositivo;
	@ManyToOne
	@JsonIgnoreProperties("dipendente")
	@JoinColumn(name="id_dipendente")
	private Dipendente dipendente;
	@Column (nullable = false)
	private Boolean disponibile;
	@Column(nullable = false)
	private Boolean assegnato;
	@Column(nullable = false)
	private Boolean inmanutenzione;
	@Column(nullable = false)
	private Boolean dismesso;
	
	public Dispositivo(TipoDispositivo tipodispositivo) {
		super();
		this.tipodispositivo = tipodispositivo;
		this.assegnato = false;
		this.inmanutenzione = false;
		this.dismesso = false;
		this.disponibile = true;
	}

	public Dispositivo(TipoDispositivo tipodispositivo, Dipendente dipendente) {
		super();
		this.tipodispositivo = tipodispositivo;
		this.dipendente = dipendente;
		this.assegnato = true;
		this.disponibile = false;
		this.inmanutenzione = false;
		this.dismesso = false;
	}
	
	
	
	

	
}
