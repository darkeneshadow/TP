package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.DetallePlatoReserva;
import pe.upc.model.repository.DetallePlatoReservaRepository;

@Named
public class DetallePlatoReservaBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DetallePlatoReservaRepository detalleplatoreservarepository;
	
	@Transactional
	public Long insert(DetallePlatoReserva detalleplatoreserva) throws Exception {
		return detalleplatoreservarepository.insert(detalleplatoreserva);
	}

	public Long update(DetallePlatoReserva detalleplatoreserva) throws Exception {
		return detalleplatoreservarepository.update(detalleplatoreserva);
	}

	public void delete(DetallePlatoReserva detalleplatoreserva) throws Exception {
		detalleplatoreservarepository.delete(detalleplatoreserva);
	}
	
	public List<DetallePlatoReserva> findAll() throws Exception {
		return detalleplatoreservarepository.findAll();
	}
	
	public List<DetallePlatoReserva> findByName(String nombredetalleplatoreserva) throws Exception {
		return detalleplatoreservarepository.findByName(nombredetalleplatoreserva);
	}
	
}
