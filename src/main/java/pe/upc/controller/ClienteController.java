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
import pe.upc.business.UsuarioBusiness;

import pe.upc.model.entity.Cliente;
import pe.upc.model.entity.Usuario;
import pe.upc.util.Message;

@Named
@SessionScoped
public class ClienteController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteBusiness clienteBusiness;
	
	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	private Cliente cliente;
	private List<Cliente> clientes;
	private Cliente clienteSelect;
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private Usuario usuarioSelect;
	
	private String filtername;
	
	@PostConstruct
	public void init() {
		
		cliente = new Cliente();
		
		clientes = new ArrayList<Cliente>();
		
		usuario = new Usuario();
		
		usuarios = new ArrayList<Usuario>();
		
		getAllClientes();
	}
	
	public void getAllClientes() {
		try {
			clientes=clienteBusiness.findAll();
		}
		catch(Exception e) {
			Message.messageError("Error al cargar clientes : " + e.getMessage());
		}
	}
	public String newCliente(){
		try{
			this.usuarios=usuarioBusiness.getAll();
		}
		catch(Exception ex){
			//
		}
		return "insertCliente.xhtml";
	}
	
	public String listCliente(){
		return "listcliente.xhtml";
	}
	
	public String saveCliente() {
		String view = "";
		try {
			if(cliente.getIdCliente() != null) {
				cliente.setUsuario(usuario);
				clienteBusiness.update(cliente);
				Message.messageInfo("Registro Actualizado Correctamente");
			}
			else {
				cliente.setUsuario(usuario);
				clienteBusiness.insert(cliente);
				Message.messageInfo("Registro Insertado Correctamente");
			}
			this.getAllClientes();
			resetForm();
			view = "listcliente";
		}
		catch(Exception ex) {
		}
		return view;
	}
	
	public String editCliente(){
		String view = "";
		try{
			if (this.clienteSelect != null) {
				this.cliente = clienteSelect;
				view = "cliente/update";
			}
			else {
				Message.messageError("Debe seleccionar un cliente");
			}
		}
		catch(Exception ex){
			Message.messageError("Error en cliente seleccionado: " + ex.getMessage());
		}
		return view;
	}
	
	public String deleteCliente() {
		
		String view = "";
		try{
			this.cliente = clienteSelect;
			clienteBusiness.delete(this.cliente);
			Message.messageInfo("Registro Eliminado Correctamente");
			this.getAllClientes();
			view = "listcliente";
		}
		catch(Exception ex){
			Message.messageError("Error en Cliente : " + ex.getMessage());
		}
		return view;
	}
	
	public void resetForm() {
		this.filtername = "";
		this.cliente = new Cliente();
		}
	
	public void searchClienteByName() {
		try {
			clientes = clienteBusiness.findByName(this.filtername.trim());
			resetForm();
			if (clientes.isEmpty()) {
				Message.messageInfo("No se encontraron clientes");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error al buscar Cliente: " + ex.getMessage());
		}		
	}
	
	public void selectCliente(SelectEvent e){
		this.clienteSelect = (Cliente)e.getObject();
	}

	public ClienteBusiness getClienteBusiness() {
		return clienteBusiness;
	}

	public void setClienteBusiness(ClienteBusiness clienteBusiness) {
		this.clienteBusiness = clienteBusiness;
	}

	public UsuarioBusiness getUsuarioBusiness() {
		return usuarioBusiness;
	}

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioSelect() {
		return usuarioSelect;
	}

	public void setUsuarioSelect(Usuario usuarioSelect) {
		this.usuarioSelect = usuarioSelect;
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
