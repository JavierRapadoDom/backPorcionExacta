package es.proyectoODS.api.dto;

import java.time.LocalDateTime;

import es.proyectoODS.api.entity.UsuarioEntity;

public class UsuarioDto {

	   private Integer id;
	   private String nombre;
	   private String apellidos;
	   private String email;
	   private String contraseña;
	   private LocalDateTime fecha_registro;
	   
	  



	public UsuarioDto() {

		}
	   
	   
	   
		public UsuarioDto(String nombre, String apellidos, String email) {
			super();
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.email = email;
		}
		
		
		
		
		
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	
	 public String getContraseña() {
		return contraseña;
	}



	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public LocalDateTime getFecha_registro() {
		return fecha_registro;
	}



	public void setFecha_registro(LocalDateTime fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	public static UsuarioDto parseToDto(UsuarioEntity usuarioEntity) {
	    UsuarioDto usuario = new UsuarioDto();
	    usuario.setId(usuarioEntity.getId());
	    usuario.setNombre(usuarioEntity.getNombre());
	    usuario.setApellidos(usuarioEntity.getApellidos());
	    usuario.setEmail(usuarioEntity.getEmail());
	    usuario.setContraseña(usuarioEntity.getContraseña());	    
	    usuario.setFecha_registro(usuarioEntity.getFecha_registro());

	    return usuario;
	}
	
	    

	    
	    
}

