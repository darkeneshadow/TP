package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.service.IClienteService;

@Named
@RequestScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IClienteService cService;
	private Cliente Cliente;
	List<Cliente> listaClientes;

	@PostConstruct
	public void init() {
		this.listaClientes = new ArrayList<Cliente>();
		this.Cliente = new Cliente();
		this.listar();
	}
	
	// metodos
	public String nuevoCliente() {
		this.setCliente(new Cliente());
		return "Cliente.xhtml";
	}
	public void insertar() {
		try {

			cService.insertar(Cliente);
			limpiarCliente();

			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listar() {
		try {
			listaClientes = cService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarCliente() {
		this.init();
	}
	public void eliminar(Cliente cl) {
		try {
			cService.eliminar(cl.getIdCliente());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	// get y set
	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente Cliente) {
		this.Cliente = Cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

}
