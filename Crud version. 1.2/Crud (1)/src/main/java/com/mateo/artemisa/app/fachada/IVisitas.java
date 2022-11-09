package com.mateo.artemisa.app.fachada;

import java.util.List;

import com.mateo.artemisa.app.modelo.Visitas;

public interface IVisitas {
	public List<Visitas> obtenerTodos();
	public Visitas obtenerPorId(int idVisita);
	public void crearVisitas(Visitas visitas);
	public void editarVisitas(Visitas visitas);
	public void eliminarVisitas(int idVisita);
}
