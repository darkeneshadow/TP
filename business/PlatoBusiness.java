package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Plato;
import pe.upc.model.repository.PlatoRepository;

@Named
public class PlatoBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PlatoRepository platorepository;
	
	@Transactional
	public Long insert(Plato plato) throws Exception {
		return platorepository.insert(plato);
	}

	public Long update(Plato plato) throws Exception {
		return platorepository.update(plato);
	}

	public void delete(Plato plato) throws Exception {
		platorepository.delete(plato);
	}
	
	public List<Plato> findAll() throws Exception {
		return platorepository.findAll();		
	}
	
	public List<Plato> findByName(String nombreplato) throws Exception {
		return platorepository.findByName(nombreplato);
	}
	
}
