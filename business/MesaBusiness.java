package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Mesa;
import pe.upc.model.repository.MesaRepository;

@Named
public class MesaBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MesaRepository mesaRepository;
	
	public List<Mesa> getAll() throws Exception {
		return mesaRepository.findAll();		
	}
	
	@Transactional
	public Long insert(Mesa mesa) throws Exception {
		return mesaRepository.insert(mesa);
	}

	public Long update(Mesa mesa) throws Exception {
		return mesaRepository.update(mesa);
	}

	public void delete(Mesa mesa) throws Exception {
		mesaRepository.delete(mesa);
	}
	
	public List<Mesa> findAll() throws Exception {
		return mesaRepository.findAll();		
	}
	
	public List<Mesa> findByEstado(String estado) throws Exception {		
		return mesaRepository.findByEstado(estado);
	}

	public List<Mesa> findByZona(String zona) throws Exception {		
		return mesaRepository.findByZona(zona);
	}
}
