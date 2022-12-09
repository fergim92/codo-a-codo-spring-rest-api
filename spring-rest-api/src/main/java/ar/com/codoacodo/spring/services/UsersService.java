package ar.com.codoacodo.spring.services;

import org.springframework.stereotype.Service;

import ar.com.codoacodo.spring.domain.Users;

@Service
public interface UsersService {
	public Users obtenerPorId(Long id); 
}

//Necesito la implementacion de esto :
