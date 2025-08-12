package br.com.api.sistema_login.dto.usuario;

import java.util.List;

import br.com.api.sistema_login.dto.task.TaskExibirDTO;
import br.com.api.sistema_login.model.UsuarioRole;

public record UsuarioExibirDTO(long id, String email, UsuarioRole role, List<TaskExibirDTO> task) {

}
