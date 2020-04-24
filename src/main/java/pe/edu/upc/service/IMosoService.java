package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Moso;

public interface IMosoService {
	public void insertar(Moso moso);
	public List<Moso> listar();
	public void eliminar(int idMoso);
}
