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
@Table(name = "Plato_Personalizado")
public class Plato_Personalizado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlatopersonalizado;
	
	@OneToOne
	@JoinColumn(name = "idPlato", nullable = false)
	private Plato plato;
	
	@OneToOne
	@JoinColumn(name = "idIngrediente", nullable = false)
	private Ingrediente ingrediente;
	
	private int monto;

	public Plato_Personalizado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plato_Personalizado(int idPlatopersonalizado, Plato plato, Ingrediente ingrediente, int monto) {
		super();
		this.idPlatopersonalizado = idPlatopersonalizado;
		this.plato = plato;
		this.ingrediente = ingrediente;
		this.monto = monto;
	}

	public int getIdPlatopersonalizado() {
		return idPlatopersonalizado;
	}

	public void setIdPlatopersonalizado(int idPlatopersonalizado) {
		this.idPlatopersonalizado = idPlatopersonalizado;
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

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}
	
}
