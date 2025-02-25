package com.lf.sino.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.lf.sino.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

//	@Value("${forum.jwt.expiration}")
//	private String expiraton;
//
//	@Value("${forum.jwt.secret}")
//	private String secret;

	// EXPIRATION_TIME = 1 dia
	private static final long EXPIRATION_TIME = 86400000;
	private static final String SECRET = "MySecret";
	// private static final String TOKEN_PREFIX = "Bearer";
	// private static final String HEADER_STRING = "Authorization";

	public String gerarToken(Authentication authentication) {

		Usuario usuarioLogado = (Usuario) authentication.getPrincipal();

		System.out.println("USUARIOOOO : " + usuarioLogado.getNome());

		System.out.println("USUARIOOOOooooooooooooooooooooooooooooooooo");

		
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + EXPIRATION_TIME);

		return Jwts.builder().setIssuer("API do SINOSI").setSubject(usuarioLogado.getId().toString()).setIssuedAt(hoje)
				.setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, SECRET).compact();
	}

	public boolean isValido(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Integer getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
		return Integer.parseInt(claims.getSubject());
	}

}
