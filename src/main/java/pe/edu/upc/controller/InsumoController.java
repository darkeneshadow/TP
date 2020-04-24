package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Insumo;
import pe.edu.upc.service.IInsumoService;

@Named
@RequestScoped
public class InsumoController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IInsumoService iService;
	private Insumo Insumo;
	List<Insumo> listaInsumos;

	@PostConstruct
	public void init() {
		this.listaInsumos = new ArrayList<Insumo>();
		this.Insumo = new Insumo();
		this.listar();
	}
	
	// metodos
	public String nuevoInsumo() {
		this.setInsumo(new Insumo());
		return "Insumo.xhtml";
	}
	public void insertar() {
		try {

			iService.insertar(Insumo);
			limpiarInsumo();

			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listar() {
		try {
			listaInsumos = iService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarInsumo() {
		this.init();
	}
	public void eliminar(Insumo in) {
		try {
			iService.eliminar(in.getIdInsumo());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	// get y set
	public Insumo getInsumo() {
		return Insumo;
	}

	public void setInsumo(Insumo Insumo) {
		this.Insumo = Insumo;
	}

	public List<Insumo> getListaInsumos() {
		return listaInsumos;
	}

	public void setListaInsumos(List<Insumo> listaInsumos) {
		this.listaInsumos = listaInsumos;
	}

}
