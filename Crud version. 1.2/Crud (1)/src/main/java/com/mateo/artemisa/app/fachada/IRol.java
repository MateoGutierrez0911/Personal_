package com.mateo.artemisa.app.fachada;

import java.util.List;

import com.mateo.artemisa.app.modelo.Rol;

public interface IRol {
	public List<Rol> obtenerTodos();
	public Rol obtenerPorId(int idRol);

}
