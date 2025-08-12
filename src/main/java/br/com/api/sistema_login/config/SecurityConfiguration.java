package br.com.api.sistema_login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
✅ @Configuration
Indica que essa classe fornece configurações para o Spring (é um bean de configuração).

✅ @EnableWebSecurity
Habilita a segurança da web com Spring Security.

Permite personalizar as configurações de segurança.
*/


//essa classe e a classe securityFilter, são filtros que são chamados sempre que existe uma requisisão http, para escolher qual vai vir primeiro, precisa colocar em um metodo
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private SecurityFilter securityFilter;
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	        .csrf(csrf -> csrf.disable()) // Desativa CSRF
	        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(HttpMethod.POST, "/login").permitAll()
	            .requestMatchers(HttpMethod.POST, "/adm/cadastroUsuario").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.PUT, "/adm/editarUsuario").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.DELETE, "/adm/excluirUsuario").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.POST, "/adm/cadastroTarefa").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.GET, "/adm/exibirTodosUsuario").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.GET, "/adm/exibirUsuario/{id}").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.PUT, "/adm/editarSenha").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.PUT, "/adm/transferirTarefa/{id}").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.GET, "/adm/exibirTask/{id}").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.GET, "/adm/exibirTasks").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.PUT, "/api/editarTarefa").authenticated()
	            .requestMatchers(HttpMethod.PUT, "/api/exibirTask").authenticated()
	            .anyRequest().authenticated() // Protege qualquer outra rota
	        )
	        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) // Adiciona o filtro JWT antes da autenticação padrão.
	        .build(); // Finaliza a configuração
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();//decodifica a senha 
	}
}