package eedd.ra3.hogwarts.dao;

import java.util.List;

import eedd.ra3.hogwarts.vo.Casa;

public interface ICasaDAO {
	public Casa obtenerCasaPorID(int identificador) ;
	public Casa actualizarCasa(Casa casa) ;
	public Casa crearCasa(Casa casa);
	public void borrarCasa(Casa casa);
	public List<Casa> obtenerListaCasas(); 
	public List<Casa> obtenerCasaPorNombre(String nombre);
}
