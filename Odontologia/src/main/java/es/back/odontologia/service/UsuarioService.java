package es.back.odontologia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.back.odontologia.entity.Usuario;
import es.back.odontologia.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	 public Optional<Usuario> login(String email, String password) {
	        return usuarioRepository.login(email, password);
	    }
}
