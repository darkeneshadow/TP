package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.PlatoPersonalizado;
import pe.upc.model.repository.PlatoPersonalizadoRepository;

@Named
public class PlatoPersonalizadoBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PlatoPersonalizadoRepository platopersonalizadorepository;
	
	@Transactional
	public Long insert(PlatoPersonalizado platopersonalizado) throws Exception {
		return platopersonalizadorepository.insert(platopersonalizado);
	}

	public Long update(PlatoPersonalizado platopersonalizado) throws Exception {
		return platopersonalizadorepository.update(platopersonalizado);
	}

	public void delete(PlatoPersonalizado platopersonalizado) throws Exception {
		platopersonalizadorepository.delete(platopersonalizado);
	}
	
	public List<PlatoPersonalizado> findAll() throws Exception {
		return platopersonalizadorepository.findAll();		
	}
	
	public List<PlatoPersonalizado> findByName(String nombreplatopersonalizado) throws Exception {
		return platopersonalizadorepository.findByName(nombreplatopersonalizado);	
	}
	
}
