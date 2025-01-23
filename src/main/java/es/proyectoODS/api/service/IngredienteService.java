package es.proyectoODS.api.service;

import java.util.List;

import es.proyectoODS.api.dto.IngredienteDto;

public interface IngredienteService {
	void createIngrediente(IngredienteDto ingredienteDto, Integer id_receta);
    List<IngredienteDto> getIngredientes(Integer id_receta);
    void updateIngrediente(Integer id_receta, IngredienteDto ingrediente);
    void deleteIngrediente(Integer id_ingrediente);
}
