package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.IVenta;
import com.mateo.artemisa.app.modelo.Ventas;
import com.mateo.artemisa.app.util.JPAUtil;

public class Ventaimp implements IVenta {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();	
	@Override
	public List<Ventas> obtenerTodos() {
		List<Ventas> listaVentas = new ArrayList<Ventas>();
		Query hql = entity.createQuery("SELECT v FROM Ventas v");
		listaVentas = hql.getResultList();
		return listaVentas;
	}

	@Override
	public Ventas obtenerPorId(int idventa ) {
		Ventas vta = new Ventas();
		vta = entity.find(Ventas.class, idventa);
		return vta;
	}

	@Override
	public void crearVenta(Ventas venta) {
		entity.getTransaction().begin();
		entity.persist(venta);
		entity.getTransaction().commit();
	}

	@Override
	public void editarVenta(Ventas venta) {
		entity.getTransaction().begin();
		entity.merge(venta);
		entity.getTransaction().commit();
	}

	@Override
	public void eliminarVenta(int idventa) {
		Ventas vta = new Ventas();
		vta = entity.find(Ventas.class, idventa);
		entity.getTransaction().begin();
		entity.remove(vta);
		entity.getTransaction().commit();
		
	}

}
