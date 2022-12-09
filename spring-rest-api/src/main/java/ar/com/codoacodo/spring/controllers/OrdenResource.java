package ar.com.codoacodo.spring.controllers;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.codoacodo.spring.domain.Users;
import ar.com.codoacodo.spring.dtos.UsersDTO;
import ar.com.codoacodo.spring.services.UsersService;


@RestController
public class OrdenResource {
	
	//userservices
	@Autowired //lo inyecta
	private UsersService service;
	
	//metodo con el que voy a recibir la peticion del frontEnd y voy a llegar a la BD
	@GetMapping("/orden/user")
	public UsersDTO user() { // data tranfer objects objetos planos que van de un lado para el otro
		 
		Optional<Users> users = this.service.obtenerPorId(1l);
		 
		UsersDTO dto = null;
			
		if (!users.isEmpty()) {
			Set<String> rolesStrs = users.get().getRoles()
					.stream()
				    .map(r -> "ROLE_" + r.getRole())
					.collect(Collectors.toSet());
					
			dto = UsersDTO.builder()
					.username(null)
					.roles(rolesStrs)
		 			.build();
			
		}
		 
		 		  
		 return dto;
	 }
	 

}
