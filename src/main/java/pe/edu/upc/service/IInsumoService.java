package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Insumo;

public interface IInsumoService {
	public void insertar(Insumo insumo);
	public List<Insumo> listar();
	public void eliminar(int idInsumo);
}
