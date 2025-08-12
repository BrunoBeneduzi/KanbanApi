package br.com.api.sistema_login.dto.usuario;

import jakarta.validation.constraints.Email;

public record UsuarioTransferirDTO(
		@Email
		String email
		) {

}
