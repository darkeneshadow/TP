package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IMosoDao;
import pe.edu.upc.entity.Moso;
import pe.edu.upc.service.IMosoService;

@Named
@RequestScoped
public class MosoServiceImpl implements IMosoService, Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private IMosoDao mD;
	
	@Override
	public void insertar(Moso moso) {
		mD.insertar(moso);
	}
	
	@Override
	public List<Moso> listar(){
		return mD.listar();
	}
	
	@Override
	public void eliminar(int idMoso) {
		mD.eliminar(idMoso);
	}
}
