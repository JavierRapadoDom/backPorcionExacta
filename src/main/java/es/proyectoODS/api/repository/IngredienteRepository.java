package es.proyectoODS.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.proyectoODS.api.entity.IngredienteEntity;
import jakarta.transaction.Transactional;

public interface IngredienteRepository extends JpaRepository<IngredienteEntity, Integer> {
	
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO ingredientes (ingrediente, cantidad, unidades, id_receta)"
	
			+ " VALUES (:ingrediente, :cantidad, :unidades, :id_receta)", nativeQuery = true)
	
	void addIngrediente(@Param("ingrediente") String ingrediente, @Param("cantidad") Double cantidad, @Param("unidades") String unidades,
				   
				   @Param("id_receta") Integer id_receta);
	
	@Query(value = "SELECT * FROM ingredientes WHERE id_receta = :id_receta", nativeQuery = true)
    List<IngredienteEntity> getIngredientes(@Param("id_receta") Integer id_receta);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE ingredientes SET ingrediente = :ingrediente, cantidad = :cantidad, unidades = :unidades" +
	               " WHERE id_receta = :id_receta", nativeQuery = true)
	void updateReceta(@Param("id_receta") Integer id_receta,
	                  @Param("ingrediente") String ingrediente,
	                  @Param("cantidad") Double cantidad,
	                  @Param("unidades") String unidades);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM ingredientes WHERE id_ingrediente = :id_ingrediente", nativeQuery = true)
	void deleteIngrediente(@Param("id_ingrediente") Integer id_ingrediente);

}
