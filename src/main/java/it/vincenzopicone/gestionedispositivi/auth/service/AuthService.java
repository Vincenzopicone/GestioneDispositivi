package it.vincenzopicone.gestionedispositivi.auth.service;

import it.vincenzopicone.gestionedispositivi.auth.payload.LoginDto;
import it.vincenzopicone.gestionedispositivi.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
