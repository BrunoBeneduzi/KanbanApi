package br.com.api.sistema_login.dto.usuario;

import br.com.api.sistema_login.model.UsuarioRole;

public record UsuarioEditarDTO(Long id ,String email, UsuarioRole role, String senha) {

}