package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Moso;

public interface IMosoDao {
	public void insertar(Moso moso);
	public List<Moso> listar();
	public void eliminar(int idMoso);
}
