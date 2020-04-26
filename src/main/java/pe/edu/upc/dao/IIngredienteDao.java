package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Ingrediente;

public interface IIngredienteDao {
	public void insertar(Ingrediente ingrediente);
	public List<Ingrediente> listar();
	public void eliminar(int idIngrediente);
}
