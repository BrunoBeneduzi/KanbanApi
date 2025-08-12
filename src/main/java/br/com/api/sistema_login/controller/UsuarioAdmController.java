package br.com.api.sistema_login.controller;


import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.sistema_login.dto.task.TaskCadastroDTO;
import br.com.api.sistema_login.dto.usuario.UsuarioCadastroDTO;
import br.com.api.sistema_login.dto.usuario.UsuarioEditarDTO;
import br.com.api.sistema_login.dto.usuario.UsuarioExcluirDTO;
import br.com.api.sistema_login.dto.usuario.UsuarioTransferirDTO;
import br.com.api.sistema_login.service.task.TaskCadastro;
import br.com.api.sistema_login.service.task.TaskExibir;
import br.com.api.sistema_login.service.usuario.UsuarioAtualizacao;
import br.com.api.sistema_login.service.usuario.UsuarioCadastro;
import br.com.api.sistema_login.service.usuario.UsuarioExclusao;
import br.com.api.sistema_login.service.usuario.UsuariosExibir;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/adm")
public class UsuarioAdmController {
	
	@Autowired
	private UsuarioCadastro UsuarioCadastro;
	
	@Autowired
	private UsuarioExclusao usuarioExclusao;
	
	@Autowired
	private UsuarioAtualizacao usuarioAtualizacao;
	
	@Autowired
	private UsuariosExibir usuariosExibir;
	
	@Autowired
	private TaskCadastro taskCadastro;
	
	@Autowired
	private TaskExibir taskExibir;
	
	//--------------------usuarios-------------------------------------------
	@GetMapping("/exibirTodosUsuario")
	public ResponseEntity exibirUsuarios() {
		
		return ResponseEntity.ok(this.usuariosExibir.exibirTodosUsuarios());
	}
	
	
	@GetMapping("/exibirUsuario/{id}")
	public ResponseEntity exibirUsuarioEspecifico(@PathVariable Long id) {
		
		
		if(this.usuariosExibir.exibirUsuarioEspecifico(id) == null) {
			return ResponseEntity.badRequest().body("Usuario não encontrado");
		}
		return ResponseEntity.ok(this.usuariosExibir.exibirUsuarioEspecifico(id));
	}
	
	@PostMapping("/cadastroUsuario")
	@Transactional
	public ResponseEntity cadastrarUsuario(@RequestBody @Valid UsuarioCadastroDTO dto) {
		
		UsuarioCadastroDTO verificaDto = this.UsuarioCadastro.cadastrarUsuario(dto);
		
		if(verificaDto == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuario cadastrado com esse email");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("O email -> "+ dto.email() +" foi cadastrado com sucesso");
	}
	
	@DeleteMapping("/excluirUsuario")
	@Transactional
	public ResponseEntity excluirUsuario(@RequestBody UsuarioExcluirDTO dto) {
		
		if(this.usuarioExclusao.excluirUsuario(dto)) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.badRequest().body("Usuario não encontrado");
	}
	
	@PutMapping("/editarUsuario")
	@Transactional
	public ResponseEntity editarUsuario(@RequestBody UsuarioEditarDTO dto) {
		
		if(this.usuarioAtualizacao.editaUsuario(dto)) {
			return ResponseEntity.ok("Dados atualizados com sucesso.");
		}
		
		return ResponseEntity.status(404).body("ID informado não foi encontrado.");

	}
	
	@PutMapping("/editarSenha")
	@Transactional
	public ResponseEntity editarSenha(@RequestBody UsuarioEditarDTO dto) {
		this.usuarioAtualizacao.alterarSenha(dto);
		
		if(this.usuarioAtualizacao.alterarSenha(dto) != null) {
			return ResponseEntity.ok("senha atualizada com sucesso.");
		}
		return ResponseEntity.status(404).body("não foi encontrado o usuario informado.");
	}
	
	//--------------------Tarefas-------------------------------------------
	
	@PostMapping("/cadastroTarefa")
	@Transactional
	public ResponseEntity cadastrarTarefaParaColaborador(@RequestBody @Valid TaskCadastroDTO dto) {
		
		
		if(this.taskCadastro.cadastrarTask(dto) != null) {
			return ResponseEntity.ok("Tarefa cadastrada com sucesso");
		}
		
		
		return ResponseEntity.status(404).body("responsavel não foi encontrado.");
	}
	
	@PutMapping("/transferirTarefa/{id}")
	public ResponseEntity transferirTarefa(@RequestBody @Valid UsuarioTransferirDTO dto, @PathVariable Long id) {
		
		if(this.usuarioAtualizacao.transferirTask(id, dto)) {
			return ResponseEntity.ok("Task alterada para o usuario "+ dto.email());
		}
		
		return ResponseEntity.status(404).body("Não foi encontrado a tarefa ou o colaborador.");
	}
	
	@GetMapping("/exibirTasks")
	public ResponseEntity exibirTodasAsTasks() {
		
		return ResponseEntity.ok(this.taskExibir.exibirTodasAsTasks());
	}
	
	@GetMapping("/exibirTask/{id}")
	public ResponseEntity exbirUmaTask(@PathVariable Long id) {
		
		if(this.taskExibir.exibirUmaTask(id) != null) {
			return ResponseEntity.ok(this.taskExibir.exibirUmaTask(id));
		}
		
		return ResponseEntity.status(404).body("Não foi encontrado a tarefa com esse ID.");
	}
	
	
	
}