package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Carta;

@Named
public class CartaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Carta carta) throws Exception {
		em.persist(carta);
		return carta.getIdcarta();
	}

	public Long update(Carta carta) throws Exception {
		em.merge(carta);
		return carta.getIdcarta();
	}

	public void delete(Carta carta) throws Exception {
		em.remove(carta);
	}
	
	public List<Carta> findAll() throws Exception {
		List<Carta> cartas = new ArrayList<>();
		
		TypedQuery<Carta> query = em.createQuery("FROM Carta c", Carta.class);
		cartas = query.getResultList();
		
		return cartas;		
	}
	
	//Buscar cartas por el nombre del plato desde la vista cartas
	public List<Carta> findByName(String name) throws Exception{
		List<Carta> carta = new ArrayList<>();
		
		TypedQuery<Carta> query = em.createQuery("FROM Carta c WHERE c.Plato.nombreplato LIKE ?1", Carta.class);
		query.setParameter(1, "%" + name + "%");
		carta = query.getResultList();
		return carta;
	}
}
