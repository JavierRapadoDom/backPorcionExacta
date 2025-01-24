package es.proyectoODS.api.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.proyectoODS.api.dto.RecetaDto;
import es.proyectoODS.api.entity.RecetaEntity;
import es.proyectoODS.api.repository.RecetaRepository;
import es.proyectoODS.api.service.RecetaService;


@Service 
public class RecetaServiceImpl implements RecetaService {
	
	@Autowired
	private RecetaRepository rr;

	
	@Override
	public Integer createReceta(RecetaDto recetaDto, Integer id_usuario) {
		Integer salida;
		RecetaEntity receta = RecetaEntity.parseToEntity(recetaDto);
		System.out.print(rr.getLastId());
		salida = rr.getLastId();
		if(salida == null) {
			salida = 0;
		}
		rr.addReceta(salida+1,receta.getNombre(), receta.getDescripcion(), receta.getTiempo_de_preparacion(), receta.getNum_personas(),
				receta.getPasos(),LocalDateTime.now(),id_usuario);
		
		return salida+1;
	
	}

	@Override
	public List<RecetaDto> getRecetasByUser(Integer id_usuario) {

        List<RecetaEntity> recetas = rr.getRecetasByUser(id_usuario);


        List<RecetaDto> recetaDtos = recetas.stream().map(receta -> 
        									{RecetaDto recetaDto = new RecetaDto(); // Crear una instancia
                                                return recetaDto.parseToDto(receta); // Llamar al método de instancia
                                            }).collect(Collectors.toList());

        return recetaDtos; 
    }

	@Override
	public RecetaDto getRecetaById(Integer id) {
		RecetaEntity receta = rr.getRecetaById(id);
		RecetaDto salida = new RecetaDto();
		salida = salida.parseToDto(receta);
		return salida;
	}
/*
	@Override
	public RecetaDto getRecetaById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
	@Override
	public void updateReceta(Integer id, RecetaDto recetaDto) {
		RecetaEntity receta = RecetaEntity.parseToEntity(recetaDto);
		rr.updateReceta(id, receta.getNombre(), receta.getDescripcion(), receta.getTiempo_de_preparacion(), receta.getNum_personas(),
				receta.getPasos());
	}

	@Override
	public void deleteReceta(Integer id) {
		rr.deleteReceta(id);
		
	}

	
	
	

}
