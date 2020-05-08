package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Ingrediente;

@Named
public class IngredienteRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Ingrediente ingrediente) throws Exception {
		em.persist(ingrediente);
		return ingrediente.getIdingrediente();
	}

	public Long update(Ingrediente ingrediente) throws Exception {
		em.merge(ingrediente);
		return ingrediente.getIdingrediente();
	}

	public void delete(Ingrediente ingrediente) throws Exception {
		em.remove(ingrediente);
	}
	
	public List<Ingrediente> findAll() throws Exception {
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		TypedQuery<Ingrediente> query = em.createQuery("FROM Ingrediente i", Ingrediente.class);
		ingredientes = query.getResultList();
		
		return ingredientes;		
	}
	
	public List<Ingrediente> findByName(String nombreingrediente) throws Exception {
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		TypedQuery<Ingrediente> query = em.createQuery("FROM Ingrediente i WHERE i.nombreingrediente LIKE ?1", Ingrediente.class);
		query.setParameter(1, "%" + nombreingrediente + "%" );
		ingredientes = query.getResultList();
		
		return ingredientes;		
	}
	
}
