package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Cliente;

@Named
public class ClienteRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Cliente cliente) throws Exception{
		em.persist(cliente);
		return cliente.getIdCliente();
	}
	
	public Long update(Cliente cliente) throws Exception{
		em.merge(cliente);
		return cliente.getIdCliente();
	}
	
	public void delete(Cliente cliente) throws Exception{
		em.remove(cliente);
	}
	
	
	public List<Cliente> findAll() throws Exception{
		List<Cliente> cliente = new ArrayList<>();
		
		TypedQuery<Cliente> query = em.createQuery("FROM Cliente c", Cliente.class);
		cliente = query.getResultList();
		return cliente;
	}
	
	public List<Cliente> findByNombre(String name) throws Exception{
		List<Cliente> cliente = new ArrayList<>();
		
		TypedQuery<Cliente> query = em.createQuery("FROM Cliente c WHERE c.Usuario.nombres LIKE ?1", Cliente.class);
		query.setParameter(1, "%" + name + "%");
		cliente = query.getResultList();
		return cliente;
	}

}
