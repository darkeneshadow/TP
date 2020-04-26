package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Ingrediente;

public interface IIngredienteService {
	public void insertar(Ingrediente ingrediente);
	public List<Ingrediente> listar();
	public void eliminar(int idIngrediente);
}
