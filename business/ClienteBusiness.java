package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Cliente;
import pe.upc.model.repository.ClienteRepository;

@Named
public class ClienteBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteRepository clienteRepository;
	
	public List<Cliente> getAll() throws Exception {
		return clienteRepository.findAll();		
	}
	@Transactional
	public Long insert(Cliente cliente) throws Exception {
		return clienteRepository.insert(cliente);
	}

	public Long update(Cliente cliente) throws Exception {
		return clienteRepository.update(cliente);
	}

	public void delete(Cliente cliente) throws Exception {
		clienteRepository.delete(cliente);
	}
	
	public List<Cliente> findAll() throws Exception {
		return clienteRepository.findAll();		
	}
	
	public List<Cliente> findByName(String name) throws Exception {		
		return clienteRepository.findByNombre(name);
	}

}
