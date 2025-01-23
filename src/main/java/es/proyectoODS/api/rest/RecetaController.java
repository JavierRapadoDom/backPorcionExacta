package es.proyectoODS.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.proyectoODS.api.dto.RecetaDto;
import es.proyectoODS.api.service.impl.RecetaServiceImpl;

@RestController
@RequestMapping("/api/recetas")

public class RecetaController {
    @Autowired
    private RecetaServiceImpl recetaService;
    
    

    @PostMapping("/create")
    public Integer createReceta(@RequestBody RecetaDto recetaDto, @RequestParam(name = "id_usuario") String id_usuario) {
    	Integer salida;
        salida = recetaService.createReceta(recetaDto, Integer.valueOf(id_usuario));
        return salida;
         
    }

    
    
    @GetMapping("/getRecetas")
    public List<RecetaDto> getRecetasByUser(@RequestParam(name = "id_usuario") String id_usuario) {
    	 List<RecetaDto> recetas = recetaService.getRecetasByUser(Integer.valueOf(id_usuario));
        return recetas;
    }
    
    @GetMapping("/getRecetaById")
    public RecetaDto getRecetaById(@RequestParam(name = "id") String id) {
    	 RecetaDto receta = recetaService.getRecetaById(Integer.valueOf(id));
        return receta;
    }
    
    
    
    @PutMapping("/update")
    public void updateReceta(@RequestParam(name = "id") String id, @RequestBody RecetaDto recetaDto) {
    	recetaService.updateReceta(Integer.valueOf(id), recetaDto);
    }

    
    
    /*
    @GetMapping("/{id}")
    public RecetaDto getRecetaById(@PathVariable Integer id) {
        return recetaService.getRecetaById(id);
    }
    */
    
    
    @DeleteMapping("/delete")
    public void deleteReceta(@RequestParam(name = "id") String id) {
        recetaService.deleteReceta(Integer.valueOf(id));
    }

}
