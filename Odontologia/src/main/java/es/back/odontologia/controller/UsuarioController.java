package es.back.odontologia.controller;

import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.back.odontologia.entity.Usuario;
import es.back.odontologia.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
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
}
