package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.model.entity.PlatoPersonalizado;
import pe.upc.model.entity.Ingrediente;
import pe.upc.model.entity.Plato;

import pe.upc.business.IngredientesBusiness;
import pe.upc.business.PlatoBusiness;
import pe.upc.business.PlatoPersonalizadoBusiness;

import pe.upc.util.Message;

@Named
@SessionScoped
public class PlatoPersonalizadoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PlatoPersonalizadoBusiness platopersonalizadobusiness;
	
	@Inject
	private PlatoBusiness platobusiness;
	
	@Inject
	private IngredientesBusiness ingredientebusiness;
	
	
	private PlatoPersonalizado platopersonalizado;
	private List<PlatoPersonalizado> platospersonalizados;
	private PlatoPersonalizado platopersonalizadoselect;
	
	private Plato plato;
	private List<Plato> platos;
	private Plato platoselect;
	
	private Ingrediente ingrediente;
	private List<Ingrediente> ingredientes;
	private Ingrediente ingredienteselect;
	private String filtername;
	
	@PostConstruct
	public void init() {
		
		platopersonalizado = new PlatoPersonalizado();
		
		platospersonalizados = new ArrayList<PlatoPersonalizado>();
		
		plato = new Plato();
		
		platos = new ArrayList<Plato>();
		
		ingrediente = new Ingrediente();
		
		ingredientes = new ArrayList<Ingrediente>();
		
		getAllPlatoPersonalizados();
	}
	
	public void getAllPlatoPersonalizados() {
		try {
			platospersonalizados = platopersonalizadobusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar plato personalizado : " + e.getMessage());
		}
	}
	
	public String listPlatoPersonalizado() {
		return "listplatopersonalizado.xhtml";
	}
	
	public String savePlatoPersonalizado() {
		String view = "";
		try {
			if(platopersonalizado.getIdplatopersonalizado() != null) {
				platopersonalizado.setPlato(plato);
				platopersonalizado.setIngrediente(ingrediente);
				platopersonalizadobusiness.update(platopersonalizado);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				platopersonalizado.setPlato(plato);
				platopersonalizado.setIngrediente(ingrediente);
				platopersonalizadobusiness.insert(platopersonalizado);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllPlatoPersonalizados();
			resetForm();
			view = "listplatopersonalizado";
		}
		catch(Exception ex) {
			//Clase Utilitario
		}
		return view;
	}
	
	public String editPlatoPersonalizado(){
		String view = "";
		try{
			if (this.platopersonalizadoselect != null) {
				this.platopersonalizado = platopersonalizadoselect;
				view = "platopersonalizado/update";
			}
			else {
				Message.messageError("Debe seleccionar un platopersonalizado");
			}
		}
		catch(Exception ex){
			Message.messageError("Error en platopersonalizado seleccionado: " + ex.getMessage());
		}
		return view;
	}
	
	public String deletePlatoPersonalizado() {
		
		String view = "";
		try{
			this.platopersonalizado = platopersonalizadoselect;
			platopersonalizadobusiness.delete(this.platopersonalizado);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllPlatoPersonalizados();
			view = "listplatopersonalizado";
		}
		catch(Exception ex){
			Message.messageError("Error en PlatoPersonalizado : " + ex.getMessage());
		}
		return view;
	}
	
	public void resetForm() {
		this.filtername = "";
		this.platopersonalizado = new PlatoPersonalizado();
	}
	
	public void searchPlatoPersonalizadoByName() {
		try {
			platospersonalizados = platopersonalizadobusiness.findByName(this.filtername.trim());
			resetForm();
			if (platospersonalizados.isEmpty()) {
				Message.messageInfo("No se encontraron platos personalizados");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error al buscar Platos Personalizados: " + ex.getMessage());
		}		
	}
	
	public void selectPlatoPersonalizado(SelectEvent e){
		this.platopersonalizadoselect = (PlatoPersonalizado)e.getObject();
	}

	public PlatoPersonalizadoBusiness getPlatopersonalizadobusiness() {
		return platopersonalizadobusiness;
	}

	public void setPlatopersonalizadobusiness(PlatoPersonalizadoBusiness platopersonalizadobusiness) {
		this.platopersonalizadobusiness = platopersonalizadobusiness;
	}

	public PlatoBusiness getPlatobusiness() {
		return platobusiness;
	}

	public void setPlatobusiness(PlatoBusiness platobusiness) {
		this.platobusiness = platobusiness;
	}

	public IngredientesBusiness getIngredientebusiness() {
		return ingredientebusiness;
	}

	public void setIngredientebusiness(IngredientesBusiness ingredientebusiness) {
		this.ingredientebusiness = ingredientebusiness;
	}

	public PlatoPersonalizado getPlatopersonalizado() {
		return platopersonalizado;
	}

	public void setPlatopersonalizado(PlatoPersonalizado platopersonalizado) {
		this.platopersonalizado = platopersonalizado;
	}

	public List<PlatoPersonalizado> getPlatospersonalizados() {
		return platospersonalizados;
	}

	public void setPlatospersonalizados(List<PlatoPersonalizado> platospersonalizados) {
		this.platospersonalizados = platospersonalizados;
	}

	public PlatoPersonalizado getPlatopersonalizadoselect() {
		return platopersonalizadoselect;
	}

	public void setPlatopersonalizadoselect(PlatoPersonalizado platopersonalizadoselect) {
		this.platopersonalizadoselect = platopersonalizadoselect;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	public Plato getPlatoselect() {
		return platoselect;
	}

	public void setPlatoselect(Plato platoselect) {
		this.platoselect = platoselect;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
