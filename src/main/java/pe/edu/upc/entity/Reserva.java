package pe.edu.upc.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reserva")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlatopersonalizado;
	
	@ManyToOne
	@JoinColumn(name = "idPlatopersonalizado", nullable = false)
	private Plato_Personalizado platopersonalizado;
	
	@OneToOne
	@JoinColumn(name = "idMesa", nullable = false)
	private Mesa mesa;
	
	@OneToOne
	@JoinColumn(name = "idCliente", nullable = false)
	private Cliente cliente;
	
	private int sillas;

	private Date FechaReserva;
	
	private Time HoraReserva;
	
	private int MontoTotal;

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reserva(int idPlatopersonalizado, Plato_Personalizado platopersonalizado, Mesa mesa, Cliente cliente,
			int sillas, Date fechaReserva, Time horaReserva, int montoTotal) {
		super();
		this.idPlatopersonalizado = idPlatopersonalizado;
		this.platopersonalizado = platopersonalizado;
		this.mesa = mesa;
		this.cliente = cliente;
		this.sillas = sillas;
		FechaReserva = fechaReserva;
		HoraReserva = horaReserva;
		MontoTotal = montoTotal;
	}

	public int getIdPlatopersonalizado() {
		return idPlatopersonalizado;
	}

	public void setIdPlatopersonalizado(int idPlatopersonalizado) {
		this.idPlatopersonalizado = idPlatopersonalizado;
	}

	public Plato_Personalizado getPlatopersonalizado() {
		return platopersonalizado;
	}

	public void setPlatopersonalizado(Plato_Personalizado platopersonalizado) {
		this.platopersonalizado = platopersonalizado;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getSillas() {
		return sillas;
	}

	public void setSillas(int sillas) {
		this.sillas = sillas;
	}

	public Date getFechaReserva() {
		return FechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		FechaReserva = fechaReserva;
	}

	public Time getHoraReserva() {
		return HoraReserva;
	}

	public void setHoraReserva(Time horaReserva) {
		HoraReserva = horaReserva;
	}

	public int getMontoTotal() {
		return MontoTotal;
	}

	public void setMontoTotal(int montoTotal) {
		MontoTotal = montoTotal;
	}
	
}
