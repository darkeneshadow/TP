package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import pe.edu.upc.dao.IPlatoDao;
import pe.edu.upc.entity.Plato;

public class PlatoDaoImpl implements IPlatoDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "a")
	private EntityManager em;
	@Transactional
	@Override
	public void insertar(Plato plato) {
		try {
			em.persist(plato);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Plato> listar() {
		List<Plato> lista = new ArrayList<Plato>();
		try {
			Query q = em.createQuery("select m from Plato m");
			lista = (List<Plato>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idPlato) {
		Plato pla = new Plato();
		try {
			pla = em.getReference(Plato.class, idPlato);
			em.remove(pla);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
