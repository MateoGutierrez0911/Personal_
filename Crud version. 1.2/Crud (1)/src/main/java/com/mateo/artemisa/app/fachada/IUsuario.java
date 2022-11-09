package com.mateo.artemisa.app.fachada;

import java.util.List;

import com.mateo.artemisa.app.modelo.Usuarios;

public interface IUsuario {
	public List<Usuarios> obtenerTodos();
	public Usuarios obtenerPorId(int idUsuario);
	public void crearUsuarios(Usuarios usuarios);
	public void editarUsuarios(Usuarios usuarios);
	public void eliminarUsuarios(int idUsuario);
}
