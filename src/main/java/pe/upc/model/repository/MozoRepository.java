package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Mozo;

@Named
public class MozoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Mozo mozo) throws Exception{
		em.persist(mozo);
		return mozo.getIdMozo();
	}
	
	public Long update(Mozo mozo) throws Exception{
		em.merge(mozo);
		return mozo.getIdMozo();
	}
	
	public void delete(Mozo mozo) throws Exception{
		em.remove(mozo);
	}
	
	
	public List<Mozo> findAll() throws Exception{
		List<Mozo> mozo = new ArrayList<>();
		
		TypedQuery<Mozo> query = em.createQuery("FROM Mozo m", Mozo.class);
		mozo = query.getResultList();
		return mozo;
	}
	
	public List<Mozo> findByNombre(String name) throws Exception{
		List<Mozo> mozo = new ArrayList<>();
		
		TypedQuery<Mozo> query = em.createQuery("FROM Mozo m WHERE m.Usuario.nombres LIKE ?1", Mozo.class);
		query.setParameter(1, "%" + name + "%");
		mozo = query.getResultList();
		return mozo;
	}

}
