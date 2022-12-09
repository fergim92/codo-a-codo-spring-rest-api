package ar.com.codoacodo.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ar.com.codoacodo.spring.domain.Users;
import ar.com.codoacodo.spring.repository.UserRepository;

@Transactional  //hace un open connection con la BD y usaria por debajo el reposositorio y con la conexion abierta ir al repositorio pegarle a la BD y  traer la informacion
public class UsersServicesImpl implements UsersService{

	//Necesito el/los repositorios
	@Autowired
	private UserRepository userRepository;
	
	public Users obtenerPorId(Long id) {
		return this.userRepository.findById(id).get();
		
	}
}
 