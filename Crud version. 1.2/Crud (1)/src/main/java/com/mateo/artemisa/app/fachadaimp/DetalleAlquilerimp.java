package com.mateo.artemisa.app.fachadaimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateo.artemisa.app.fachada.IDetalleAlquiler;
import com.mateo.artemisa.app.modelo.DetalleAlquileres;
import com.mateo.artemisa.app.util.JPAUtil;

public class DetalleAlquilerimp implements IDetalleAlquiler {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public List<DetalleAlquileres> obtenerTodos() {
		List<DetalleAlquileres> listaDetalleAlquiler = new ArrayList<DetalleAlquileres>();
		Query hql =entity.createQuery("SELECT e FROM DetalleAlquileres e");
		listaDetalleAlquiler = hql.getResultList();
		return listaDetalleAlquiler;
	}

	@Override
	public DetalleAlquileres obtenerPorId(int iddetalle_Alquiler) {
		DetalleAlquileres dta = new DetalleAlquileres();
		dta = entity.find(DetalleAlquileres.class, iddetalle_Alquiler);
		return dta;
	}

	@Override
	public void crearDetalleAlquileres(DetalleAlquileres detalleAlquiler) {
		entity.getTransaction().begin();
		entity.persist(detalleAlquiler);
		entity.getTransaction().commit();
	}

	@Override
	public void editarDetalleAlquileres(DetalleAlquileres detalleAlquiler) {
		entity.getTransaction().begin();
		entity.merge(detalleAlquiler);
		entity.getTransaction().commit();
	}

	@Override
	public void eliminarDetalleAlquileres(int iddetalle_Alquiler) {
		DetalleAlquileres dta = new DetalleAlquileres();
		dta = entity.find(DetalleAlquileres.class, iddetalle_Alquiler);
		entity.getTransaction().begin();
		entity.remove(dta);
		entity.getTransaction().commit();
	}
	
}
