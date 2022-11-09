package com.mateo.artemisa.app.fachada;


import java.util.List;

import com.mateo.artemisa.app.modelo.TipoVentaAlquileres;

public interface ITipoventaalquiler {
   public List<TipoVentaAlquileres> obtenerTodos();
   public TipoVentaAlquileres obtenerPorId(int idTipoVentaAlquiler);
   public void crearTipoVentaAlquiler(TipoVentaAlquileres Tipoventaalquiler);
   public void editarTipoVentaAlquiler(TipoVentaAlquileres Tipoventaalquiler);
   public void eliminarTipoVentaAlquiler(int idTipoVentaAlquiler);
}