package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.MozoBusiness;
import pe.upc.business.UsuarioBusiness;

import pe.upc.model.entity.Mozo;
import pe.upc.model.entity.Usuario;
import pe.upc.util.Message;

@Named
@SessionScoped
public class MozoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MozoBusiness mozoBusiness;
	
	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	private Mozo mozo;
	private List<Mozo> mozos;
	private Mozo mozoSelect;
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private Usuario usuarioSelect;
	
	private String filtername;
	
	@PostConstruct
	public void init() {
		
		mozo = new Mozo();
		
		mozos = new ArrayList<Mozo>();
		
		usuario = new Usuario();
		
		usuarios = new ArrayList<Usuario>();
		
		getAllMozos();
	}
	
	public void getAllMozos() {
		try {
			mozos=mozoBusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar mozos : " + e.getMessage());
		}
	}
	
	public String newMozo(){
		try{
			this.usuarios=usuarioBusiness.getAll();
		}
		catch(Exception ex){
			//
		}
		return "insertMozo.xhtml";
	}
	
	public String listMozo(){
		return "listmozo.xhtml";
	}
	
	public String saveMozo() {
		String view = "";
		try {
			if(mozo.getIdMozo() != null) {
				mozo.setUsuario(usuario);
				mozoBusiness.update(mozo);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				mozo.setUsuario(usuario);
				mozoBusiness.insert(mozo);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllMozos();
			resetForm();
			view = "listmozo";
		}
		catch(Exception ex) {
			//Clase Utilitario
		}
		return view;
	}
	
	public String editMozo(){
		String view = "";
		try{
			if (this.mozoSelect != null) {
				this.mozo = mozoSelect;
				view = "mozo/update";
			}
			else {
				Message.messageError("Debe seleccionar un mozo");
			}
		}
		catch(Exception ex){
			Message.messageError("Error en mozo seleccionado: " + ex.getMessage());
		}
		return view;
	}
	
	public String deleteMozo() {
		
		String view = "";
		try{
			this.mozo = mozoSelect;
			mozoBusiness.delete(this.mozo);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllMozos();
			view = "listmozo";
		}
		catch(Exception ex){
			Message.messageError("Error en Mozo : " + ex.getMessage());
		}
		return view;
	}
	
	public void resetForm() {
		this.filtername = "";
	}
	
	public void searchMozoByName() {
		try {
			mozos = mozoBusiness.findByName(this.filtername.trim());
			resetForm();
			if (mozos.isEmpty()) {
				Message.messageInfo("No se encontraron mozos");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error al buscar Mozo: " + ex.getMessage());
		}		
	}
	
	public void selectMozo(SelectEvent e){
		this.mozoSelect = (Mozo)e.getObject();
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public List<Mozo> getMozos() {
		return mozos;
	}

	public void setMozos(List<Mozo> mozos) {
		this.mozos = mozos;
	}

	public Mozo getMozoSelect() {
		return mozoSelect;
	}

	public void setMozoSelect(Mozo mozoSelect) {
		this.mozoSelect = mozoSelect;
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
	
	
}
