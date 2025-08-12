package br.com.api.sistema_login.service.task;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.api.sistema_login.dto.task.TaskExibirDTO;
import br.com.api.sistema_login.model.TaskModel;
import br.com.api.sistema_login.model.UsuarioModel;
import br.com.api.sistema_login.repository.TaskRepository;

@Service
public class TaskExibir {

	@Autowired
	private TaskRepository taskRepository;
	
	
	public TaskExibirDTO exibirTask(Long id) {
		
		UsuarioModel usuario = (UsuarioModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		TaskModel task = taskRepository.buscarPorIdEUsuario(id, usuario.getId());
		
		if(task != null) {
			return new TaskExibirDTO(task.getId(), task.getTitulo(), task.getDescricao(), task.getResponsavel(), task.getStatus(), task.getDataDeEntrega());
		}
		
		return null;
		
	}
	
	//adm
	public List<TaskExibirDTO> exibirTodasAsTasks() {
		
		return this.taskRepository.findAll().stream().map(t -> new TaskExibirDTO(t.getId(), t.getTitulo(), t.getDescricao(), t.getResponsavel(), t.getStatus(), t.getDataDeEntrega())).collect(Collectors.toList());
	}
	
	public TaskExibirDTO exibirUmaTask(Long id) {
		
		Optional<TaskModel> task = this.taskRepository.findById(id);
		
		if(!task.isEmpty()) {
			TaskModel tasks = task.get();
			return new TaskExibirDTO(tasks.getId(), tasks.getTitulo(), tasks.getDescricao(), tasks.getResponsavel(), tasks.getStatus(), tasks.getDataDeEntrega());
		}
		
		return null;
	}
}