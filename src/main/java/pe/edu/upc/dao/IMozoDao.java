package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Mozo;

public interface IMozoDao {
	public void insertar(Mozo mozo);
	public List<Mozo> listar();
	public void eliminar(int idMozo);
}
