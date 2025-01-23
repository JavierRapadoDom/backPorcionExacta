package es.proyectoODS.api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.proyectoODS.api.entity.RecetaEntity;
import es.proyectoODS.api.entity.UsuarioEntity;
import jakarta.transaction.Transactional;
import java.util.Optional;
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO usuarios (nombre, apellidos, email, contraseña, fecha_registro)"
	
			+ " VALUES (:nombre, :apellidos, :email, :contraseña, :fecha_registro)", nativeQuery = true)
	
	void addUsuario(@Param("nombre") String nombre, @Param("apellidos") String apellidos, @Param("email") String email,
				   
				   @Param("contraseña") String contraseña, @Param("fecha_registro") LocalDateTime fecha_creacion);
	
	
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE usuarios SET nombre = :nombre, apellidos = :apellidos, email = :email, " +
	               "contraseña = :contraseña WHERE id = :id", nativeQuery = true)
	void updateUsuario(@Param("id") Integer id,
	                  @Param("nombre") String nombre,
	                  @Param("apellidos") String apellidos,
	                  @Param("email") String email,
	                  @Param("contraseña") String contraseña);
	
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
	void deleteUsuario(@Param("id") Integer id);
	
	@Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
    UsuarioEntity getUsuario(@Param("id") Integer id);
	                  
	
	Optional<UsuarioEntity> findByEmail(String email);
}
