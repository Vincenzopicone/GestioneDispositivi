package it.vincenzopicone.gestionedispositivi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.vincenzopicone.gestionedispositivi.model.Dipendente;
import it.vincenzopicone.gestionedispositivi.model.Dispositivo;
import it.vincenzopicone.gestionedispositivi.model.TipoDispositivo;
import it.vincenzopicone.gestionedispositivi.service.DipendenteService;
import it.vincenzopicone.gestionedispositivi.service.DispositivoService;
import it.vincenzopicone.gestionedispositivi.service.RegistroService;

@Component
public class RegistroRunner implements ApplicationRunner {

	
	@Autowired DipendenteService dipServ;
	@Autowired DispositivoService dispServ;
	@Autowired RegistroService regServ;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Registro...RUN");
		
		
		///creo utenti casuali
		
//		for(int i = 0; i < 30; i++) {
//			dipServ.createDipendenteFake();
//		}
		
		
		// creo dispositivi casuali
//		for(int i = 0; i < 20; i++ ) {
//			
//			Dispositivo D1 = new Dispositivo(TipoDispositivo.LAPTOT);
//			dispServ.createDispositivo(D1);
//			Dispositivo D2 = new Dispositivo(TipoDispositivo.NOTEBOOK);
//			dispServ.createDispositivo(D2);
//			Dispositivo D3 = new Dispositivo(TipoDispositivo.TABLET);
//			dispServ.createDispositivo(D3);
//			Dispositivo D4 = new Dispositivo(TipoDispositivo.SMARTPHONE);
//			dispServ.createDispositivo(D4);
//			
//		}
//		
		
//		Dipendente Dip1 = dipServ.getDipendente(1l);
//		Dipendente Dip2 = dipServ.getDipendente(2l);
//		Dipendente Dip3 = dipServ.getDipendente(3l);
//		Dipendente Dip4 = dipServ.getDipendente(4l);
//		Dipendente Dip5 = dipServ.getDipendente(5l);
//		Dipendente Dip6 = dipServ.getDipendente(6l);
//		
//		Dispositivo D1 = dispServ.getDispositivo(1l);
//		Dispositivo D2 = dispServ.getDispositivo(2l);
//		Dispositivo D3 = dispServ.getDispositivo(3l);
//		Dispositivo D4 = dispServ.getDispositivo(4l);
//		Dispositivo D5 = dispServ.getDispositivo(5l);
//		Dispositivo D6 = dispServ.getDispositivo(6l);
		
		/// creo associazioni di dispositivi e dipendenti
//		regServ.createRegistro(Dip1, D2);
//		regServ.createRegistro(Dip2, D1);
//		regServ.createRegistro(Dip3, D5);
//		regServ.createRegistro(Dip4, D3);
//		regServ.createRegistro(Dip5, D4);
//		regServ.createRegistro(Dip6, D6);
		
		
		/// cambio stato manutenzione dispositivo
//		dispServ.updateDispositivoInManutenzione(D3);
		
		
		
		
	
		
		
	}

}
