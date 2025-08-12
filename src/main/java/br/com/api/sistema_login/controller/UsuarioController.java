package br.com.api.sistema_login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.sistema_login.dto.task.TaskAtualizarDTO;
import br.com.api.sistema_login.service.task.TaskAtualizacao;
import br.com.api.sistema_login.service.task.TaskExibir;


@RestController
@RequestMapping("/api")
public class UsuarioController {
  
	@Autowired
	private TaskAtualizacao taskAtualizacao;
	
	@Autowired
	private TaskExibir taskExibir;
	
	@GetMapping("/exibirTask/{id}")
	public ResponseEntity retornaTask(@PathVariable Long id) {
		
		if(this.taskExibir.exibirTask(id) != null) {
			return ResponseEntity.ok(this.taskExibir.exibirTask(id));
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado Task vinculado a o seu id com esse ID");
	}
	
	@PutMapping("/editarTarefa/{id}")
	public ResponseEntity editarTarefa(@RequestBody TaskAtualizarDTO dto, @PathVariable Long id) {
		
		
		if(this.taskAtualizacao.editarTask(dto, id) != null) {
			return ResponseEntity.ok("Dados Atualizados com sucesso");
		}
		
		return ResponseEntity.status(404).body("Não foi encontrado o ID da task informado, ou a task é de outro usuario");
	}
}
