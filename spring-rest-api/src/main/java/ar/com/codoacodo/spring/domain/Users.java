package ar.com.codoacodo.spring.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Users {
	@Id
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true) //no acepta nulos, es unico
	private String username;
	
	@Column(name = "password", nullable = false) 
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER )
	@JoinTable(name = "users_roles",
		joinColumns = @JoinColumn(name = "users_id"),
		inverseJoinColumns = @JoinColumn(name =  "roles_id")	
	)
	private Set<Roles> roles;
}
