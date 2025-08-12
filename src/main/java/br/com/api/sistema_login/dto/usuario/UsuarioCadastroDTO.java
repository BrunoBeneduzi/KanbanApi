package br.com.api.sistema_login.dto.usuario;

import br.com.api.sistema_login.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCadastroDTO(
		@NotBlank
		@Email
		String email,
		@NotBlank
		String senha,
		@NotNull
		UsuarioRole role) {

}
