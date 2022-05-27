package uam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uam.dto.usuario.TokenDTO;
import uam.dto.usuario.UsuarioDTO;
import uam.services.AutenticacaoService;

@RestController
@RequestMapping("v1/auth")
public class UsuarioController {
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody UsuarioDTO credenciais) {
		
		try {
			return ResponseEntity.ok(autenticacaoService.autenticar(credenciais));
		} catch (AuthenticationException ae) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
