package es.proyectoODS.api.entity;

import java.time.LocalDateTime;

import es.proyectoODS.api.dto.UsuarioDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String email;

    @Column
    private String contraseña;

    @Column
    private LocalDateTime fecha_registro;
    
    @PrePersist
    protected void onCreate() {
    	this.fecha_registro = LocalDateTime.now();
    }

    
    
    
    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
    
    public static UsuarioEntity parseToEntity(UsuarioDto usuarioDto) {
	    UsuarioEntity usuario = new UsuarioEntity();
	    usuario.setNombre(usuarioDto.getNombre());
	    usuario.setApellidos(usuarioDto.getApellidos());
	    usuario.setEmail(usuarioDto.getEmail());
	    usuario.setContraseña(usuarioDto.getContraseña());
	    usuario.setFecha_registro(usuarioDto.getFecha_registro());
	    usuario.setId(usuarioDto.getId());
	    return usuario;
	}
    
    
    
    
}
