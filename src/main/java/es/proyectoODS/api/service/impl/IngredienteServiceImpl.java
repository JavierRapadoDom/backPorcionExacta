package es.proyectoODS.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.proyectoODS.api.dto.IngredienteDto;
import es.proyectoODS.api.entity.IngredienteEntity;
import es.proyectoODS.api.repository.IngredienteRepository;
import es.proyectoODS.api.service.IngredienteService;

@Service

public class IngredienteServiceImpl implements IngredienteService {
	@Autowired
	private IngredienteRepository ir;

	@Override
	public void createIngrediente(IngredienteDto ingredienteDto, Integer id_receta) {
		
		IngredienteEntity ingrediente = IngredienteEntity.parseToEntity(ingredienteDto);
		
		ir.addIngrediente(ingrediente.getIngrediente(), ingrediente.getCantidad(), ingrediente.getUnidades(),
				id_receta);
		
	}

	@Override
	public List<IngredienteDto> getIngredientes(Integer id_receta) {
		List<IngredienteEntity> ingredientes = ir.getIngredientes(id_receta);


        List<IngredienteDto> ingredienteDtos = ingredientes.stream().map(ingrediente -> 
        									{IngredienteDto ingredienteDto = new IngredienteDto();
                                                return ingredienteDto.parseToDto(ingrediente); 
                                            }).collect(Collectors.toList());

        return ingredienteDtos; 
	}

	@Override
	public void updateIngrediente(Integer id_receta, IngredienteDto ingredienteDto) {
		IngredienteEntity ingrediente = IngredienteEntity.parseToEntity(ingredienteDto);
		ir.updateReceta(id_receta, ingrediente.getIngrediente(), ingrediente.getCantidad(), ingrediente.getUnidades());
		
	}

	@Override
	public void deleteIngrediente(Integer id_ingrediente) {
		ir.deleteIngrediente(id_ingrediente);
		
	}

}
