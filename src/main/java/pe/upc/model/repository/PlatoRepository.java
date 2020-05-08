package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Plato;

@Named
public class PlatoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Plato plato) throws Exception {
		em.persist(plato);
		return plato.getIdplato();
	}

	public Long update(Plato plato) throws Exception {
		em.merge(plato);
		return plato.getIdplato();
	}

	public void delete(Plato plato) throws Exception {
		em.remove(plato);
	}
	
	public List<Plato> findAll() throws Exception {
		List<Plato> products = new ArrayList<>();
		
		TypedQuery<Plato> query = em.createQuery("FROM Plato p", Plato.class);
		products = query.getResultList();
		
		return products;		
	}
	
	public List<Plato> findByName(String nombreplato) throws Exception {
		List<Plato> products = new ArrayList<>();
		
		TypedQuery<Plato> query = em.createQuery("FROM Plato p WHERE p.nombreplato LIKE ?1", Plato.class);
		query.setParameter(1, "%" + nombreplato + "%" );
		products = query.getResultList();
		
		return products;		
	}
	
}
