package es.proyectoODS.api.entity;

import es.proyectoODS.api.dto.IngredienteDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredientes")
public class IngredienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ingrediente;

    @Column
    private String ingrediente;

    @Column
    private Double cantidad;

    @Column
    private String unidades;
    
    @Column 
    private Integer id_receta;

    /*@ManyToOne
    @JoinColumn(name = "id_plato", nullable = false)
    private RecetaEntity plato;
	*/
    
    
    
    // Getters y Setters
    public Integer getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(Integer idIngrediente) {
        this.id_ingrediente = idIngrediente;
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

    public Integer getId_receta() {
		return id_receta;
	}

	public void setId_receta(Integer id_receta) {
		this.id_receta = id_receta;
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

    public static IngredienteEntity parseToEntity(IngredienteDto ingredienteDto) {
	    IngredienteEntity ingrediente = new IngredienteEntity();
	    ingrediente.setIngrediente(ingredienteDto.getIngrediente());
	    ingrediente.setId_ingrediente(ingredienteDto.getId_ingrediente());
	    ingrediente.setCantidad(ingredienteDto.getCantidad());
	    ingrediente.setUnidades(ingredienteDto.getUnidades());
	    ingrediente.setId_receta(ingredienteDto.getId_receta());
	    return ingrediente;
	}
}
