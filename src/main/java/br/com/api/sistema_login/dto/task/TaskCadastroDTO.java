package br.com.api.sistema_login.dto.task;

import java.time.LocalDate;

import br.com.api.sistema_login.model.StatusModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record TaskCadastroDTO(
		@NotBlank
		String titulo,
		@NotBlank
		String descricao, 
		StatusModel  status, 
		@Email
		String responsavel, 
		LocalDate dataDeEntrega) {

}