package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IInsumoDao;
import pe.edu.upc.entity.Insumo;
import pe.edu.upc.service.IInsumoService;

@Named
@RequestScoped
public class InsumoServiceImpl implements IInsumoService, Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private IInsumoDao iD;
	
	@Override
	public void insertar(Insumo insumo) {
		iD.insertar(insumo);
	}
	
	@Override
	public List<Insumo> listar(){
		return iD.listar();
	}
	
	@Override
	public void eliminar(int idInsumo) {
		iD.eliminar(idInsumo);
	}
}
