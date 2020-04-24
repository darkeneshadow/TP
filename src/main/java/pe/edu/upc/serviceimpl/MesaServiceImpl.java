package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IMesaDao;
import pe.edu.upc.entity.Mesa;
import pe.edu.upc.service.IMesaService;

@Named
@RequestScoped
public class MesaServiceImpl implements IMesaService, Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private IMesaDao mD;
	
	@Override
	public void insertar(Mesa mesa) {
		mD.insertar(mesa);
	}
	
	@Override
	public List<Mesa> listar(){
		return mD.listar();
	}
	
	@Override
	public void eliminar(int idMesa) {
		mD.eliminar(idMesa);
	}
}
