package pe.upc.model.entity;

import java.io.Serializable;
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
@Table(name="PlatoPersonalizado")
public class PlatoPersonalizado implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idplatopersonalizado;
	
	@OneToMany(mappedBy = "platopersonalizado", cascade = CascadeType.ALL)
	private Set<DetallePlatoReserva> detallePlatoReservas;
	
	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JoinColumn
	private Plato plato;
	

	@ManyToOne
	@JoinColumn
	private Ingrediente ingrediente;

	private double precioplato;

	public Long getIdplatopersonalizado() {
		return idplatopersonalizado;
	}

	public void setIdplatopersonalizado(Long idplatopersonalizado) {
		this.idplatopersonalizado = idplatopersonalizado;
	}

	public Set<DetallePlatoReserva> getDetallePlatoReservas() {
		return detallePlatoReservas;
	}

	public void setDetallePlatoReservas(Set<DetallePlatoReserva> detallePlatoReservas) {
		this.detallePlatoReservas = detallePlatoReservas;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public double getPrecioplato() {
		return precioplato;
	}

	public void setPrecioplato(double precioplato) {
		this.precioplato = precioplato;
	}

}
