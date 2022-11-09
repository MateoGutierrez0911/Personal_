package com.mateo.artemisa.app.fachada;

import java.util.List;

import com.mateo.artemisa.app.modelo.DetalleAlquileres;

public interface IDetalleAlquiler {
public List<DetalleAlquileres> obtenerTodos();
public DetalleAlquileres obtenerPorId(int iddetalle_Alquiler);
public void crearDetalleAlquileres(DetalleAlquileres detalleAlquiler);
public void editarDetalleAlquileres(DetalleAlquileres detalleAlquiler);
public void eliminarDetalleAlquileres(int iddetalle_Alquiler);
}
