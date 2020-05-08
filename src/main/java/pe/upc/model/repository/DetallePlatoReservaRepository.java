package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.DetallePlatoReserva;

@Named
public class DetallePlatoReservaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(DetallePlatoReserva detalleplatoreserva) throws Exception {
		em.persist(detalleplatoreserva);
		return detalleplatoreserva.getIddetalleplatoreserva();
	}

	public Long update(DetallePlatoReserva detalleplatoreserva) throws Exception {
		em.merge(detalleplatoreserva);
		return detalleplatoreserva.getIddetalleplatoreserva();
	}

	public void delete(DetallePlatoReserva detalleplatoreserva) throws Exception {
		em.remove(detalleplatoreserva);
	}
	
	public List<DetallePlatoReserva> findAll() throws Exception {
		List<DetallePlatoReserva> destallesplatosreservas = new ArrayList<>();
		
		TypedQuery<DetallePlatoReserva> query = em.createQuery("FROM DetallePlatoReserva d", DetallePlatoReserva.class);
		destallesplatosreservas = query.getResultList();
		
		return destallesplatosreservas;		
	}
	
	public List<DetallePlatoReserva> findByName(String nombredetalleplatoreserva) throws Exception {
		List<DetallePlatoReserva> destallesplatosreservas = new ArrayList<>();
		
		TypedQuery<DetallePlatoReserva> query = em.createQuery("FROM DetallePlatoReserva d WHERE d.PlatoPersonalizado.Plato.nombreplato LIKE ?1", DetallePlatoReserva.class);
		query.setParameter(1, "%" + nombredetalleplatoreserva + "%" );
		destallesplatosreservas = query.getResultList();
		
		return destallesplatosreservas;		
	}
	
}
