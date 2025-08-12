package br.com.api.sistema_login.dto.task;

import br.com.api.sistema_login.model.StatusModel;

public record TaskAtualizarDTO(String titulo, String descricao, StatusModel status) {

}
