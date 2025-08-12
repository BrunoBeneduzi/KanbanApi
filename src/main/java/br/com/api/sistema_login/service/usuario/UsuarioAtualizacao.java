package br.com.api.sistema_login.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.sistema_login.dto.usuario.UsuarioEditarDTO;
import br.com.api.sistema_login.dto.usuario.UsuarioTransferirDTO;
import br.com.api.sistema_login.model.TaskModel;
import br.com.api.sistema_login.model.UsuarioModel;
import br.com.api.sistema_login.repository.TaskRepository;
import br.com.api.sistema_login.repository.UsuarioRepository;

@Service
public class UsuarioAtualizacao {
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;//usado para criptografar a senha
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	
	public Boolean editaUsuario(UsuarioEditarDTO dto) {
		
		UsuarioModel usuario = this.usuarioRepository.findById(dto.id()).get();
		
		if(usuario == null) {
			
			return false;
			
		}else {
			
			if(dto.email() != null) {
				usuario.setEmail(dto.email());
			}
			if(dto.role() != null) {
				usuario.setRole(dto.role());
			}
			
			this.usuarioRepository.save(usuario);
			
			return true;
			
		}
		
	}
	
	public UsuarioEditarDTO alterarSenha(UsuarioEditarDTO dto) {
		
		System.out.println(dto);
		
		UsuarioModel usuario = this.usuarioRepository.findByEmail(dto.email());
		
		System.out.println(usuario);
		
		if(usuario == null) {
			return null;
		}
		
		usuario.setSenha(this.passwordEncoder.encode(dto.senha()));
		
		this.usuarioRepository.save(usuario);
		
		return dto;
	}
	
	
	public Boolean transferirTask(Long id, UsuarioTransferirDTO dto) {
		
		TaskModel task = this.taskRepository.findById(id).get();
		
		UsuarioModel usuario = this.usuarioRepository.findByEmail(dto.email());
		
		if(task != null && usuario != null) {
			
			task.setUsuario(usuario);
			task.setResponsavel(usuario.getEmail());
			
			this.taskRepository.save(task);
			
			return true;
		}
		
		return false;
		
	}
}