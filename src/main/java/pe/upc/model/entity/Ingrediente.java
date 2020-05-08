package pe.upc.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingredientes")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idingrediente;
	
	@OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL)
	private Set<PlatoPersonalizado> platoPersonalizados;
	
	private String nombreingrediente;
	
	private double precioingrediente;

	public Long getIdingrediente() {
		return idingrediente;
	}

	public void setIdingrediente(Long idingrediente) {
		this.idingrediente = idingrediente;
	}

	public Set<PlatoPersonalizado> getPlatoPersonalizados() {
		return platoPersonalizados;
	}

	public void setPlatoPersonalizados(Set<PlatoPersonalizado> platoPersonalizados) {
		this.platoPersonalizados = platoPersonalizados;
	}

	public String getNombreingrediente() {
		return nombreingrediente;
	}

	public void setNombreingrediente(String nombreingrediente) {
		this.nombreingrediente = nombreingrediente;
	}

	public double getPrecioingrediente() {
		return precioingrediente;
	}

	public void setPrecioingrediente(double precioingrediente) {
		this.precioingrediente = precioingrediente;
	}
	
}
