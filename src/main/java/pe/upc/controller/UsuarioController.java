package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.UsuarioBusiness;

import pe.upc.model.entity.Usuario;
import pe.upc.util.Message;

@Named
@SessionScoped
public class UsuarioController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private Usuario usuarioSelect;
	
	private String filtername;
	
	@PostConstruct
	public void init() {
		
		usuario = new Usuario();
		
		usuarios = new ArrayList<Usuario>();
		
		getAllUsuarios();
	}
	
	public void getAllUsuarios() {
		try {
			usuarios=usuarioBusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar usuarios : " + e.getMessage());
		}
	}
	
	public String newUsuario(){
		try{
		}
		catch(Exception ex){
			//
		}
		return "insertUsuario.xhtml";
	}
	
	public String listUsuario(){
		return "listusuario.xhtml";
	}
	
	public String saveUsuario() {
		String view = "";
		try {
			if(usuario.getIdUsuario() != null) {
				usuarioBusiness.update(usuario);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				usuarioBusiness.insert(usuario);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllUsuarios();
			resetForm();
			view = "listusuario";
		}
		catch(Exception ex) {
			//Clase Utilitario
		}
		return view;
	}
	
	public String editUsuario(){
		String view = "";
		try{
			if (this.usuarioSelect != null) {
				this.usuario = usuarioSelect;
				view = "usuario/update";
			}
			else {
				Message.messageError("Debe seleccionar un usuario");
			}
		}
		catch(Exception ex){
			Message.messageError("Error en usuario seleccionado: " + ex.getMessage());
		}
		return view;
	}
	
	public String deleteUsuario() {
		
		String view = "";
		try{
			this.usuario = usuarioSelect;
			usuarioBusiness.delete(this.usuario);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllUsuarios();
			view = "listusuario";
		}
		catch(Exception ex){
			Message.messageError("Error en Usuario : " + ex.getMessage());
		}
		return view;
	}
	
	public void resetForm() {
		this.filtername = "";

		this.usuario = new Usuario();
	}
	
	public void searchUsuarioByName() {
		try {
			usuarios = usuarioBusiness.findByNombre(this.filtername.trim());
			resetForm();
			if (usuarios.isEmpty()) {
				Message.messageInfo("No se encontraron usuarios");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error al buscar Usuario: " + ex.getMessage());
		}		
	}
	
	public void selectUsuario(SelectEvent e){
		this.usuarioSelect = (Usuario)e.getObject();
	}

	public UsuarioBusiness getUsuarioBusiness() {
		return usuarioBusiness;
	}

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioSelect() {
		return usuarioSelect;
	}

	public void setUsuarioSelect(Usuario usuarioSelect) {
		this.usuarioSelect = usuarioSelect;
	}

	public String getFiltername() {
		return filtername;
	}

	public void setFiltername(String filtername) {
		this.filtername = filtername;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
