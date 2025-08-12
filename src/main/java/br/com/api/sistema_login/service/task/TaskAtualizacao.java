package br.com.api.sistema_login.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.api.sistema_login.dto.task.TaskAtualizarDTO;
import br.com.api.sistema_login.model.TaskModel;
import br.com.api.sistema_login.model.UsuarioModel;
import br.com.api.sistema_login.repository.TaskRepository;
import br.com.api.sistema_login.repository.UsuarioRepository;

@Service
public class TaskAtualizacao{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	

	
	public TaskAtualizarDTO editarTask(TaskAtualizarDTO dto, Long id) {
		
		UsuarioModel usuario = (UsuarioModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//traz o usuario logado
		
		TaskModel task = this.taskRepository.buscarPorIdEUsuario(id, usuario.getId());
		
		if(task != null) {
			if(dto.titulo() != null) {
				task.setTitulo(dto.titulo());
			}
			if(dto.descricao() != null) {
				task.setDescricao(dto.descricao());
			}
			if(dto.status() != null) {
				task.setStatus(dto.status());
			}
			
			this.taskRepository.save(task);
			
			return dto;
		}
		
		return null;
		
		
		
		
		
	}
}