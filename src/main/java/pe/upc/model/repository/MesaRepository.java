package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Mesa;

@Named
public class MesaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Mesa mesa) throws Exception{
		em.persist(mesa);
		return mesa.getIdMesa();
	}
	
	public Long update(Mesa mesa) throws Exception{
		em.merge(mesa);
		return mesa.getIdMesa();
	}
	
	public void delete(Mesa mesa) throws Exception{
		em.remove(mesa);
	}
	
	
	public List<Mesa> findAll() throws Exception{
		List<Mesa> mesa = new ArrayList<>();
		
		TypedQuery<Mesa> query = em.createQuery("FROM Mesa m", Mesa.class);
		mesa = query.getResultList();
		return mesa;
	}
	
	public List<Mesa> findByEstado(String estado) throws Exception{
		List<Mesa> reserva = new ArrayList<>();
		
		TypedQuery<Mesa> query = em.createQuery("FROM Mesa m WHERE m.estado LIKE ?1", Mesa.class);
		query.setParameter(1, "%" + estado + "%");
		reserva = query.getResultList();
		return reserva;
	}

	public List<Mesa> findByZona(String zona) throws Exception{
		List<Mesa> reserva = new ArrayList<>();
		
		TypedQuery<Mesa> query = em.createQuery("FROM Mesa m WHERE m.zona LIKE ?1", Mesa.class);
		query.setParameter(1, "%" + zona + "%");
		reserva = query.getResultList();
		return reserva;
	}
}
