package br.com.api.sistema_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.api.sistema_login.model.UsuarioModel;

public interface LoginUsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	UserDetails findByEmail(String email);
	
}