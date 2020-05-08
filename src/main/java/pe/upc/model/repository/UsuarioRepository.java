package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Usuario;

@Named
public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Usuario usuario) throws Exception{
		em.persist(usuario);
		return usuario.getIdUsuario();
	}
	
	public Long update(Usuario usuario) throws Exception{
		em.merge(usuario);
		return usuario.getIdUsuario();
	}
	
	public void delete(Usuario usuario) throws Exception{
		em.remove(usuario);
	}
	
	
	public List<Usuario> findAll() throws Exception{
		List<Usuario> usuario = new ArrayList<>();
		
		TypedQuery<Usuario> query = em.createQuery("FROM Usuario u", Usuario.class);
		usuario = query.getResultList();
		return usuario;
	}
	
	public List<Usuario> findByNombre(String name) throws Exception{
		List<Usuario> usuario = new ArrayList<>();
		
		TypedQuery<Usuario> query = em.createQuery("FROM Usuario u WHERE u.nombres LIKE ?1", Usuario.class);
		query.setParameter(1, "%" + name + "%");
		usuario = query.getResultList();
		return usuario;
	}

}
