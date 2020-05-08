package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Ingrediente;
import pe.upc.model.repository.IngredienteRepository;

@Named
public class IngredientesBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IngredienteRepository ingredienterepository;
	
	@Transactional
	public Long insert(Ingrediente ingrediente) throws Exception {
		return ingredienterepository.insert(ingrediente);
	}

	public Long update(Ingrediente ingrediente) throws Exception {
		return ingredienterepository.update(ingrediente);
	}

	public void delete(Ingrediente ingrediente) throws Exception {
		ingredienterepository.delete(ingrediente);
	}
	
	public List<Ingrediente> findAll() throws Exception {
		return ingredienterepository.findAll();
	}
	
	public List<Ingrediente> findByName(String nombreingrediente) throws Exception {
		return ingredienterepository.findByName(nombreingrediente);	
	}
	
}
