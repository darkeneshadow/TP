package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Mozo;
import pe.upc.model.repository.MozoRepository;

@Named
public class MozoBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MozoRepository mozoRepository;
	
	public List<Mozo> getAll() throws Exception {
		return mozoRepository.findAll();		
	}
	
	@Transactional
	public Long insert(Mozo mozo) throws Exception {
		return mozoRepository.insert(mozo);
	}

	public Long update(Mozo mozo) throws Exception {
		return mozoRepository.update(mozo);
	}

	public void delete(Mozo mozo) throws Exception {
		mozoRepository.delete(mozo);
	}
	
	public List<Mozo> findAll() throws Exception {
		return mozoRepository.findAll();		
	}
	
	public List<Mozo> findByName(String name) throws Exception {		
		return mozoRepository.findByNombre(name);
	}

}
