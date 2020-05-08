package pe.upc.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.upc.model.entity.Reserva;
import pe.upc.model.repository.ReservaRepository;

@Named
public class ReservaBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ReservaRepository reservaRepository;
	
	public List<Reserva> getAll() throws Exception {
		return reservaRepository.findAll();		
	}
	
	@Transactional
	public Long insert(Reserva reserva) throws Exception {
		return reservaRepository.insert(reserva);
	}

	public Long update(Reserva reserva) throws Exception {
		return reservaRepository.update(reserva);
	}

	public void delete(Reserva reserva) throws Exception {
		reservaRepository.delete(reserva);
	}
	
	public List<Reserva> findAll() throws Exception {
		return reservaRepository.findAll();		
	}
	
	public List<Reserva> findByName(String name) throws Exception {		
		return reservaRepository.findByName(name);
	}

}
