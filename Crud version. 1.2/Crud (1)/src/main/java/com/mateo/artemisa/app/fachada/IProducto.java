package com.mateo.artemisa.app.fachada;


import java.util.List;

import com.mateo.artemisa.app.modelo.Productos;

public interface IProducto {
   public List<Productos> obtenerTodos();
   public Productos obtenerPorId(int idProducto);
   public void crearProducto(Productos producto);
   public void editarProducto(Productos producto);
   public void eliminarProducto(int idProducto);
}