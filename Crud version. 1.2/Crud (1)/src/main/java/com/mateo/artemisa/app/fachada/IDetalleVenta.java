package com.mateo.artemisa.app.fachada;

import java.util.List;

import com.mateo.artemisa.app.modelo.DetalleVentas;

public interface IDetalleVenta {
public List<DetalleVentas> obtenerTodos();
public DetalleVentas obtenerPorId(int idDetalleVenta);
public void crearDetalleVenta(DetalleVentas detalleVenta);
public void editarDetalleVenta(DetalleVentas detalleVenta);
public void eliminarDetalleVenta(int idDetalleVenta);
}
