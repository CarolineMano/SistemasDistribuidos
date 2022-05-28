package uam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

import uam.dto.usuario.TokenDTO;
import uam.dto.usuario.UsuarioDTO;
import uam.entities.Usuario;

@Service
public class AutenticacaoService {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Value("${uam.jwt.expiration}")
	private String expiration;
	
	@Value("${uam.jwt.secret}")
	private String secret;
	
	@Value("${uam.jwt.issuer}")
	private String issuer;
	
	public TokenDTO autenticar(UsuarioDTO credenciais) throws AuthenticationException {
		Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(credenciais.getEmail(), credenciais.getSenha()));
		String token = gerarToken(authenticate);
		
		return new TokenDTO(token);
	}

	private Algorithm criarAlgoritmo() {
		return Algorithm.HMAC256(this.secret);
	}
	
	private String gerarToken(Authentication authenticate) {
		Usuario principal = (Usuario)authenticate.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return JWT.create().withIssuer(issuer).withExpiresAt(dataExpiracao).withSubject(principal.getId().toString()).sign(this.criarAlgoritmo());
	}
}
