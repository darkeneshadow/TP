package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Carta;
import pe.upc.model.repository.CartaRepository;

@Named
public class CartaBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CartaRepository cartarepository;
	
	public List<Carta> getAll() throws Exception {
		return cartarepository.findAll();		
	}
	
	@Transactional
	public Long insert(Carta carta) throws Exception {
		return cartarepository.insert(carta);
	}

	public Long update(Carta carta) throws Exception {
		return cartarepository.update(carta);
	}

	public void delete(Carta carta) throws Exception {
		cartarepository.delete(carta);
	}
	
	public List<Carta> findAll() throws Exception {
		return cartarepository.findAll();		
	}
	
	public List<Carta> findByName(String name) throws Exception {		
		return cartarepository.findByName(name);
	}
}
