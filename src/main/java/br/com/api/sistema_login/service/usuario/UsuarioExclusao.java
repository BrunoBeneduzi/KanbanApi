package br.com.api.sistema_login.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.sistema_login.dto.usuario.UsuarioExcluirDTO;
import br.com.api.sistema_login.model.UsuarioModel;
import br.com.api.sistema_login.repository.UsuarioRepository;

@Service
public class UsuarioExclusao {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Boolean excluirUsuario(UsuarioExcluirDTO dto) {
		System.out.println(dto);
		UsuarioModel usuario;
		
		if(dto.email() != null) {
			usuario = this.usuarioRepository.findByEmail(dto.email());
			
			this.usuarioRepository.delete(usuario);
			
			return true;
		}else if(dto.id() != null) {
			usuario = this.usuarioRepository.findById(dto.id()).get();
			
			this.usuarioRepository.delete(usuario);
			
			return true;
		}
		
		return false;
		
		
		
	}
}