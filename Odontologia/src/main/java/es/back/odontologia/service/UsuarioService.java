package es.back.odontologia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.back.odontologia.entity.Usuario;
import es.back.odontologia.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	 public Optional<Usuario> login(String nickName, String password) {
	        return usuarioRepository.login(nickName, password);
	    }

//	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//	public Optional<Usuario> login(String nickName, String password) {
//		Optional<Usuario> usuarioOpt = usuarioRepository.findByNickName(nickName);
//
//		if (usuarioOpt.isPresent()) {
//			Usuario usuario = usuarioOpt.get();
//			if (passwordEncoder.matches(password, usuario.getPassword())) {
//				return Optional.of(usuario); // Contraseña correcta
//			}
//		}
//
//		return Optional.empty(); // Usuario no encontrado o contraseña incorrecta

//	}
//
	public Usuario registrarUsuario(Usuario usr) {
		Usuario usuario = new Usuario();
		usuario.setNickName(usr.getNickName());
		usuario.setPassword(usr.getPassword()); // Encriptar password
		usuario.setNombreCompleto(usr.getNombreCompleto());
		return usuarioRepository.save(usr);
	}
	

	    public Optional<Usuario> obtenerPorId(Long id) {
	        return usuarioRepository.findById(id);
	    }

	    public Optional<Usuario> actualizarUsuario(Long id, Usuario usrActualizado) {
	        return usuarioRepository.findById(id).map(usuario -> {
	            usuario.setNickName(usrActualizado.getNickName());
	            usuario.setEmail(usrActualizado.getEmail());
	            if (usrActualizado.getPassword() != null && !usrActualizado.getPassword().isBlank()) {
	               // usuario.setPassword(passwordEncoder.encode(usrActualizado.getPassword()));
	            }
	            return usuarioRepository.save(usuario);
	        });
	    }

	    
	    public List<Usuario> obtenerTodos() {
	        return usuarioRepository.findAll();
	    }
	    
	    public boolean eliminarUsuario(Long id) {
	        if (usuarioRepository.existsById(id)) {
	            usuarioRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

}
