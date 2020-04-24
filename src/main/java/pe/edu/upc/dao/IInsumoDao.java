package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Insumo;

public interface IInsumoDao {
	public void insertar(Insumo insumo);
	public List<Insumo> listar();
	public void eliminar(int idInsumo);
}
