package pe.upc.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carta")
public class Carta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcarta;
	
	private Date fechacarta;

	public Long getIdcarta() {
		return idcarta;
	}

	public void setIdcarta(Long idcarta) {
		this.idcarta = idcarta;
	}

	public Date getFechacarta() {
		return fechacarta;
	}

	public void setFechacarta(Date fechacarta) {
		this.fechacarta = fechacarta;
	}

}