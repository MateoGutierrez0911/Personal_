package com.mateo.artemisa.app.fachada;

import java.util.List;

import com.mateo.artemisa.app.modelo.Ventas;

public interface IVenta {
	public List<Ventas> obtenerTodos();
	public Ventas obtenerPorId(int idVenta);
	public void crearVenta(Ventas venta);
	public void editarVenta(Ventas venta);
	public void eliminarVenta(int idVenta);
}



