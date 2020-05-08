package pe.upc.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table; 

@Entity
@Table(name = "platos")
public class Plato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idplato;
	
	private String nombreplato;
	
	private double preciobaseplato;
	
	@OneToMany(mappedBy = "plato", cascade = CascadeType.ALL)
	private Set<PlatoPersonalizado> platoPersonalizados;
	
	@ManyToOne
	@JoinColumn(name="idcarta", nullable=false)
	private Carta carta;

	public Long getIdplato() {
		return idplato;
	}

	public void setIdplato(Long idplato) {
		this.idplato = idplato;
	}

	public String getNombreplato() {
		return nombreplato;
	}

	public void setNombreplato(String nombreplato) {
		this.nombreplato = nombreplato;
	}

	public double getPreciobaseplato() {
		return preciobaseplato;
	}

	public void setPreciobaseplato(double preciobaseplato) {
		this.preciobaseplato = preciobaseplato;
	}

	public Set<PlatoPersonalizado> getPlatoPersonalizados() {
		return platoPersonalizados;
	}

	public void setPlatoPersonalizados(Set<PlatoPersonalizado> platoPersonalizados) {
		this.platoPersonalizados = platoPersonalizados;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	
}