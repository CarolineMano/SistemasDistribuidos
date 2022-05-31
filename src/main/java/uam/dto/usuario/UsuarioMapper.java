package uam.dto.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import uam.entities.Perfil;
import uam.entities.Usuario;

public class UsuarioMapper {
	public static Usuario fromDTO(RegistroUsuarioDTO dto) {
		
		Perfil perfil = new Perfil();
		
		if(dto.getPerfilId() != 1 && dto.getPerfilId() != 2)
			perfil.setId(2L);
		else
			perfil.setId(dto.getPerfilId());
		
		return new Usuario(null, dto.getEmail(), new BCryptPasswordEncoder().encode(dto.getSenha()), perfil);
	}
}
