package ar.com.codoacodo.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.codoacodo.spring.domain.User;


@RestController //para usar rest puro
public class RestResources {
	@Autowired   //esta clase esta dentro del contexto creado como un Bean, lo instancia el contenedor, no yo y lo pone aca adentro para que ya este vivo
	private User user; 
	
	@RequestMapping("/home") 
	public void home () {
		this.user.getId();
		System.out.println("escuchando en /");
	}
	
	@RequestMapping("/user/show")
	public User showUser() { 	
		User u = new User(); 		
		return u;
	}
}