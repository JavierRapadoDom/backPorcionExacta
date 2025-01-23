package es.proyectoODS.api.dto;

import java.time.LocalDateTime;

import es.proyectoODS.api.entity.RecetaEntity;
import lombok.Data;

@Data
public class RecetaDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer num_personas;
    private String tiempo_de_preparacion;

	
    private String pasos;
    private Integer id_usuario;
    private LocalDateTime fecha_creacion;
    
    //private List<IngredienteDto> ingredientes; 
    
   
    
    public RecetaDto() {
		
	}


	public RecetaDto(String nombre, String descripcion, Integer num_personas, String tiempo_de_preparacion,
			String pasos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.num_personas = num_personas;
		this.tiempo_de_preparacion = tiempo_de_preparacion;
		this.pasos = pasos;
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
	public LocalDateTime getFecha_creacion() {
		return fecha_creacion;
	}


	public void setFecha_creacion(LocalDateTime fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getNum_personas() {
		return num_personas;
	}
	public void setNum_personas(Integer num_personas) {
		this.num_personas = num_personas;
	}
	/*public List<IngredienteDto> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<IngredienteDto> ingredientes) {
		this.ingredientes = ingredientes;
	}
	*/
	public String getPasos() {
		return pasos;
	}
	public void setPasos(String pasos) {
		this.pasos = pasos;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer idUsuario) {
		this.id_usuario = idUsuario;
	}
	public Integer getId() {
		return id;
	}
    public String getTiempo_de_preparacion() {
		return tiempo_de_preparacion;
	}
	public void setTiempo_de_preparacion(String tiempo_de_preparacion) {
		this.tiempo_de_preparacion = tiempo_de_preparacion;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public RecetaDto parseToDto(RecetaEntity recetaEntity) {
	    RecetaDto receta = new RecetaDto();
	    receta.setId(recetaEntity.getId());
	    receta.setNombre(recetaEntity.getNombre());
	    receta.setDescripcion(recetaEntity.getDescripcion());
	    receta.setTiempo_de_preparacion(recetaEntity.getTiempo_de_preparacion());
	    receta.setNum_personas(recetaEntity.getNum_personas());
	    receta.setPasos(recetaEntity.getPasos());
	    receta.setFecha_creacion(recetaEntity.getFechaCreacion());
	    receta.setId_usuario(recetaEntity.getId_usuario());
	    return receta;
	}
	
}


