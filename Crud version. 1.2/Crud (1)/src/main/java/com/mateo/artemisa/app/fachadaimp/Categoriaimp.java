package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.ICategoria;
import com.mateo.artemisa.app.modelo.Categorias;
import com.mateo.artemisa.app.modelo.Usuarios;
import com.mateo.artemisa.app.util.JPAUtil;

public class Categoriaimp implements ICategoria{

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public List<Categorias> obtenerTodos() {
		List<Categorias> listaCategoria = new ArrayList<Categorias>();
		Query hql = entity.createQuery("SELECT cat FROM Categorias cat");
		listaCategoria = hql.getResultList();
		return listaCategoria;
	}

	@Override
	public Categorias obtenerPorId(int idCategoriaProducto) {
		Categorias cat = new Categorias();
		cat = entity.find(Categorias.class, idCategoriaProducto);
		return cat;
	}

	@Override
	public void crearCategoria(Categorias categoria) {
		entity.getTransaction().begin();
		entity.persist(categoria);
		entity.getTransaction().commit();
	}

	@Override
	public void editarCategoria(Categorias categoria) {
		entity.getTransaction().begin();
		entity.merge(categoria);
		entity.getTransaction().commit();
	}

	@Override
	public void eliminarCategoria(int idCategoriaProducto) {
		Categorias cat = new Categorias();
		cat = entity.find(Categorias.class, idCategoriaProducto);
		entity.getTransaction().begin();
		entity.remove(cat);
		entity.getTransaction().commit();
	}
	
}
