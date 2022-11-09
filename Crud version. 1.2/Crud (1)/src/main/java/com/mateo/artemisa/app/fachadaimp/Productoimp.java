package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.IProducto;
import com.mateo.artemisa.app.modelo.Productos;
import com.mateo.artemisa.app.util.JPAUtil;

public class Productoimp implements IProducto{
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public List<Productos> obtenerTodos() {
		List<Productos> listaProducto = new ArrayList<Productos>();
		Query hql = entity.createQuery("SELECT pr FROM Productos pr");
		listaProducto = hql.getResultList();
		return listaProducto;
	}

	@Override
	public Productos obtenerPorId(int idproducto) {
		Productos pro = new Productos();
		pro = entity.find(Productos.class, idproducto);
		return pro;
	}

	@Override
	public void crearProducto(Productos producto) {
		entity.getTransaction().begin();
		entity.persist(producto);
		entity.getTransaction().commit();
		
	}

	@Override
	public void editarProducto(Productos producto) {
		entity.getTransaction().begin();
		entity.merge(producto);
		entity.getTransaction().commit();
	}

	@Override
	public void eliminarProducto(int idproducto) {
		Productos pro = new Productos();
		pro = entity.find(Productos.class, idproducto);
		entity.getTransaction().begin();
		entity.remove(pro);
		entity.getTransaction().commit();
	}

}
