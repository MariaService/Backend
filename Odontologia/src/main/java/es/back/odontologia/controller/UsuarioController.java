package es.back.odontologia.controller;

import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.back.odontologia.entity.Usuario;
import es.back.odontologia.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario datosLogin) {
		Optional<Usuario> usuario = usuarioService.login(datosLogin.getNickName(), datosLogin.getPassword());

		if (usuario.isPresent()) {

			return ResponseEntity.ok(usuario.get());
		} else {
			return ResponseEntity.status(HttpStatus.SC_UNAUTHORIZED).body("Credenciales inválidas");
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Usuario usr) {
		Usuario usuario = usuarioService.registrarUsuario(usr);
		return ResponseEntity.status(HttpStatus.SC_CREATED).body(usr);
	}

	// 🔹 OBTENER USUARIO POR ID
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
	    Optional<Usuario> usuario = usuarioService.obtenerPorId(id);

	    if (usuario.isPresent()) {
	        // ✅ Usuario encontrado
	        return ResponseEntity.ok(usuario.get());
	    } else {
	        // ❌ Usuario no encontrado
	        return ResponseEntity
	                .status(HttpStatus.SC_NOT_FOUND)
	                .body("Usuario no encontrado");
	    }
	}

	// 🔹 EDITAR USUARIO
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usrActualizado) {

		Optional<Usuario> actualizado = usuarioService.actualizarUsuario(id, usrActualizado);
		if (actualizado.isPresent()) {
			return ResponseEntity.ok(actualizado.get());
		} else {
			return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("Usuario no encontrado para actualizar");
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
	    List<Usuario> usuarios = usuarioService.obtenerTodos();
	    return ResponseEntity.ok(usuarios);
	}

	// 🔹 ELIMINAR USUARIO
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
		boolean eliminado = usuarioService.eliminarUsuario(id);
		if (eliminado) {
			return ResponseEntity.ok("Usuario eliminado correctamente");
		} else {
			return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("Usuario no encontrado");
		}
	}
	

}
