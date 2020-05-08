package pe.upc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetallePlatoReserva")
public class DetallePlatoReserva implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Iddetalleplatoreserva;
	
	private static final long serialVersionUID = 1L;
	

	@ManyToOne
	@JoinColumn
	private Reserva reserva;
	

	@ManyToOne
	@JoinColumn
	private PlatoPersonalizado platopersonalizado;
	
	private double precioplato;

	public Long getIddetalleplatoreserva() {
		return Iddetalleplatoreserva;
	}

	public void setIddetalleplatoreserva(Long iddetalleplatoreserva) {
		Iddetalleplatoreserva = iddetalleplatoreserva;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public PlatoPersonalizado getPlatopersonalizado() {
		return platopersonalizado;
	}

	public void setPlatopersonalizado(PlatoPersonalizado platopersonalizado) {
		this.platopersonalizado = platopersonalizado;
	}

	public double getPrecioplato() {
		return precioplato;
	}

	public void setPrecioplato(double precioplato) {
		this.precioplato = precioplato;
	}
}
