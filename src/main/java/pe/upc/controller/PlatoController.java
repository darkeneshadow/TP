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
public class PlatoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PlatoBusiness platobusiness;
	
	@Inject
	private CartaBusiness cartabusiness;
	
	private Plato plato;
	private List<Plato> platos;
	private Plato platoselect;
	
	private Carta carta;
	private List<Carta> cartas;
	private Carta cartaselect;
	
	private String filtername;
	
	/*Post constructor*/
	@PostConstruct
	public void init() {
		/*new*/
		plato = new Plato();
		
		platos = new ArrayList<Plato>();
		
		carta = new Carta();
		
		cartas = new ArrayList<Carta>();
		
		getAllPlatos();
	}
	
	public void getAllPlatos() {
		try {
			platos = platobusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar platos : " + e.getMessage());
		}
	}
	
	public String newPlato() {
		try {
			this.cartas=cartabusiness.getAll();
		}
		catch(Exception ex) {
			
		}
		return "insertPlato.xhtml";
	}
	
	public String listPlato() {
		return "listplato.xhtml";
	}
	
	public String savePlato() {
		String view = "";
		try {
			if(plato.getIdplato() != null) {
				platobusiness.update(plato);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				platobusiness.insert(plato);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllPlatos();
			resetForm();
			view = "listplato";
		}
		catch(Exception ex) {}
		return view;
	}
	
	public String editPlato() {
		String view = "";
		try {
			if (this.platoselect != null) {
				this.plato = platoselect;
				view = "plato/update";
			}
			else {
				Message.messageError("Debe seleccionar un plato");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error en plato seleccionado: " + ex.getMessage());
		}
		return view;
	}
	
	public String deletePlato() {
		String view = "";
		try {		
			this.plato = platoselect;
			platobusiness.delete(this.plato);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllPlatos();
			view = "listplato";
		}
		catch(Exception ex) {
			Message.messageError("Error en Plato Seleccionado: " + ex.getMessage());
		}
		return view;	
	}
	
	public void resetForm() {
		this.filtername = "";
		this.plato = new Plato();
	}
	
	public void searchPlatoByName() {
		try {
			platos = platobusiness.findByName(this.filtername.trim());
			resetForm();
			if (platos.isEmpty()) {
				Message.messageInfo("No se encontraron platos");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error al buscar Plato: " + ex.getMessage());
		}		
	}
	
	public void selectPlato(SelectEvent e) {
		this.platoselect = (Plato)e.getObject();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFiltername() {
		return filtername;
	}

	public void setFiltername(String filtername) {
		this.filtername = filtername;
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
}
