package es.proyectoODS.api.rest;

import java.util.List;
import java.util.Map;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import es.proyectoODS.api.dto.UsuarioDto;
import es.proyectoODS.api.entity.UsuarioEntity;
import es.proyectoODS.api.repository.UsuarioRepository;
import es.proyectoODS.api.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
    private UsuarioServiceImpl usuarioService;
	
	@PostMapping("/create")
    public void createUsuario(@RequestBody UsuarioDto usuarioDto) {  	
         usuarioService.createUsuario(usuarioDto);
    }
	
	@PutMapping("/update")
    public void updateUsuairo(@RequestParam(name = "id") String id, @RequestBody UsuarioDto usuarioDto) {
    	usuarioService.updateUsuario(Integer.valueOf(id), usuarioDto);
    }
	
	@DeleteMapping("/delete")
    public void deleteUsuario(@RequestParam(name = "id") String id) {
        usuarioService.deleteUsuario(Integer.valueOf(id));
    }
	
	@GetMapping("/getUsuario")
    public UsuarioDto getUsuario(@RequestParam(name = "id") String id) {
    	 UsuarioDto usuario = usuarioService.getUsuario(Integer.valueOf(id));
        return usuario;
    }
	
	
	
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        try {
            // Convertir DTO a entidad
            UsuarioEntity usuarioEntity = UsuarioEntity.parseToEntity(usuarioDto);

            // Guardar usuario en la base de datos
            UsuarioEntity usuarioGuardado = usuarioRepository.save(usuarioEntity);

            // Convertir entidad guardada a DTO y devolverla
            UsuarioDto usuarioGuardadoDto = UsuarioDto.parseToDto(usuarioGuardado);

            return ResponseEntity.ok(usuarioGuardadoDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    
    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion(@RequestBody UsuarioDto usuarioDto) {
        try {
            // Buscar usuario por email
            java.util.Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findByEmail(usuarioDto.getEmail());

            if (usuarioOptional.isPresent()) {
                UsuarioEntity usuario = usuarioOptional.get();

                // Verificar contraseña
                if (usuario.getContraseña().equals(usuarioDto.getContraseña())) {
                    // Convertir a DTO y devolver los datos del usuario, incluida la ID
                    UsuarioDto usuarioLogeadoDto = UsuarioDto.parseToDto(usuario);
                    return ResponseEntity.ok(usuarioLogeadoDto);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                            .body(Map.of("message", "Contraseña incorrecta"));
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "Usuario no encontrado"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", e.getMessage()));
        }
    }



}
