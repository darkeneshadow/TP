package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.MesaBusiness;

import pe.upc.model.entity.Mesa;
import pe.upc.util.Message;

@Named
@SessionScoped
public class MesaController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MesaBusiness mesaBusiness;
	
	private Mesa mesa;
	private List<Mesa> mesas;
	private Mesa mesaSelect;
	
	private String filtername;
	
	@PostConstruct
	public void init() {
		
		mesa = new Mesa();
		
		mesas = new ArrayList<Mesa>();
		
		getAllMesas();
		
	}
	
	public void getAllMesas() {
		try {
			mesas=mesaBusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar mesas : " + e.getMessage());
		}
	}
	
	public String listMesa(){
		return "listmesa.xhtml";
	}
	
	public String saveMesa() {
		String view = "";
		try {
			if(mesa.getIdMesa() != null) {
				mesaBusiness.update(mesa);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				mesaBusiness.insert(mesa);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllMesas();
			resetForm();
			view = "listmesa";
		}
		catch(Exception ex) {
		}
		return view;
	}
	
	public String editMesa(){
		String view = "";
		try{
			if (this.mesaSelect != null) {
				this.mesa = mesaSelect;
				view = "mesa/update";
			}
			else {
				Message.messageError("Debe seleccionar un mesa");
			}
		}
		catch(Exception ex){
			Message.messageError("Error en mesa seleccionado: " + ex.getMessage());
		}
		return view;
	}
	
	public String deleteMesa() {
		
		String view = "";
		try{
			this.mesa = mesaSelect;
			mesaBusiness.delete(this.mesa);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllMesas();
			view = "listmesa";
		}
		catch(Exception ex){
			Message.messageError("Error en Mesa : " + ex.getMessage());
		}
		return view;
	}
	
	public void resetForm() {
		
		this.filtername = "";
		
		this.mesa = new Mesa();
	}
	
	public void searchMesaByName() {
		try {
			mesas = mesaBusiness.findByEstado(this.filtername.trim());
			resetForm();
			if (mesas.isEmpty()) {
				Message.messageInfo("No se encontraron mesas");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error al buscar Mesa: " + ex.getMessage());
		}		
	}
	
	public void selectMesa(SelectEvent e){
		this.mesaSelect = (Mesa)e.getObject();
	}
}
