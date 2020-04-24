package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Moso")
public class Moso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMoso;
	
	@Column(name="nombreMoso", nullable = false, length=30)
	private String nombreMoso;
	
	@Column(name="apellidoMoso", nullable = false, length=30)
	private String apellidoMoso;
	
	@Column(name="passMoso", nullable = false, length=30)
	private String passMoso;

	public Moso() {
		super();
	}

	public int getIdMoso() {
		return idMoso;
	}

	public void setIdMoso(int idMoso) {
		this.idMoso = idMoso;
	}

	public String getNombreMoso() {
		return nombreMoso;
	}

	public void setNombreMoso(String nombreMoso) {
		this.nombreMoso = nombreMoso;
	}

	public String getApellidoMoso() {
		return apellidoMoso;
	}

	public void setApellidoMoso(String apellidoMoso) {
		this.apellidoMoso = apellidoMoso;
	}
	
	public String getpassMoso() {
		return passMoso;
	}

	public void setpassMoso(String passMoso) {
		this.passMoso = passMoso;
	}
	
}
