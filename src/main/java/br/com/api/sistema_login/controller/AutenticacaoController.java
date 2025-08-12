package br.com.api.sistema_login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.sistema_login.dto.AutenticacaoLoginDTO;
import br.com.api.sistema_login.dto.DadosTokenJwtDTO;
import br.com.api.sistema_login.model.UsuarioModel;
import br.com.api.sistema_login.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping
	public ResponseEntity logar(@RequestBody @Valid AutenticacaoLoginDTO dto) {
		
		var usernamePassoword = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
		
		var auth = this.authenticationManager.authenticate(usernamePassoword);
		
		var tokenJWT = tokenService.gerarToken((UsuarioModel) auth.getPrincipal());
	
		return ResponseEntity.ok(new DadosTokenJwtDTO(tokenJWT));
	}
	

}