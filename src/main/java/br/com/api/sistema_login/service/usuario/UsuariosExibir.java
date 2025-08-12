package br.com.api.sistema_login.service.usuario;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.sistema_login.dto.task.TaskExibirDTO;
import br.com.api.sistema_login.dto.usuario.UsuarioExibirDTO;
import br.com.api.sistema_login.model.UsuarioModel;
import br.com.api.sistema_login.repository.UsuarioRepository;

@Service
public class UsuariosExibir {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioExibirDTO> exibirTodosUsuarios() {
		
		List<UsuarioModel> usuario = this.usuarioRepository.findAll();
		
		
		return usuario.stream().map(u -> new UsuarioExibirDTO(
				u.getId(),
				u.getEmail(),
				u.getRole(),
				u.getTask().stream().map(t -> new TaskExibirDTO(
						t.getId(), 
						t.getTitulo(), 
						t.getDescricao(), 
						t.getResponsavel(), 
						t.getStatus(), 
						t.getDataDeEntrega())).collect(Collectors.toList())
				)).collect(Collectors.toList()); 
				
	}
	
	public UsuarioExibirDTO exibirUsuarioEspecifico(Long id) {
			
		UsuarioModel usuario = this.usuarioRepository.findById(id).get();
		
		if(usuario == null) {
			return null;
		}
		
		return new UsuarioExibirDTO(usuario.getId(), usuario.getEmail(), usuario.getRole(), usuario.getTask().stream().map(t -> new TaskExibirDTO(
				t.getId(),
				t.getTitulo(),
				t.getDescricao(), 
				t.getResponsavel(), 
				t.getStatus(), 
				t.getDataDeEntrega())).collect(Collectors.toList()));
	}


}