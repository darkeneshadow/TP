package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.PlatoPersonalizado;

@Named
public class PlatoPersonalizadoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(PlatoPersonalizado platopersonalizado) throws Exception {
		em.persist(platopersonalizado);
		return platopersonalizado.getIdplatopersonalizado();
	}

	public Long update(PlatoPersonalizado platopersonalizado) throws Exception {
		em.merge(platopersonalizado);
		return platopersonalizado.getIdplatopersonalizado();
	}

	public void delete(PlatoPersonalizado platopersonalizado) throws Exception {
		em.remove(platopersonalizado);
	}
	
	public List<PlatoPersonalizado> findAll() throws Exception {
		List<PlatoPersonalizado> platospersonalizados = new ArrayList<>();
		
		TypedQuery<PlatoPersonalizado> query = em.createQuery("FROM PlatoPersonalizado p", PlatoPersonalizado.class);
		platospersonalizados = query.getResultList();
		
		return platospersonalizados;		
	}
	
	public List<PlatoPersonalizado> findByName(String nombreplatopersonalizado) throws Exception {
		List<PlatoPersonalizado> platospersonalizados = new ArrayList<>();
		
		TypedQuery<PlatoPersonalizado> query = em.createQuery("FROM PlatoPersonalizado p WHERE p.Plato.nombreplato LIKE ?1", PlatoPersonalizado.class);
		query.setParameter(1, "%" + nombreplatopersonalizado + "%" );
		platospersonalizados = query.getResultList();
		
		return platospersonalizados;		
	}
	
}
