package es.proyectoODS.api.entity;


import java.time.LocalDateTime;

import es.proyectoODS.api.dto.RecetaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

	@Entity
	@Table(name = "recetas")
	@Getter
	@Setter
	public class RecetaEntity {

	    @Id
	    private Integer id;
	    
	    @Column
	    private String nombre;

	    @Column
	    private String descripcion;

	    @Column
	    private String tiempo_de_preparacion;
	    
	    @Column
	    private Integer num_personas;

	    @Column
	    private String pasos;
	    
	    @Column(updatable = false)
	    private LocalDateTime fechaCreacion;
	    
	    @Column
	    private Integer id_usuario;
	    
	    @PrePersist
	    protected void onCreate() {
	    	this.fechaCreacion = LocalDateTime.now();
	    }

	    
	    
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

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getTiempo_de_preparacion() {
			return tiempo_de_preparacion;
		}

		public void setTiempo_de_preparacion(String tiempo_de_preparacion) {
			this.tiempo_de_preparacion = tiempo_de_preparacion;
		}

		public String getPasos() {
			return pasos;
		}

		public void setPasos(String pasos) {
			this.pasos = pasos;
		}

		public LocalDateTime getFechaCreacion() {
			return fechaCreacion;
		}

		public void setFechaCreacion(LocalDateTime fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}

		public Integer getId_usuario() {
			return id_usuario;
		}

		public void setId_usuario(Integer id_usuario) {
			this.id_usuario = id_usuario;
		}
		
	    
		public Integer getNum_personas() {
			return num_personas;
		}



		public void setNum_personas(Integer num_personas) {
			this.num_personas = num_personas;
		}



		public static RecetaEntity parseToEntity(RecetaDto recetaDto) {
		    RecetaEntity receta = new RecetaEntity();
		    receta.setNombre(recetaDto.getNombre());
		    receta.setDescripcion(recetaDto.getDescripcion());
		    receta.setTiempo_de_preparacion(recetaDto.getTiempo_de_preparacion());
		    receta.setNum_personas(recetaDto.getNum_personas());
		    receta.setPasos(recetaDto.getPasos());
		    receta.setFechaCreacion(LocalDateTime.now());
		    receta.setId_usuario(recetaDto.getId_usuario());
		    return receta;
		}

	    
	}


