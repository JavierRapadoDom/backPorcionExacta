package es.proyectoODS.api.dto;

import es.proyectoODS.api.entity.IngredienteEntity;

public class IngredienteDto {

	private Integer id_ingrediente;
    private String ingrediente;
    private Double cantidad;
    private String unidades;
    private Integer id_receta;

    
    public IngredienteDto() {
    	
    }

    
    public IngredienteDto(String ingrediente, Double cantidad, String unidades) {
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
        this.unidades = unidades;
    }

    
    
    
    
    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }


	public Integer getId_ingrediente() {
		return id_ingrediente;
	}


	public void setId_ingrediente(Integer id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}


	public Integer getId_receta() {
		return id_receta;
	}


	public void setId_receta(Integer id_receta) {
		this.id_receta = id_receta;
	}
    
	
	public IngredienteDto parseToDto(IngredienteEntity ingredienteEntity) {
	    IngredienteDto ingrediente = new IngredienteDto();
	    ingrediente.setId_receta(ingredienteEntity.getId_receta());
	    ingrediente.setIngrediente(ingredienteEntity.getIngrediente());
	    ingrediente.setCantidad(ingredienteEntity.getCantidad());
	    ingrediente.setId_ingrediente(ingredienteEntity.getId_ingrediente());
	    ingrediente.setUnidades(ingredienteEntity.getUnidades());
	    return ingrediente;
	}
    
}

