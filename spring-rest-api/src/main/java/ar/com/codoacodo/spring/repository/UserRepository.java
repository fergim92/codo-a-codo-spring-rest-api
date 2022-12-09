package ar.com.codoacodo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.codoacodo.spring.domain.Users;

/*
 * repositorio de la entidad User: JpaRepository<T, ID>
 * id: tipo de la primary key
 * 
 * JpaRepository<Users, Long> Esto tiene todas las opciones: contar,existe,findAll,findOne,findByID,select*,insert
 * Inyecta un proxy para que pueda hacer la conexion con una base de datos
 * Esto se prueba con un service(UsersServices)
 */

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{ 
}
