package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Insumo")
public class Insumo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInsumo;
	
	@Column(name="nombreInsumo", nullable = false, length=30)
	private String nombreInsumo;
	
	private int precioInsumo;

	public Insumo() {
		super();
	}

	public int getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}

	public String getNombre() {
		return nombreInsumo;
	}

	public void setNombre(String nombreInsumo) {
		this.nombreInsumo = nombreInsumo;
	}

	public int getPrecio() {
		return precioInsumo;
	}

	public void setPrecio(int precioInsumo) {
		this.precioInsumo = precioInsumo;
	} 
	
}
