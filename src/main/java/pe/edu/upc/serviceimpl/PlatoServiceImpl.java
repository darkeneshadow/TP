package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPlatoDao;
import pe.edu.upc.entity.Plato;
import pe.edu.upc.service.IPlatoService;

@Named
@RequestScoped
public class PlatoServiceImpl implements IPlatoService, Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private IPlatoDao pD;
	
	@Override
	public void insertar(Plato plato) {
		pD.insertar(plato);
	}
	
	@Override
	public List<Plato> listar(){
		return pD.listar();
	}
	
	@Override
	public void eliminar(int idPlato) {
		pD.eliminar(idPlato);
	}
}
