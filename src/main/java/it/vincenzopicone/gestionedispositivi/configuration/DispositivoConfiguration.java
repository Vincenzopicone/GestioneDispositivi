package it.vincenzopicone.gestionedispositivi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.vincenzopicone.gestionedispositivi.model.Dispositivo;

@Configuration
public class DispositivoConfiguration {
	
	@Bean("CustomDevice")
	@Scope("Prototype")
	public Dispositivo customDevice() {
		return new Dispositivo();
	}

}
