package es.proyectoODS.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.proyectoODS.api.dto.IngredienteDto;
import es.proyectoODS.api.service.impl.IngredienteServiceImpl;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {
    @Autowired
    private IngredienteServiceImpl ingredienteService;
    
    @PostMapping("/create")
    public void createIngrediente(@RequestBody IngredienteDto ingredienteDto, @RequestParam(name = "id_receta") String id_receta) {
    	
         ingredienteService.createIngrediente(ingredienteDto, Integer.valueOf(id_receta));
    }
    
    @GetMapping("/getIngredientes")
    public List<IngredienteDto> getIngredientes(@RequestParam(name = "id_receta") String id_receta) {
    	List<IngredienteDto> ingredientes = ingredienteService.getIngredientes(Integer.valueOf(id_receta));
        return ingredientes;
    }
    
    @PutMapping("/update")
    public void updateReceta(@RequestParam(name = "id_receta") String id_receta, @RequestBody IngredienteDto ingredienteDto) {
    	ingredienteService.updateIngrediente(Integer.valueOf(id_receta), ingredienteDto);
    }
    
    @DeleteMapping("/delete")
    public void deleteIngrediente(@RequestParam(name = "id_ingrediente") String id_ingrediente) {
        ingredienteService.deleteIngrediente(Integer.valueOf(id_ingrediente));
    }
}
