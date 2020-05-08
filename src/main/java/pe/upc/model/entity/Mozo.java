package pe.upc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Mozo")
public class Mozo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMozo;	
	
	@OneToOne
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario usuario;

	public Long getIdMozo() {
		return idMozo;
	}

	public void setIdMozo(Long idMozo) {
		this.idMozo = idMozo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
