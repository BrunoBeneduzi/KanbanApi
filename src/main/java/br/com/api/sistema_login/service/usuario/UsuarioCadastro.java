package br.com.api.sistema_login.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.sistema_login.dto.usuario.UsuarioCadastroDTO;
import br.com.api.sistema_login.model.UsuarioModel;
import br.com.api.sistema_login.repository.UsuarioRepository;


@Service
public class UsuarioCadastro {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	public UsuarioCadastroDTO cadastrarUsuario(UsuarioCadastroDTO dto) {
		
		if(this.usuarioRepository.findByEmail(dto.email()) != null) {
			
			return null;
		}else {
			
			UsuarioModel usuario = new UsuarioModel(dto.email().toLowerCase(), this.passwordEncoder.encode(dto.senha()), dto.role());
			
			this.usuarioRepository.save(usuario);
			
			return dto;
		}
	}
	

	
}