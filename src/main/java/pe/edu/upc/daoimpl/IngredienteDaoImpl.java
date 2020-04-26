package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import pe.edu.upc.dao.IIngredienteDao;
import pe.edu.upc.entity.Ingrediente;

public class IngredienteDaoImpl implements IIngredienteDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "a")
	private EntityManager em;
	@Transactional
	@Override
	public void insertar(Ingrediente ingrediente) {
		try {
			em.persist(ingrediente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Ingrediente> listar() {
		List<Ingrediente> lista = new ArrayList<Ingrediente>();
		try {
			Query q = em.createQuery("select m from Ingrediente m");
			lista = (List<Ingrediente>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idIngrediente) {
		Ingrediente ing = new Ingrediente();
		try {
			ing = em.getReference(Ingrediente.class, idIngrediente);
			em.remove(ing);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
