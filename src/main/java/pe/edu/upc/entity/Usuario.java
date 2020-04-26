package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombres", nullable = false, length=30)
	private String nombres;
	
	@Column(name="apellidos", nullable = false, length=30)
	private String apellidos;
	
	@Column(name="password", nullable = false, length=30)
	private String password;

	public Usuario() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getnombres() {
		return nombres;
	}

	public void setnombres(String nombres) {
		this.nombres = nombres;
	}

	public String getapellidos() {
		return apellidos;
	}

	public void setapellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
}
