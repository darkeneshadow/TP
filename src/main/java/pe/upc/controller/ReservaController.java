package pe.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.upc.business.ClienteBusiness;
import pe.upc.business.MesaBusiness;
import pe.upc.business.MozoBusiness;
import pe.upc.business.ReservaBusiness;
import pe.upc.business.CartaBusiness;

import pe.upc.model.entity.Carta;
import pe.upc.model.entity.Cliente;
import pe.upc.model.entity.Mesa;
import pe.upc.model.entity.Mozo;
import pe.upc.model.entity.Reserva;
import pe.upc.util.Message;

@Named
@SessionScoped
public class ReservaController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ReservaBusiness reservaBusiness;
	
	@Inject
	private CartaBusiness cartabusiness;
	
	@Inject
	private MesaBusiness mesaBusiness;
	
	@Inject
	private MozoBusiness mozoBusiness;
	
	@Inject
	private ClienteBusiness clienteBusiness;
	
	private Mesa mesa;
	private List<Mesa> mesas;
	private Mesa mesaSelect;
	
	private Carta carta;
	private List<Carta> cartas;
	private Carta cartaselect;
	
	private Reserva reserva;
	private List<Reserva> reservas;
	private Reserva reservaSelect;
	
	private Cliente cliente;
	private List<Cliente> clientes;
	private Cliente clienteSelect;
	
	private Mozo mozo;
	private List<Mozo> mozos;
	private Mozo mozoSelect;
	
	private String filtername;
	
	@PostConstruct
	public void init() {

		reserva = new Reserva();

		reservas = new ArrayList<Reserva>();
		
		mesa = new Mesa();
		
		mesas = new ArrayList<Mesa>();
		
		cliente = new Cliente();
		
		clientes = new ArrayList<Cliente>();
		
		carta = new Carta();
		
		cartas = new ArrayList<Carta>();
		
		mozo = new Mozo();
		
		mozos = new ArrayList<Mozo>();
		
		getAllReservas();
	}
	
	public void getAllReservas() {
		try {
			reservas=reservaBusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar reservas : " + e.getMessage());
		}
	}
	
	public String newReserva(){
		try{
			this.cartas=cartabusiness.getAll();
			this.mesas=mesaBusiness.getAll();
			this.clientes=clienteBusiness.getAll();
			this.mozos=mozoBusiness.getAll();
		}
		catch(Exception ex){
			//
		}
		return "insertReserva.xhtml";
	}
	
	public String listReserva(){
		return "listreserva.xhtml";
	}
	
	public String saveReserva(){
		String view = "";
		try {
			if(reserva.getIdReserva()!=null){
				reserva.setCarta(carta);
				reserva.setMesa(mesa);
				reserva.setCliente(cliente);
				reserva.setMozo(mozo);
				reservaBusiness.update(reserva);	
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				reserva.setCarta(carta);
				reserva.setMesa(mesa);
				reserva.setCliente(cliente);
				reserva.setMozo(mozo);
				reservaBusiness.insert(reserva);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllReservas();
			resetForm();
			view = "listreserva";
				
		}
		catch(Exception ex){
			//Clase Utilitario
		}
		return view;
	}
	
	public String editReserva(){
		String view = "";
		try{
			if (this.reservaSelect != null) {
				this.reserva = reservaSelect;
				view = "reserva/update";
			}
			else {
				Message.messageError("Debe seleccionar una reserva");
			}
		}
		catch(Exception ex){
			Message.messageError("Error en reserva seleccionada: " + ex.getMessage());
		}
		return view;
	}
	
	public String deleteReserva() {
		
		String view = "";
		try{
			this.reserva = reservaSelect;
			reservaBusiness.delete(this.reserva);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllReservas();
			view = "listreserva";
		}
		catch(Exception ex){
			Message.messageError("Error en Reserva : " + ex.getMessage());
		}
		return view;
	}
	
	public void resetForm() {
		this.filtername = "";
		this.reserva = new Reserva();
	}
	
	public void searchReservaByName(){
		try {
			reservas = reservaBusiness.findByName(this.filtername.trim());
			resetForm();
			if (reservas.isEmpty()){
				Message.messageInfo("No se encontraron reservas para este cliente");
			}
		}
		catch(Exception ex){
			Message.messageError("Error al buscar Reserva: " + ex.getMessage());
		}
	}
	
	public void selectReserva(SelectEvent e){
		this.reservaSelect = (Reserva)e.getObject();
	}

	public ReservaBusiness getReservaBusiness() {
		return reservaBusiness;
	}

	public void setReservaBusiness(ReservaBusiness reservaBusiness) {
		this.reservaBusiness = reservaBusiness;
	}

	public CartaBusiness getCartabusiness() {
		return cartabusiness;
	}

	public void setCartabusiness(CartaBusiness cartabusiness) {
		this.cartabusiness = cartabusiness;
	}

	public MesaBusiness getMesaBusiness() {
		return mesaBusiness;
	}

	public void setMesaBusiness(MesaBusiness mesaBusiness) {
		this.mesaBusiness = mesaBusiness;
	}

	public MozoBusiness getMozoBusiness() {
		return mozoBusiness;
	}

	public void setMozoBusiness(MozoBusiness mozoBusiness) {
		this.mozoBusiness = mozoBusiness;
	}

	public ClienteBusiness getClienteBusiness() {
		return clienteBusiness;
	}

	public void setClienteBusiness(ClienteBusiness clienteBusiness) {
		this.clienteBusiness = clienteBusiness;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Mesa getMesaSelect() {
		return mesaSelect;
	}

	public void setMesaSelect(Mesa mesaSelect) {
		this.mesaSelect = mesaSelect;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getClienteSelect() {
		return clienteSelect;
	}

	public void setClienteSelect(Cliente clienteSelect) {
		this.clienteSelect = clienteSelect;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public List<Mozo> getMozos() {
		return mozos;
	}

	public void setMozos(List<Mozo> mozos) {
		this.mozos = mozos;
	}

	public Mozo getMozoSelect() {
		return mozoSelect;
	}

	public void setMozoSelect(Mozo mozoSelect) {
		this.mozoSelect = mozoSelect;
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
	
