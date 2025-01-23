package es.proyectoODS.api.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.proyectoODS.api.dto.UsuarioDto;
import es.proyectoODS.api.entity.UsuarioEntity;
import es.proyectoODS.api.repository.UsuarioRepository;
import es.proyectoODS.api.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository ur;

	@Override
	public void createUsuario(UsuarioDto usuarioDto) {
		
		UsuarioEntity usuario = UsuarioEntity.parseToEntity(usuarioDto);
		
		ur.addUsuario(usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getContraseña(),LocalDateTime.now());
			
			
	}
		
	

	@Override
	public void updateUsuario(Integer id, UsuarioDto usuarioDto) {
		UsuarioEntity usuario = UsuarioEntity.parseToEntity(usuarioDto);
		ur.updateUsuario(id, usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getContraseña());
		
	}

	@Override
	public void deleteUsuario(Integer id) {
		ur.deleteUsuario(id);
		
	}

	@Override
	public UsuarioDto getUsuario(Integer id) {

        UsuarioEntity usuario = ur.getUsuario(id);


        UsuarioDto usuarioDto = UsuarioDto.parseToDto(usuario);

        return usuarioDto; 
    }

}
