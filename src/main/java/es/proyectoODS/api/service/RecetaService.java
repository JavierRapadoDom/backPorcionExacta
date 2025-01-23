package es.proyectoODS.api.service;

import java.util.List;

import es.proyectoODS.api.dto.RecetaDto;


public interface RecetaService {
	Integer createReceta(RecetaDto recetaDto, Integer id_usuario);
    List<RecetaDto> getRecetasByUser(Integer id_usuario);
    void updateReceta(Integer id, RecetaDto receta);
    void deleteReceta(Integer id);
    RecetaDto getRecetaById(Integer id);
}
