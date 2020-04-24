package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Mesa;

public interface IMesaDao {
	public void insertar(Mesa mesa);
	public List<Mesa> listar();
	public void eliminar(int idMesa);
}
