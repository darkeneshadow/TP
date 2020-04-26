package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ingrediente")
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIngrediente;
	
	@Column(name="nombre", nullable = false, length=30)
	private String nombre;
	
	private int precioingrediente;

	public Ingrediente() {
		super();
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecioIngrediente() {
		return precioingrediente;
	}

	public void setPrecioIngrediente(int precioingrediente) {
		this.precioingrediente = precioingrediente;
	} 
	
}
