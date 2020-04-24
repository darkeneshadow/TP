package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Plato;

public interface IPlatoService {
	public void insertar(Plato plato);
	public List<Plato> listar();
	public void eliminar(int idPlato);
}
