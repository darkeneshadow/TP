package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mozo")
public class Mozo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMozo;
	
	@OneToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	public Mozo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mozo(int idMozo, Usuario usuario) {
		super();
		this.idMozo = idMozo;
		this.usuario = usuario;
	}

	public int getIdMozo() {
		return idMozo;
	}

	public void setIdMozo(int idMozo) {
		this.idMozo = idMozo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
