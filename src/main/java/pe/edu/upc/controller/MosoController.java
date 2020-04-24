package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Moso;
import pe.edu.upc.service.IMosoService;

@Named
@RequestScoped
public class MosoController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IMosoService mService;
	private Moso Moso;
	List<Moso> listaMosos;

	@PostConstruct
	public void init() {
		this.listaMosos = new ArrayList<Moso>();
		this.Moso = new Moso();
		this.listar();
	}
	
	// metodos
	public String nuevoMoso() {
		this.setMoso(new Moso());
		return "Moso.xhtml";
	}
	public void insertar() {
		try {

			mService.insertar(Moso);
			limpiarMoso();

			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listar() {
		try {
			listaMosos = mService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarMoso() {
		this.init();
	}
	public void eliminar(Moso mo) {
		try {
			mService.eliminar(mo.getIdMoso());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	// get y set
	public Moso getMoso() {
		return Moso;
	}

	public void setMoso(Moso Moso) {
		this.Moso = Moso;
	}

	public List<Moso> getListaMosos() {
		return listaMosos;
	}

	public void setListaMosos(List<Moso> listaMosos) {
		this.listaMosos = listaMosos;
	}

}
