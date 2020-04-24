package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Mesa;

public interface IMesaService {
	public void insertar(Mesa mesa);
	public List<Mesa> listar();
	public void eliminar(int idMesa);
}
