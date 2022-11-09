package com.mateo.artemisa.app.fachada;


import java.util.List;

import com.mateo.artemisa.app.modelo.Categorias;

public interface ICategoria {
   public List<Categorias> obtenerTodos();
   public Categorias obtenerPorId(int idCategoriaProducto);
   public void crearCategoria(Categorias categoria);
   public void editarCategoria(Categorias categoria);
   public void eliminarCategoria(int idCategoriaProducto);
}