package br.com.api.sistema_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.api.sistema_login.repository.LoginUsuarioRepository;

@Service
public class AuthorizationService implements UserDetailsService{

	@Autowired
	private LoginUsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {//é chamado automaticamente pelo Spring Security quando alguém tenta fazer login., ou seja, sempre que um usuario tentar se autenticar, ele vai ser chamado automaticamente para carregar as informações desse usuario
		
		return repository.findByEmail(username);
	}
//ele é chamado sempre que um usuario for chamado, de forma automatica, e faz a verificação pelo repositorio que foi adicionado
}