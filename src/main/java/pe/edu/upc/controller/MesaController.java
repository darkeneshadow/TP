package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Mesa;
import pe.edu.upc.service.IMesaService;

@Named
@RequestScoped
public class MesaController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IMesaService mService;
	private Mesa Mesa;
	List<Mesa> listaMesas;

	@PostConstruct
	public void init() {
		this.listaMesas = new ArrayList<Mesa>();
		this.Mesa = new Mesa();
		this.listar();
	}
	
	// metodos
	public String nuevoMesa() {
		this.setMesa(new Mesa());
		return "Mesa.xhtml";
	}
	public void insertar() {
		try {

			mService.insertar(Mesa);
			limpiarMesa();

			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listar() {
		try {
			listaMesas = mService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarMesa() {
		this.init();
	}
	public void eliminar(Mesa me) {
		try {
			mService.eliminar(me.getIdMesa());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	// get y set
	public Mesa getMesa() {
		return Mesa;
	}

	public void setMesa(Mesa Mesa) {
		this.Mesa = Mesa;
	}

	public List<Mesa> getListaMesas() {
		return listaMesas;
	}

	public void setListaMesas(List<Mesa> listaMesas) {
		this.listaMesas = listaMesas;
	}

}
