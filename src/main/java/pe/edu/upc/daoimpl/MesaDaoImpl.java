package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import pe.edu.upc.dao.IMesaDao;
import pe.edu.upc.entity.Mesa;

public class MesaDaoImpl implements IMesaDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "a")
	private EntityManager em;
	@Transactional
	@Override
	public void insertar(Mesa mesa) {
		try {
			em.persist(mesa);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Mesa> listar() {
		List<Mesa> lista = new ArrayList<Mesa>();
		try {
			Query q = em.createQuery("select m from Mesa m");
			lista = (List<Mesa>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idMesa) {
		Mesa mes = new Mesa();
		try {
			mes = em.getReference(Mesa.class, idMesa);
			em.remove(mes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
