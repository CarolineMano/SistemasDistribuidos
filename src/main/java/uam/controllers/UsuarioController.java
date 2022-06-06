package uam.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uam.dto.usuario.RegistroUsuarioDTO;
import uam.dto.usuario.TokenDTO;
import uam.dto.usuario.UsuarioDTO;
import uam.dto.usuario.UsuarioMapper;
import uam.entities.Usuario;
import uam.services.AutenticacaoService;
import uam.services.UsuarioService;

@RestController
@RequestMapping("v1/auth")
public class UsuarioController {
	
	private final AutenticacaoService autenticacaoService;	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService, AutenticacaoService autenticacaoService) {
		this.usuarioService = usuarioService;
		this.autenticacaoService = autenticacaoService;
	}

	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody UsuarioDTO credenciais) {
		
		try {
			return ResponseEntity.ok(autenticacaoService.autenticar(credenciais));
		} catch (AuthenticationException ae) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@RequestMapping("novo")
	@PostMapping
	public ResponseEntity<String> criarUsuario(@RequestBody RegistroUsuarioDTO dto) {
		Usuario usuario = usuarioService.salvarUsuario(UsuarioMapper.fromDTO(dto));
		
		return ResponseEntity.ok(usuario.getEmail());
	}
}
