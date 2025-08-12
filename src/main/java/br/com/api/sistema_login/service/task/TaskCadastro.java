package br.com.api.sistema_login.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.sistema_login.dto.task.TaskCadastroDTO;
import br.com.api.sistema_login.model.TaskModel;
import br.com.api.sistema_login.repository.TaskRepository;
import br.com.api.sistema_login.repository.UsuarioRepository;

@Service
public class TaskCadastro {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	public TaskCadastroDTO cadastrarTask(TaskCadastroDTO dto) {
		
		var usuario = this.usuarioRepository.findByEmail(dto.responsavel());
		
		if(usuario == null) {
			return null;
		}else {
			System.out.println(dto);
			TaskModel task = new TaskModel(dto.titulo(), dto.descricao(), dto.responsavel(), dto.status(), dto.dataDeEntrega(), usuario);
			
			this.taskRepository.save(task);
			
			return dto;
		}
	}
}