package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Plato;
import pe.edu.upc.service.IPlatoService;

@Named
@RequestScoped
public class PlatoController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IPlatoService pService;
	private Plato plato;
	List<Plato> listaPlatos;

	@PostConstruct
	public void init() {
		this.listaPlatos = new ArrayList<Plato>();
		this.plato = new Plato();
		this.listar();
	}
	
	// metodos
	public String nuevoPlato() {
		this.setPlato(new Plato());
		return "Plato.xhtml";
	}
	public void insertar() {
		try {

			pService.insertar(plato);
			limpiarPlato();

			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listar() {
		try {
			listaPlatos = pService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarPlato() {
		this.init();
	}
	public void eliminar(Plato pl) {
		try {
			pService.eliminar(pl.getIdPlato());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	// get y set
	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public List<Plato> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaMesas(List<Plato> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

}
