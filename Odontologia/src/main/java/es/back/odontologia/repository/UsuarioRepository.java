package es.back.odontologia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.back.odontologia.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByNickName(String nickName);
	
	@Query("SELECT u FROM Usuario u WHERE u.nickName = :nickName AND u.password = :password AND u.estatus = 1")
	Optional<Usuario> login(@Param("nickName") String email, @Param("password") String password);
	
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :dato OR u.tel = :dato")
	Optional<Usuario> findByEmailOrTel(@Param("dato") String dato);
	
}
