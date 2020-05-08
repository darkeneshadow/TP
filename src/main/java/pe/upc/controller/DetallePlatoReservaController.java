package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.DetallePlatoReservaBusiness;
import pe.upc.business.PlatoPersonalizadoBusiness;
import pe.upc.business.ReservaBusiness;

import pe.upc.model.entity.DetallePlatoReserva;
import pe.upc.model.entity.PlatoPersonalizado;
import pe.upc.model.entity.Reserva;
import pe.upc.util.Message;

@Named
@SessionScoped
public class DetallePlatoReservaController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DetallePlatoReservaBusiness detalleplatoreservabusiness;
	
	@Inject
	private ReservaBusiness reservaBusiness;
	
	@Inject
	private PlatoPersonalizadoBusiness platopersonalizadobusiness;
	
	private DetallePlatoReserva detalleplatoreserva;
	private List<DetallePlatoReserva> detallesplatosreservas;
	private DetallePlatoReserva detalleplatoreservaselect;
	
	private Reserva reserva;
	private List<Reserva> reservas;
	private Reserva reservaSelect;
	
	private PlatoPersonalizado platopersonalizado;
	private List<PlatoPersonalizado> platospersonalizados;
	private PlatoPersonalizado platopersonalizadoselect;
	
	private String filtername;
	
	@PostConstruct
	public void init() {
		detalleplatoreserva = new DetallePlatoReserva();
		
		detallesplatosreservas = new ArrayList<DetallePlatoReserva>();
		
		reserva = new Reserva();

		reservas = new ArrayList<Reserva>();
		
		platopersonalizado = new PlatoPersonalizado();
		
		platospersonalizados = new ArrayList<PlatoPersonalizado>();
		
		getAllDetallesPlatosReservas();
		
	}
	
	public void getAllDetallesPlatosReservas() {
		try {
			detallesplatosreservas = detalleplatoreservabusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar los detalles de los platos : " + e.getMessage());
		}
	}
	
	public String listDetallePlatoReserva() {
		return "listdetalleplatoreserva.xhtml";
	}
	
	public String saveDetallePlatoReserva(){
		String view = "";
		try {
			if(detalleplatoreserva.getIddetalleplatoreserva()!=null){
				detalleplatoreserva.setPlatopersonalizado(platopersonalizado);
				detalleplatoreserva.setReserva(reserva);
				detalleplatoreservabusiness.update(detalleplatoreserva);	
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				detalleplatoreserva.setPlatopersonalizado(platopersonalizado);
				detalleplatoreserva.setReserva(reserva);
				detalleplatoreservabusiness.insert(detalleplatoreserva);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllDetallesPlatosReservas();
			resetForm();
			view = "listdetalleplatoreserva";
				
		}
		catch(Exception ex){
		}
		return view;
	}
	
	public String editDetallePlatoReserva(){
		String view = "";
		try{
			if (this.detalleplatoreservaselect != null) {
				this.detalleplatoreserva = detalleplatoreservaselect;
				view = "detalleplatoreserva/update";
			}
			else {
				Message.messageError("Debe seleccionar un detalleplatoreserva");
			}
		}
		catch(Exception ex){
			Message.messageError("Error en detalleplatoreserva seleccionado: " + ex.getMessage());
		}
		return view;
	}
	
	public String deleteDetallePlatoReserva() {
		
		String view = "";
		try{
			this.detalleplatoreserva = detalleplatoreservaselect;
			detalleplatoreservabusiness.delete(this.detalleplatoreserva);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllDetallesPlatosReservas();
			view = "listdetalleplatoreserva";
		}
		catch(Exception ex){
			Message.messageError("Error en DetallePlatoReserva : " + ex.getMessage());
		}
		return view;
	}
	
	public void resetForm() {
		this.filtername = "";
		
		this.detalleplatoreserva = new DetallePlatoReserva();
	}
	
	public void searchDetallePlatoReservaByName() {
		try {
			detallesplatosreservas = detalleplatoreservabusiness.findByName(this.filtername.trim());
			resetForm();
			if (detallesplatosreservas.isEmpty()) {
				Message.messageInfo("No se encontraron detalles de la reserva");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error al buscar  detalles de la reserva: " + ex.getMessage());
		}		
	}
	
	public void selectDetallePlatoReserva(SelectEvent e){
		this.detalleplatoreservaselect = (DetallePlatoReserva)e.getObject();
	}

	public DetallePlatoReservaBusiness getDetalleplatoreservabusiness() {
		return detalleplatoreservabusiness;
	}

	public void setDetalleplatoreservabusiness(DetallePlatoReservaBusiness detalleplatoreservabusiness) {
		this.detalleplatoreservabusiness = detalleplatoreservabusiness;
	}

	public ReservaBusiness getReservaBusiness() {
		return reservaBusiness;
	}

	public void setReservaBusiness(ReservaBusiness reservaBusiness) {
		this.reservaBusiness = reservaBusiness;
	}

	public PlatoPersonalizadoBusiness getPlatopersonalizadobusiness() {
		return platopersonalizadobusiness;
	}

	public void setPlatopersonalizadobusiness(PlatoPersonalizadoBusiness platopersonalizadobusiness) {
		this.platopersonalizadobusiness = platopersonalizadobusiness;
	}

	public DetallePlatoReserva getDetalleplatoreserva() {
		return detalleplatoreserva;
	}

	public void setDetalleplatoreserva(DetallePlatoReserva detalleplatoreserva) {
		this.detalleplatoreserva = detalleplatoreserva;
	}

	public List<DetallePlatoReserva> getDetallesplatosreservas() {
		return detallesplatosreservas;
	}

	public void setDetallesplatosreservas(List<DetallePlatoReserva> detallesplatosreservas) {
		this.detallesplatosreservas = detallesplatosreservas;
	}

	public DetallePlatoReserva getDetalleplatoreservaselect() {
		return detalleplatoreservaselect;
	}

	public void setDetalleplatoreservaselect(DetallePlatoReserva detalleplatoreservaselect) {
		this.detalleplatoreservaselect = detalleplatoreservaselect;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva getReservaSelect() {
		return reservaSelect;
	}

	public void setReservaSelect(Reserva reservaSelect) {
		this.reservaSelect = reservaSelect;
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
