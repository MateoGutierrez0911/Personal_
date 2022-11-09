package com.mateo.artemisa.app.fachada;

import java.util.List;

import com.mateo.artemisa.app.modelo.Alquileres;

public interface IAlquiler {
	public List<Alquileres> obtenerTodos();
	public Alquileres obtenerPorId(int idAlquiler);
	public void createAlquiler(Alquileres alquiler);
	public void editarAlquiler(Alquileres alquiler);
	public void eliminarAlquiler(int idAlquiler);
	
}
