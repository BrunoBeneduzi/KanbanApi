package br.com.api.sistema_login.dto.task;

import java.time.LocalDate;

import br.com.api.sistema_login.model.StatusModel;

public record TaskExibirDTO(Long id, String titulo, String descricao, String responsavel, StatusModel  Status, LocalDate dataDeEntrega) {

}
