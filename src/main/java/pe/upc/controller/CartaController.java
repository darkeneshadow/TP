package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.CartaBusiness;
import pe.upc.business.PlatoBusiness;
import pe.upc.model.entity.Carta;
import pe.upc.model.entity.Plato;
import pe.upc.util.Message;

@Named
@SessionScoped
public class CartaController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CartaBusiness cartabusiness;
	
	@Inject
	private PlatoBusiness platobusiness;
	
	private Carta carta;
	private List<Carta> cartas;
	private Carta cartaselect;
	
	private Plato plato;
	private List<Plato> platos;
	private Plato platoselect;
	
	private String filtername;
	
	@PostConstruct
	public void init() {
		/*new*/
		
		carta = new Carta();
		
		cartas = new ArrayList<Carta>();
		
		plato = new Plato();
		
		platos = new ArrayList<Plato>();
		
		getAllCartas();
	}
	
	public void getAllCartas() {
		try {
			cartas = cartabusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar cartas : " + e.getMessage());
		}
	}
	
	public String listCarta() {
		return "listcarta.xhtml";
	}
	
	public String saveCarta() {
		String view = "";
		try {
			if(carta.getIdcarta() != null) {
				cartabusiness.update(carta);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				cartabusiness.insert(carta);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllCartas();
			resetForm();
			view = "listcarta";
		}
		catch(Exception ex) {
			//Clase Utilitario
		}
		return view;
	}
	
	public String editCarta(){
		String view = "";
		try{
			if (this.cartaselect != null) {
				this.carta = cartaselect;
				view = "carta/update";
			}
			else {
				Message.messageError("Debe seleccionar un carta");
			}
		}
		catch(Exception ex){
			Message.messageError("Error en carta seleccionado: " + ex.getMessage());
		}
		return view;
	}
	
	public String deleteCarta() {
		
		String view = "";
		try{
			this.carta = cartaselect;
			cartabusiness.delete(this.carta);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllCartas();
			view = "listcarta";
		}
		catch(Exception ex){
			Message.messageError("Error en Carta : " + ex.getMessage());
		}
		return view;
	}
	
	public void resetForm() {
		this.carta = new Carta();
	}
	
	public void searchCartaByPlatoName() {
		try {
			cartas = cartabusiness.findByName(this.filtername.trim());
			resetForm();
			if (cartas.isEmpty()) {
				Message.messageInfo("No se encontraron cartas");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error al buscar Carta: " + ex.getMessage());
		}		
	}
	
	public void selectCarta(SelectEvent e){
		this.cartaselect = (Carta)e.getObject();
	}

	public CartaBusiness getCartabusiness() {
		return cartabusiness;
	}

	public void setCartabusiness(CartaBusiness cartabusiness) {
		this.cartabusiness = cartabusiness;
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	public Carta getCartaselect() {
		return cartaselect;
	}

	public void setCartaselect(Carta cartaselect) {
		this.cartaselect = cartaselect;
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

	public PlatoBusiness getPlatobusiness() {
		return platobusiness;
	}

	public void setPlatobusiness(PlatoBusiness platobusiness) {
		this.platobusiness = platobusiness;
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
}
