package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Plato;

public interface IPlatoDao {
	public void insertar(Plato plato);
	public List<Plato> listar();
	public void eliminar(int idPlato);
}
