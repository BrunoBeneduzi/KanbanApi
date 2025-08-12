package br.com.api.sistema_login.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.api.sistema_login.model.UsuarioModel;

@Service
public class TokenService {

	public String gerarToken(UsuarioModel usuario) {
		try {
            var algoritmo = Algorithm.HMAC256("12345678");//Define o algoritmo de assinatura HMAC com uma chave secreta
            
            return JWT.create()// Inicia a criação do token JWT.
                .withIssuer("API sistema")//Adiciona um campo iss (issuer, ou emissor), indicando quem gerou o token — útil para validação depois.
                .withSubject(usuario.getEmail())//Define o campo sub (subject), geralmente usado para identificar o usuário — neste caso, o login.
                .withExpiresAt(dataExpiracao())//Define a data de expiração do token (campo exp). A função dataExpiracao()  retorna um Date no futuro, como +2 horas, por exemplo.
                .sign(algoritmo);//Finaliza a criação e assinatura do token com o algoritmo e chave definidos.
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }	
	}
	
	
	public String getSubject(String tokenJWT) {//verifica se o token está valido ou expirado
		
	    try {
	    	var algoritmo = Algorithm.HMAC256("12345678");
       
	        return JWT.require(algoritmo)
	                        .withIssuer("API sistema")
	                        .build()
	                        .verify(tokenJWT)
	                        .getSubject();
	        
	    } catch (JWTVerificationException exception) {
	    	throw new RuntimeException("Token JWT inválido ou expirado!");
	    }
	}
	
	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}


	
}