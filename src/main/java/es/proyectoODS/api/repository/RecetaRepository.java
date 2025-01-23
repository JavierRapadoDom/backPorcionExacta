package es.proyectoODS.api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.proyectoODS.api.dto.RecetaDto;
import es.proyectoODS.api.entity.RecetaEntity;
import jakarta.transaction.Transactional;


@Repository
public interface RecetaRepository extends JpaRepository<RecetaEntity, Integer> {
	
	
	@Modifying
	@Transactional
	
	@Query(value = "INSERT INTO recetas (id,nombre, descripcion, tiempo_de_preparacion, num_personas, pasos, fecha_creacion, id_usuario)"
	
			+ " VALUES (:id, :nombre, :descripcion, :tiempo_de_preparacion, :num_personas, :pasos, :fecha_creacion, :id_usuario)", nativeQuery = true)
	
	
	void addReceta(@Param("id") Integer id,@Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("tiempo_de_preparacion") String tiempo_de_preparacion,
				   
				   @Param("num_personas") Integer num_personas,@Param("pasos") String pasos,
				   
				   @Param("fecha_creacion") LocalDateTime fecha_creacion, @Param("id_usuario") Integer id_usuario
				   
				   );
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM recetas WHERE id = :id", nativeQuery = true)
	void deleteReceta(@Param("id") Integer id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE recetas SET nombre = :nombre, descripcion = :descripcion, num_personas = :num_personas, " +
	               "tiempo_de_preparacion = :tiempo_de_preparacion, pasos = :pasos WHERE id = :id", nativeQuery = true)
	void updateReceta(@Param("id") Integer id,
	                  @Param("nombre") String nombre,
	                  @Param("descripcion") String descripcion,
	                  @Param("tiempo_de_preparacion") String tiempo_de_preparacion,
	                  @Param("num_personas") Integer num_personas,
	                  @Param("pasos") String pasos);
	
	
	@Query(value = "SELECT * FROM recetas WHERE id_usuario = :id_usuario", nativeQuery = true)
    List<RecetaEntity> getRecetasByUser(@Param("id_usuario") Integer id_usuario);
	
	
	
	@Query(value = "SELECT * FROM recetas WHERE id = :id", nativeQuery = true)
    RecetaEntity getRecetaById(@Param("id") Integer id);

	@Query(value = "SELECT max(id) FROM recetas", nativeQuery = true)
	Integer getLastId();
						  

}

























