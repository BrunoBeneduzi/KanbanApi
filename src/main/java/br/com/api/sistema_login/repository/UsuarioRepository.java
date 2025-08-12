package br.com.api.sistema_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.sistema_login.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	UsuarioModel findByEmail(String email);
	
}
