package it.vincenzopicone.gestionedispositivi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.vincenzopicone.gestionedispositivi.model.Dipendente;
import it.vincenzopicone.gestionedispositivi.model.Dispositivo;
import it.vincenzopicone.gestionedispositivi.model.Registro;

@Configuration
public class RegistroConfiguration {
	
	@Bean("NuovaRegistrazione")
	@Scope("prototype")
	public Registro nuovaRegistrazione() {
		return new Registro();
	}
	
	@Bean("ParamRegistrazione")
	@Scope("prototype")
	public Registro paramRegistrazione(Dipendente dipe, Dispositivo disp) {
		Registro R = new Registro();
		R.setDipendente(dipe);
		R.setDispositivi(disp);
		return R;
	}

}
