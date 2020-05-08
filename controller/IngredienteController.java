package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.IngredientesBusiness;

import pe.upc.model.entity.Ingrediente;
import pe.upc.util.Message;

@Named
@SessionScoped
public class IngredienteController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IngredientesBusiness ingredientebusiness;
	
	private Ingrediente ingrediente;
	private List<Ingrediente> ingredientes;
	private Ingrediente ingredienteselect;
	
	private String filtername;
	
	@PostConstruct
	public void init() {
		
		ingrediente = new Ingrediente();
		
		ingredientes = new ArrayList<Ingrediente>();
		
		getAllIngredientes();
	}
	
	public void getAllIngredientes() {
		try {
			ingredientes = ingredientebusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar Ingredientes : " + e.getMessage());
		}
	}
	
	public String listIngrediente() {
		return "listingrediente.xhtml";
	}
	
	public String saveIngrediente(){
		String view = "";
		try {
			if(ingrediente.getIdingrediente()!=null){
				ingredientebusiness.update(ingrediente);	
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				ingredientebusiness.insert(ingrediente);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllIngredientes();
			resetForm();
			view = "listingrediente";
				
		}
		catch(Exception ex){
		}
		return view;
	}
	
	public String editIngrediente(){
		String view = "";
		try{
			if (this.ingredienteselect != null) {
				this.ingrediente = ingredienteselect;
				view = "ingrediente/update";
			}
			else {
				Message.messageError("Debe seleccionar un ingrediente");
			}
		}
		catch(Exception ex){
			Message.messageError("Error en ingrediente seleccionado: " + ex.getMessage());
		}
		return view;
	}
	
	public String deleteIngrediente() {
		
		String view = "";
		try{
			this.ingrediente = ingredienteselect;
			ingredientebusiness.delete(this.ingrediente);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllIngredientes();
			view = "listingrediente";
		}
		catch(Exception ex){
			Message.messageError("Error en Ingrediente : " + ex.getMessage());
		}
		return view;
	}
	
	public void resetForm() {
		this.filtername = "";
		this.ingrediente = new Ingrediente();
	}
	
	public void searchIngredienteByName() {
		try {
			ingredientes = ingredientebusiness.findByName(this.filtername.trim());
			resetForm();
			if (ingredientes.isEmpty()) {
				Message.messageInfo("No se encontraron ingredientes");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error al buscar Ingrediente: " + ex.getMessage());
		}		
	}
	
	public void selectIngrediente(SelectEvent e){
		this.ingredienteselect = (Ingrediente)e.getObject();
	}

	public IngredientesBusiness getIngredientebusiness() {
		return ingredientebusiness;
	}

	public void setIngredientebusiness(IngredientesBusiness ingredientebusiness) {
		this.ingredientebusiness = ingredientebusiness;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Ingrediente getIngredienteselect() {
		return ingredienteselect;
	}

	public void setIngredienteselect(Ingrediente ingredienteselect) {
		this.ingredienteselect = ingredienteselect;
	}

	public String getFiltername() {
		return filtername;
	}

	public void setFiltername(String filtername) {
		this.filtername = filtername;
	}
}
