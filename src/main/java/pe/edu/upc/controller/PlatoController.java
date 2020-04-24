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
	private Plato Plato;
	List<Plato> listaPlatos;

	@PostConstruct
	public void init() {
		this.listaPlatos = new ArrayList<Plato>();
		this.Plato = new Plato();
		this.listar();
	}
	
	// metodos
	public String nuevoPlato() {
		this.setPlato(new Plato());
		return "Plato.xhtml";
	}
	public void insertar() {
		try {

			pService.insertar(Plato);
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
		return Plato;
	}

	public void setPlato(Plato Plato) {
		this.Plato = Plato;
	}

	public List<Plato> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(List<Plato> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

}
