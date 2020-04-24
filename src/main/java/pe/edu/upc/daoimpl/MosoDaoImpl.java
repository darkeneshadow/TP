package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import pe.edu.upc.dao.IMosoDao;
import pe.edu.upc.entity.Moso;

public class MosoDaoImpl implements IMosoDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "a")
	private EntityManager em;
	@Transactional
	@Override
	public void insertar(Moso moso) {
		try {
			em.persist(moso);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Moso> listar() {
		List<Moso> lista = new ArrayList<Moso>();
		try {
			Query q = em.createQuery("select m from Moso m");
			lista = (List<Moso>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idMoso) {
		Moso mos = new Moso();
		try {
			mos = em.getReference(Moso.class, idMoso);
			em.remove(mos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
