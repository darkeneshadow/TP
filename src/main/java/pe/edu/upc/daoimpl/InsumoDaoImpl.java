package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import pe.edu.upc.dao.IInsumoDao;
import pe.edu.upc.entity.Insumo;

public class InsumoDaoImpl implements IInsumoDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "a")
	private EntityManager em;
	@Transactional
	@Override
	public void insertar(Insumo insumo) {
		try {
			em.persist(insumo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Insumo> listar() {
		List<Insumo> lista = new ArrayList<Insumo>();
		try {
			Query q = em.createQuery("select m from Insumo m");
			lista = (List<Insumo>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idInsumo) {
		Insumo ins = new Insumo();
		try {
			ins = em.getReference(Insumo.class, idInsumo);
			em.remove(ins);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
