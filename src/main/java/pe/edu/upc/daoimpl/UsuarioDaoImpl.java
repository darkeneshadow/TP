package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entity.Usuario;

public class UsuarioDaoImpl implements IUsuarioDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "a")
	private EntityManager em;
	@Transactional
	@Override
	public void insertar(Usuario usuario) {
		try {
			em.persist(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			Query q = em.createQuery("select m from Usuario m");
			lista = (List<Usuario>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idUsuario) {
		Usuario usu = new Usuario();
		try {
			usu = em.getReference(Usuario.class, idUsuario);
			em.remove(usu);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
