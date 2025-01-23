package es.proyectoODS.api.service;

import es.proyectoODS.api.dto.UsuarioDto;

public interface UsuarioService {
	void createUsuario(UsuarioDto usuario);
	void updateUsuario(Integer id, UsuarioDto usuario);
	void deleteUsuario(Integer id);
	UsuarioDto getUsuario(Integer id);
}
