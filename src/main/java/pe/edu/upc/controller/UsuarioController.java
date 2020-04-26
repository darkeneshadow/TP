package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Usuario;
import pe.edu.upc.service.IUsuarioService;

@Named
@RequestScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IUsuarioService uService;
	private Usuario usuario;
	List<Usuario> listaUsuarios;

	@PostConstruct
	public void init() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.listar();
	}
	
	// metodos
	public String nuevoUsuario() {
		this.setUsuario(new Usuario());
		return "Usuario.xhtml";
	}
	public void insertar() {
		try {

			uService.insertar(usuario);
			limpiarUsuario();

			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listar() {
		try {
			listaUsuarios = uService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarUsuario() {
		this.init();
	}
	public void eliminar(Usuario us) {
		try {
			uService.eliminar(us.getIdUsuario());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	// get y set
	public Usuario getMoso() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
