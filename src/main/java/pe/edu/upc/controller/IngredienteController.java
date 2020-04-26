package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Ingrediente;
import pe.edu.upc.service.IIngredienteService;

@Named
@RequestScoped
public class IngredienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IIngredienteService iService;
	private Ingrediente ingrediente;
	List<Ingrediente> listaIngredientes;

	@PostConstruct
	public void init() {
		this.listaIngredientes = new ArrayList<Ingrediente>();
		this.ingrediente = new Ingrediente();
		this.listar();
	}
	
	// metodos
	public String nuevoIngrediente() {
		this.setIngrediente(new Ingrediente());
		return "Ingrediente.xhtml";
	}
	public void insertar() {
		try {

			iService.insertar(ingrediente);
			limpiarIngrediente();

			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listar() {
		try {
			listaIngredientes = iService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarIngrediente() {
		this.init();
	}
	public void eliminar(Ingrediente in) {
		try {
			iService.eliminar(in.getIdIngrediente());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	// get y set
	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public List<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaMesas(List<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

}
