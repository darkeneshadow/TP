package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IIngredienteDao;
import pe.edu.upc.entity.Ingrediente;
import pe.edu.upc.service.IIngredienteService;

@Named
@RequestScoped
public class IngredienteServiceImpl implements IIngredienteService, Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private IIngredienteDao iD;
	
	@Override
	public void insertar(Ingrediente ingrediente) {
		iD.insertar(ingrediente);
	}
	
	@Override
	public List<Ingrediente> listar(){
		return iD.listar();
	}
	
	@Override
	public void eliminar(int idIngrediente) {
		iD.eliminar(idIngrediente);
	}
}
